Cinema Room REST Service
A Spring Boot-based RESTful API designed to manage cinema seat bookings, ticket purchases, refunds, and administrative statistics. This project demonstrates clean architecture through the use of DTOs, service-layer business logic, and global exception handling.

Features
Dynamic Room Information: Retrieve cinema room dimensions and current seat availability.

Ticket Purchase: Real-time ticket booking with dynamic pricing based on seat location.

Refund System: Return tickets using a unique UUID token to free up seats and update revenue.

Management Statistics: Password-protected endpoint for theater managers to view total income, available seats, and number of tickets sold.

Professional Error Handling: Centralized exception management providing consistent JSON error responses and appropriate HTTP status codes.

Technology Stack
Java

Spring Boot (Web, DevTools)

Jackson (JSON Serialization/Deserialization)

Apache Maven (Dependency Management)

Architecture
The project follows a layered architecture to ensure separation of concerns:

Controller Layer: Handles HTTP requests and interacts with the Service layer.

Service Layer: Manages the core business logic, including pricing calculations and security checks.

Repository Layer: Provides in-memory data storage for cinema room state and ticket bookings.

DTO Layer: Decouples internal entities from the external API representation using SeatDTO and TicketDTO wrappers.

Global Exception Handling: Uses @ControllerAdvice to intercept exceptions and return standardized error messages.

Business Logic
Pricing

Premium Seats: Rows 1 through 4 are priced at $10.

Standard Seats: Rows 5 and above are priced at $8.

Security

The /stats endpoint requires a query parameter password.

The secret is externalized in application.properties for security and configurability.

API Endpoints
1. Get All Seats

Returns the dimensions of the cinema and a list of all available seats.

URL: /seats

Method: GET

Response Code: 200 OK

2. Purchase a Ticket

Purchases a seat and returns a unique token for future refunds.

URL: /purchase

Method: POST

Request Body:

```JSON
{
    "row": 1,
    "column": 1
}
```
Response Code: 200 OK / 400 Bad Request (if seat is taken or out of bounds)

3. Return a Ticket

Refunds a purchased ticket using the provided token.

URL: /return

Method: POST

Request Body:

```JSON
{
    "token": "uuid-token-here"
}
```
Response Code: 200 OK / 400 Bad Request (if token is invalid)

4. Statistics

Provides financial and occupancy data for the cinema.

URL: /stats

Method: GET

Parameters: password (String)

Response Code: 200 OK / 401 Unauthorized (if password is incorrect)

Configuration
The administrative password can be configured in the src/main/resources/application.properties file:

Properties
```
cinema.stats.password=super_secret
```
Error Response Format
All errors are returned in a consistent JSON format to assist frontend integration:

```JSON
{
    "error": "Detailed error message here"
}
```
