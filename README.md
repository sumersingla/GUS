# GUS: Genesys User Service
This is a simple REST-ful web service applictaion created as part of Genesys Hiring Process. It consists of basic CRUD operations for managing user information and a login functionality along with authentication of the user based on their email and passwords.

## Tech Stack
- Java 17
- Spring Boot (3.3.1)
- MySQL
- JDBC
- Maven (Build Automation)

## Endpoints (For Application running on localhost:8080)
- List All Users (GET): localhost:8080/api/users
- Login (POST): localhost:8080/api/users/login  || Requires two params: email and password
- Create User (POST): localhost:8080/api/users  || Requires a JSON request body such as - 
  {
        "name": "John Doe",
        "email": "john.doe@example.com",
        "password": "password1",
        "lastLogin": "2024-07-09T17:51:17"
 }
- Delete User (DELETE): localhost:8080/api/users/{id}  || Requires user id at the end or the endpoint
- Update User data (PUT): localhost:8080/api/users/{id} || Requires a JSON request body such as - 
  {
        "name": "John Doe",
        "email": "john.doe@example.com",
        "password": "password1",
        "lastLogin": "2024-07-09T17:51:17"
 }

## Assumptions

- Users have unique email addresses.
- Passwords are stored securely (not plain text).
- Application has a connection to MySQL server (Tested on local DB)

## Testing

- The application is manually tested using local postman and MySQL servers.

## Limitations

- No support for user roles or permissions.
- Limited error handling.
- Assumes single-server deployment.
- No unit testing.
- No UI support

## Improvements

- Implement jOOQ and jOOQ codegen for better readability, modularity and maintainability.
- Implement JWT-based authentication.
- Add support for user roles (admin, user).
- Add UI for better experience for multiple role based users like fetching user list, filtering, options like delete, search, create etc.. (Using JFrame/Swing, Unity etc..)
- Integrate with OAuth providers for login.
- Implement alerting and monitoring with Micrometer (Prometheus/StatsD).
- Password encryption and decryption for saving into database using hashing. 
