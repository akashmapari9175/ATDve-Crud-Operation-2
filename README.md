Dynamic CRUD API with Spring Boot
This project implements a dynamic CRUD (Create, Read, Update, Delete) API using Spring Boot. The API is designed to perform CRUD operations on different tables dynamically, with records stored in an in-memory Map structure.

API Endpoints
Create (POST)
Endpoint: /api/{tableName}
Method: POST
Description: Create a new record in the specified table.
Request Body:

json
Copy code
{
  "name": "John Doe",
  "age": 25,
  "grade": "A",
  "department": "Computer Science"
}
Response:

json
Copy code
{
  "id": 12345,
  "name": "John Doe",
  "age": 25,
  "grade": "A",
  "department": "Computer Science"
}
Read (GET)
Endpoint: /api/{tableName}/{id}
Method: GET
Description: Retrieve a record from the specified table by its ID.
Response:
json
Copy code
{
  "id": 12345,
  "name": "John Doe",
  "age": 25,
  "grade": "A",
  "department": "Computer Science"
}
Update (PUT)
Endpoint: /api/{tableName}/{id}
Method: PUT
Description: Update an existing record in the specified table.
Request Body:
json
Copy code
{
  "name": "Updated John Doe",
  "age": 26,
  "grade": "B",
  "department": "Information Technology"
}
Response:
json
Copy code
{
  "id": 12345,
  "name": "Updated John Doe",
  "age": 26,
  "grade": "B",
  "department": "Information Technology"
}
Delete (DELETE)
Endpoint: /api/{tableName}/{id}
Method: DELETE
Description: Delete a record from the specified table by its ID.
Response: No content.
TestNG Test Class
The DynamicCrudControllerTest class contains TestNG tests to validate the functionality of the dynamic CRUD API.

Setup
The tests use the TestRestTemplate to interact with the API.
The @SpringBootTest annotation indicates that the tests are integration tests and loads the complete Spring application context.
The @LocalServerPort annotation injects the actual port of the running application.
Test Methods
testCrudOperations:
Tests the entire CRUD flow for a dynamic table.
Creates a record, retrieves it, updates it, and finally deletes it.
Uses assertions from the AssertJ library to verify the expected results.
Running the Tests
Ensure that the API is running.
Run the DynamicCrudControllerTest class as a TestNG test.
Getting Started
To run the application locally, follow these steps:

Clone the repository:

bash
Copy code
git clone <repository_url>
Navigate to the project directory:

bash
Copy code
cd dynamic-crud-api
Run the application:

bash
Copy code
./mvnw spring-boot:run
The API will be accessible at http://localhost:8080.

Dependencies
Java 11
Spring Boot 2.5.4
TestNG 7.4.0
License
This project is licensed under the MIT License - see the LICENSE file for details.
