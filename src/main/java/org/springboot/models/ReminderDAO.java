package org.springboot.models;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Chandan Jagadesh on 7/20/2017.
 * Data access layer which processes the pojo objects and performs the CRUD operations accordingly
 * This class uses the Hibernate Session Factory to read/write into database
 */
@Repository
@Transactional
public class ReminderDAO {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void add(Todo todo) {
        getSession().save(todo);
        return;
    }
    public List<Todo> getAllReminder(){
        String hql = "from Todo order by duedate desc";
        return (List<Todo>) getSession().createQuery(hql).list();
    }
    public List<Todo> getFilterBoth(String filterduedate, String filterstatus, String condition){
        String hql = "";
        if(condition.equals("and")){
            hql = "from Todo where duedate = :filterduedate and status = :filterstatus order by duedate desc";
        }
        else if(condition.equals("or")){
            hql = "from Todo where duedate = :filterduedate or status = :filterstatus order by duedate desc";
        }
        Query query = getSession().createQuery(hql);
        query.setParameter("filterduedate", filterduedate);
        query.setParameter("filterstatus", filterstatus);
        return (List<Todo>) query.list();
    }
    public List<Todo> getFilterDate(String filterduedate){
        String hql = "from Todo where duedate = :filterduedate order by duedate desc";
        Query query = getSession().createQuery(hql);
        query.setParameter("filterduedate",filterduedate);
        return (List<Todo>) query.list();
    }
    public List<Todo> getFilterStatus(String filterstatus){
        String hql = "from Todo where status = :filterstatus order by duedate desc";
        Query query = getSession().createQuery(hql);
         query.setParameter("filterstatus",filterstatus);
        return (List<Todo>) query.list();
    }

    public int updateReminder(Todo todo){
        String hql = "update Todo set description = :description, duedate = :duedate, status = :status where name = :name";
        Query query = getSession().createQuery(hql);
        query.setParameter("name",todo.getName());
        query.setParameter("description",todo.getDescription());
        query.setParameter("status",todo.getStatus());
        query.setParameter("duedate",todo.getDuedate());
        return query.executeUpdate();
    }
}
