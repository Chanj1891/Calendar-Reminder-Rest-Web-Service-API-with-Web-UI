package org.springboot.service;
import org.springboot.models.ReminderDAO;
import org.springboot.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Chandan Jagadesh on 7/20/2017.
 * Service class, which calls the methods in DAO class, a model class
 * If a presentation layer is added then this class can be used in combination with that
 */

@Service
public class ReminderService {

    @Autowired
    private ReminderDAO reminderDAO;

    public void add(Todo todo){
        reminderDAO.add(todo);
    }

    public List<Todo> getAllReminder()
    {
        List<Todo> todo = reminderDAO.getAllReminder();
        return todo;
    }

    public int updateReminder(Todo todo){
        return reminderDAO.updateReminder(todo);
    }

    public List<Todo> getFilterBoth(String filterduedate, String filterstatus, String condition){

        List<Todo> todo = reminderDAO.getFilterBoth(filterduedate,filterstatus,condition);
        return todo;
    }
    public List<Todo> getFilterDate(String filterduedate){

        List<Todo> todo = reminderDAO.getFilterDate(filterduedate);
        return todo;
    }
    public List<Todo> getFilterStatus(String filterstatus){

        List<Todo> todo = reminderDAO.getFilterStatus(filterstatus);
        return todo;
    }

}
