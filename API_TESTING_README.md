# RestAssured API Testing Suite

This directory contains comprehensive API tests for the Books Management API using RestAssured.

## Project Structure

```
src/test/java/com/automation/nike/api/
├── config/
│   └── ApiConfig.java          # API configuration and constants
├── models/
│   ├── ApiClient.java          # API client registration model
│   ├── Book.java               # Book model
│   ├── Order.java              # Order model
│   └── Status.java             # Status response model
├── utils/
│   └── ApiRequestBuilder.java  # Utility class for building API requests
└── tests/
    ├── ApiBaseTest.java        # Base test class with authentication setup
    ├── StatusTests.java        # Status endpoint tests
    ├── BooksTests.java         # Books endpoint tests
    ├── AuthenticationTests.java # API client registration tests
    └── OrdersTests.java        # Orders endpoint tests
```

## Dependencies

- **RestAssured** 5.4.0 - REST API testing library
- **TestNG** 6.14.3 - Testing framework
- **GSON** 2.10.1 - JSON serialization/deserialization

## Test Classes

### 1. **StatusTests**
Tests the API status endpoint.

**Endpoints Covered:**
- `GET /status` - Returns the API status

**Test Cases:**
- Verify API status endpoint returns 200

### 2. **BooksTests**
Tests the books listing and retrieval endpoints.

**Endpoints Covered:**
- `GET /books` - Returns a list of books
- `GET /books/:bookId` - Returns a single book

**Test Cases:**
- Get all books without filters
- Get books filtered by type (fiction/non-fiction)
- Get books with limit parameter (1-20)
- Get books with both type and limit filters
- Get a specific book by ID
- Attempt to get invalid book ID (404 error handling)
- Validate limit parameter boundaries

### 3. **AuthenticationTests**
Tests the API client registration and authentication.

**Endpoints Covered:**
- `POST /api-clients/` - Register a new API client

**Test Cases:**
- Register a new API client successfully
- Attempt duplicate registration with same email (409 conflict)
- Validate required fields (clientName, clientEmail)
- Verify token format validity
- Token generation and validation

### 4. **OrdersTests**
Tests all order-related operations with authentication.

**Endpoints Covered:**
- `POST /orders` - Submit a new order
- `GET /orders` - Get all orders
- `GET /orders/:orderId` - Get a specific order
- `PATCH /orders/:orderId` - Update an order
- `DELETE /orders/:orderId` - Delete an order

**Test Cases:**
- Submit a new order with valid data
- Submit order without authentication (401)
- Submit order with invalid book ID (400)
- Submit order with missing required fields (400)
- Get all orders (authenticated)
- Get all orders without authentication (401)
- Get a specific order by ID
- Get non-existent order (404)
- Update order customer name
- Update order without authentication (401)
- Delete an order
- Delete order without authentication (401)

## Running the Tests

### Run all tests
```bash
mvn test
```

### Run specific test class
```bash
mvn test -Dtest=StatusTests
mvn test -Dtest=BooksTests
mvn test -Dtest=AuthenticationTests
mvn test -Dtest=OrdersTests
```

### Run specific test method
```bash
mvn test -Dtest=BooksTests#testGetAllBooks
```

### Run with TestNG configuration
```bash
mvn test -Dsuites=testng.xml
```

## API Configuration

The API configuration is defined in `com.automation.nike.api.config.ApiConfig`:

- **Base URL:** `https://simple-books-api.glitch.me`
- **Endpoints:**
  - `/status` - API status
  - `/books` - Books list
  - `/orders` - Orders management
  - `/api-clients/` - Client registration

## Authentication

The test suite automatically handles authentication:

1. **Setup Phase:** The `ApiBaseTest` class automatically registers a new API client before running authenticated tests
2. **Access Token:** A unique access token is generated for each test session
3. **Token Validity:** Tokens are valid for 7 days
4. **Authorization Header:** All authenticated requests use `Bearer <token>` format

## Request/Response Patterns

### Books Model
```json
{
  "id": 1,
  "name": "The Great Gatsby",
  "type": "fiction",
  "available": true
}
```

### Order Creation Request
```json
{
  "bookId": 1,
  "customerName": "John Doe"
}
```

### Order Response
```json
{
  "orderId": "PF6MflPDcuhWobZcgmJy5",
  "bookId": 1,
  "customerName": "John Doe",
  "createdBy": "12345",
  "createdAt": "2024-01-15T10:30:00Z"
}
```

### API Client Request
```json
{
  "clientName": "Test Client",
  "clientEmail": "test@example.com"
}
```

### API Client Response
```json
{
  "accessToken": "token123abc...",
  "clientName": "Test Client",
  "clientEmail": "test@example.com"
}
```

## Utility Class: ApiRequestBuilder

Provides convenient methods for building and executing API requests:

### GET Requests
```java
ApiRequestBuilder.getRequest(endpoint);
ApiRequestBuilder.getRequestWithQueryParam(endpoint, paramName, paramValue);
ApiRequestBuilder.getRequestWithMultipleParams(endpoint, param1, value1, param2, value2);
```

### POST Requests
```java
ApiRequestBuilder.postRequest(endpoint, body);
ApiRequestBuilder.postRequestWithAuth(endpoint, body, token);
```

### PATCH Requests
```java
ApiRequestBuilder.patchRequest(endpoint, body, token);
```

### DELETE Requests
```java
ApiRequestBuilder.deleteRequest(endpoint, token);
```

## Expected Results

All tests should pass with the following expectations:

1. **Status Tests:** API endpoint responds with HTTP 200
2. **Books Tests:** Books are retrievable with optional filters
3. **Authentication Tests:** Clients can register and receive valid tokens
4. **Orders Tests:** Full CRUD operations with proper authentication enforcement

## Assertions Used

The tests use TestNG assertions:

- `assertEquals()` - Verify exact match (status codes, field values)
- `assertNotNull()` - Verify object existence
- `assertFalse/assertTrue()` - Verify boolean conditions
- Custom assertions for response validation

## Error Handling

The test suite covers common HTTP error scenarios:

- **400 Bad Request** - Invalid parameters or missing required fields
- **401 Unauthorized** - Missing or invalid authentication
- **404 Not Found** - Resource doesn't exist
- **409 Conflict** - Duplicate resource creation

## Notes

- Each test is independent and can run in any order
- Authentication is automatically set up before each test session
- The API uses unique client emails to prevent conflicts during testing
- Tests use system timestamps to ensure unique client registration data
- All response assertions include descriptive error messages
