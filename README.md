# Calendar-Reminder-Rest-Web-Service
Rest API CRUD operations using Spring boot + Hibernate + MySQL

## Add, Update and Get reminders from MySQL by passing JSON requests to the REST API

### Build and run

#### Tools required

- MySQL
- IDE (Eclipse, IntelliJ IDEA, etc ...)
- Postman or SOAP UI
#### Web framework Stack

- Spring Boot
- Hibernate ORM
- Maven
- Tomcat
#### Configurations

The host system MySQL local server settings should match with configurations in `application.properties` file.

#### From Eclipse (Spring Tool Suite)

Import as *Existing Maven Project* and run it as *Spring Boot App*.

#### From Intellij IDEA (Spring Tool Suite)

Open project from Existing sources, Import as a Maven build and run it.

### Field restrictions
- Name of the reminder cannot be null
- DueDate of the reminder cannot be null
- Status of the reminder cannot be null
- Description can be null
- Updates are done based on Name of the reminder

## Usage

- Run the application and go onto a tool to pass json requests.
#### Add Reminder
- Pass the below Json request as a POST request to http://localhost:9000/add
- 
          {
              "name" : "firstreminder",
              "description" : "firstreminderdescription",
              "duedate": "2017-08-15",
              "status" : "open"
          }
#### Update Reminder
- Pass the below Json request as a PUT request to http://localhost:9000/update
- 
          {
              "name" : "firstreminder",
              "description" : "firstreminderdescription",
              "duedate": "2017-08-15",
              "status" : "close"
          }
#### Get all Reminders
- Invoke a GET request to http://localhost:9000/getall
- A single/chain of Json values as shown below can be expected. 
-       [
            {
                "name": "firstreminder",
                "description": "firstreminderdescription",
                "duedate": "2017-08-15",
                "status": "close"
            },
            {
                "name": "secondreminder",
                "description": "secondreminderdescription",
                "duedate": "2017-09-15",
                "status": "open"
            }
        ] 
#### Get filtered (and) Reminders based on DueDate and Status value
- To retrieve, invoke a GET request in following manner http://localhost:9000/get/2017-08-15/and/close
- A single/chain of Json values as shown below can be expected. 
-       [
            {
                "name": "secondreminder",
                "description": "secondreminderdescription",
                "duedate": "2017-08-15",
                "status": "close"
            }
        ] 
#### Get filtered (or) Reminders based on DueDate or Status value
- To retrieve, invoke a GET request in following manner http://localhost:9000/get/2017-08-15/or/close
- A single/chain of Json values as shown below can be expected. 
-       [
            {
                "name": "secondreminder",
                "description": "secondreminderdescription",
                "duedate": "2017-08-15",
                "status": "close"
            }
        ] 
#### Get filtered Reminders based on DueDate value alone
- To retrieve, invoke a GET request in following manner http://localhost:9000/get/duedate/2017-08-15
- A single/chain of Json values as shown below can be expected. 
-       [
            {
                "name": "secondreminder",
                "description": "secondreminderdescription",
                "duedate": "2017-08-15",
                "status": "close"
            }
        ] 
#### Get filtered Reminders based on Status value alone
- To retrieve, invoke a GET request in following manner http://localhost:9000/get/status/close
- A single/chain of Json values as shown below can be expected. 
-       [
            {
                "name": "secondreminder",
                "description": "secondreminderdescription",
                "duedate": "2017-08-15",
                "status": "close"
            }
        ] 
