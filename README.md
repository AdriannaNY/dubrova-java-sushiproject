# dubrova-java-sushiproject
## Backend for Sushi Project with Rest API

### Main technologies:
- Java version: 17
- Maven  
- Spring Boot
- JPA
- MySql
- Postman
- GitHub

### Sushi Project Functionality
The sushi project functionality include ability to create, read, update and delete (CRUD) records both for foods and restaurants.
The functionality is secured by requiring a username of "admin" to access these features.

### Foods CRUD
Users with the "admin" username are able to create new food records by providing information such as the food's name, description, price.
They also are able to view, update and delete existing food records.

### Restaurant CRUD
Users with the "admin" username are able to create new restaurant records by providing information such as the restaurant's name, city, address, phone, email.
They are also able to view, update and delete existing restaurant records.

### POST, DELETE and PUT requests
Users with the "admin" username are able:
- create new resources by sending a POST request
- delete existing resorces by sending a DELETE request
- update existing resources by sending a PUT request
GET is working for all, except reading specific information about clients, foods and restaurants.

### Security
The application have the ability to retrieve all foods (for all users), retrieve a specific food (for users with access), 
retrieve all restaurants (for all users), retrieve a specific restaurant (for users with access) and so on.

### All of the functions you can find in the Documentation with description of the endpoints.
### In the project directory you can see also ERD database schema (ERD.jpg) and dump of database "online_sushi", used in project (DumpOnlineSushi.sql).


## In other repository "dubrova-java-sushiproject-mvc" you can see the implementation of Web Application "Online Sushi Ordering System"
## Technologies
##Backend: Spring Boot and Spring MVC 
##Frontend: JSP, HTML, CSS, JavaScript 
##Style: BootStrap


