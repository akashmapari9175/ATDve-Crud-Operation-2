# Dynamic CRUD API with Spring Boot

This project implements a dynamic CRUD (Create, Read, Update, Delete) API using Spring Boot. The API is designed to perform CRUD operations on different tables dynamically, with records stored in an in-memory Map structure.

## API Endpoints

### Create (POST)

- **Endpoint:** `/api/{tableName}`
- **Method:** `POST`
- **Description:** Create a new record in the specified table.
- **Request Body:**
  ```json
  {
    "name": "John Doe",
    "age": 25,
    "grade": "A",
    "department": "Computer Science"
  }
  
### Read (GET)

- **Endpoint:** `api/{tableName}/{id}`
- **Method:** `GET`
- **Description:** Retrieve a record from the specified table by its ID.
- **Request Body:**
  ```json
  {
  "id": 12345,
  "name": "John Doe",
  "age": 25,
  "grade": "A",
  "department": "Computer Science"
  }

