# FuelApp
Coding challenge

This application FuleApp interact with Monday.com to retrieve and update work items/projects. FuleApp application is authenticated using JWT token.

**Pre-requisite:**
1.	Java 17 
2.	Spring boot 2.7.15
3.	H2 Database
4.	Postman (version)
5.	Test Account in Monday.com

**Cloning application source and run:**

Git Hub link: 

Command to run the application:  ***mvn spring-boot:run***

On successful execution of application, below logs will appear in the console
2023-08-31 19:31:20.834  INFO 36448 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8081 (http) with context path ''
2023-08-31 19:31:20.859  INFO 36448 --- [           main] com.test.fuelApp.FuelAppApplication      : Started FuelAppApplication in 5.617 seconds (JVM running for 6.024) 


How to Run:-
You can run with the command "mvn spring-boot:run"
Version Used:-
Java 17 Spring boot 2.7.15
Clone this repository:-
Clone the Fuel App repository and build the project using the command "mvn spring-boot:run"
Once the application runs you should see something like this
2023-08-31 19:31:20.834  INFO 36448 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8081 (http) with context path ''
2023-08-31 19:31:20.859  INFO 36448 --- [           main] com.test.fuelApp.FuelAppApplication      : Started FuelAppApplication in 5.617 seconds (JVM running for 6.024)

About the Service:-
The service uses an in-memory database (H2) to store the data. You can also do with any database. If your database connection properties work, you can call some REST endpoints defined in com.test.fuelApp.controller; on port 8081. (see below)
Here are the endpoints you can call: -
1.	POST: /register – to register the user by providing username and password as a request body which will create that particular user in Database.
http://localhost:8081/register
Request:
{
    "username":"test5",
    "password":"test123"
}

2.	POST:/authenticate – to authenticate the user by checking in database if exists and provides the authenticated token to login.
http://localhost:8081/authenticate
Request:
{
    "username":"test9",
    "password":"test123"
}

3.	GET: /getItems – To retrieve the work items from Monday.com by passing the Monday account API token as param and the request body which contains the query string as an input to call the API URL. Also pass the bearer token response received from the above endpoint.
http://localhost:8081/getItems?token=XXXXXXXXX
Request:
{
    "query": "query { boards(ids:1259058835) { items { id name } } }"
}
4.	GET: /updateItemName – To update the item name in Monday.com by by passing the Monday account API token as param and the request body which contains the query string as an input to call the API URL. Also pass the bearer token response received from the above endpoint.


http://localhost:8081/updateItemName?token=XXXXXX
Request:
{
    "query": "mutation {change_multiple_column_values(item_id:1259058839, board_id:1259058835, column_values: \"{\\\"name\\\" : \\\"Completed Item\\\"}\") {id}}" 
}


To view H2 in-memory database:-
Application runs on H2 in-memory database. To view and query the database you can browse to http://localhost:8081/h2-console. Default username is 'sa' with password as 'password'.

