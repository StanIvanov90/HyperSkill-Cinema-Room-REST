# Cinema Room REST Service

A Spring Boot API for cinema seat management, ticket sales, and administrative reporting.

## API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| GET | /seats | Returns room dimensions and available seats |
| POST | /purchase | Reserves a seat and returns a ticket token |
| POST | /return | Processes a refund and frees the seat |
| GET | /stats | Returns income and occupancy (Password required) |

## Key Logic
- **Pricing**: Rows 1-4 are $10, all others are $8.
- **Security**: The `/stats` password is set in `application.properties`.
- **Validation**: Centralized error handling for seat availability and token verification.

## Configuration
Add the following to `src/main/resources/application.properties`:
```properties
cinema.stats.password=super_secret
```

- **Post Purchase Request Body**:
```json
{
    "row": 1,
    "column": 1
}
```

- **Post Return Request Body**:
```json
{
    "token": "uuid-token-here"
}
```

Error Format
```JSON
{
    "error": "Message describing the issue"
}
```
