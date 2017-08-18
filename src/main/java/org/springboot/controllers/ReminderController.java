package org.springboot.controllers;

import org.springboot.models.Todo;
import org.springboot.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Chandan Jagadesh on 7/20/2017.
 * Controller class which listens to accept the JSON Request body and passes it on to service layer/Service class.
 * This class also responds to the request with appropriate response messages
 */

@RestController
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    // This method listens to map JSON request and add it to database
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String add(@RequestBody Todo todo){

        try {
            reminderService.add(todo);
            System.out.println(todo.getName());
            System.out.println(todo.getDuedate());
            System.out.println(todo.getDescription());
            System.out.println(todo.getDuedate());

            return "Reminder added to calendar";

        }
        catch(Exception ex){
                return "Write error, invalid field values, check for null values";
        }
    }

    // This method listens and gets the records from database based on the filter values
    // The response list will be converted to JSON by Jackson
    @RequestMapping(method = RequestMethod.GET, value = "/get/{filterDueDate}/{condition}/{filterstatus}")
    public List<Todo> getDbBoth(@PathVariable String filterDueDate, @PathVariable String filterstatus,@PathVariable String condition){
            // this search is based on duedate or status
            return reminderService.getFilterBoth(filterDueDate, filterstatus,condition);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/duedate/{filterDueDate}")
    public List<Todo> getDbDate(@PathVariable String filterDueDate){
        // this search is based on duedate
        return reminderService.getFilterDate(filterDueDate);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/status/{filterstatus}")
    public List<Todo> getDbStatus(@PathVariable String filterstatus){
        // this search is based on status
        return reminderService.getFilterStatus(filterstatus);
    }

    // This method fetches all the reminder records from the database, the response will be converted to JSON by Jackson
    @RequestMapping(method = RequestMethod.GET, value = "/getall")
    public List<Todo> getAll(){
        return reminderService.getAllReminder();
    }

    // This method listens to map JSON request and updates records based on name of the reminder
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public String update(@RequestBody Todo todo){

        try{
            System.out.println(todo.getName());
            System.out.println(todo.getDuedate());
            System.out.println(todo.getDescription());
            System.out.println(todo.getDuedate());
            int i = reminderService.updateReminder(todo);

            if(i>0) {
                return "Request updated in Calendar";
            }
            else{
                // The updates are designed to be based on reminder name, if the name is not present the below message is displayed
                return "Calender was not updated, the reminder name used might not be present on the calendar";
            }
        }
        catch(Exception ex){
            return "Write error, invalid field values, check for null values";
        }
    }
}