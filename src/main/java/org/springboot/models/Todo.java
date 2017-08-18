package org.springboot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Chandan Jagadesh on 7/20/2017.
 * Pojo class that defines the structure of the database table
 * and also the expected structure of request - response body
 */

@Entity
@Table(name="reminders")// Table in Database will exist with this name. If table doesn't exist, a new one will be created by this name.
public class Todo {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @NotNull
        private String name;
        private String description;
        @NotNull
        private String duedate;
        @NotNull
        private String status;

        public Todo() { }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDuedate() {
            return duedate;
        }

        public void setDuedate(String duedate) {
            this.duedate = duedate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
}
