# RestAssured API Testing - Quick Start Guide

## Overview
This project includes a comprehensive API testing suite for the Books Management API using RestAssured and TestNG.

## What's Been Added

### 1. **Dependencies** (pom.xml)
- RestAssured 5.4.0 - REST API testing
- GSON 2.10.1 - JSON serialization/deserialization

### 2. **Test Framework** (11 Java classes)

#### Configuration & Utilities
- `ApiConfig.java` - API endpoints and constants
- `ApiRequestBuilder.java` - Reusable request building methods

#### Data Models
- `Book.java` - Book model
- `Order.java` - Order model
- `ApiClient.java` - API client model
- `Status.java` - Status model

#### Base & Test Classes
- `ApiBaseTest.java` - Base class with automatic authentication setup
- `StatusTests.java` - 1 test for API status
- `BooksTests.java` - 6 tests for books endpoints
- `AuthenticationTests.java` - 4 tests for API client registration
- `OrdersTests.java` - 10 tests for orders CRUD operations

### 3. **Configuration Files**
- `testng-api.xml` - TestNG configuration for API tests
- `API_TESTING_README.md` - Comprehensive documentation

## Quick Start

### Prerequisites
- Java 11+
- Maven 3.6+

### Run All API Tests
```bash
mvn test -Dtest=*Tests
```

### Run Specific Test Suite
```bash
# Status tests
mvn test -Dtest=StatusTests

# Books tests
mvn test -Dtest=BooksTests

# Authentication tests
mvn test -Dtest=AuthenticationTests

# Orders tests
mvn test -Dtest=OrdersTests
```

### Run Using TestNG Configuration
```bash
mvn test -Dsuites=testng-api.xml
```

### Run Specific Test Method
```bash
mvn test -Dtest=BooksTests#testGetAllBooks
```

## Test Coverage

### Endpoints Tested (9 endpoints)
- ✅ **GET /status** - API status (1 test)
- ✅ **GET /books** - List books with filters (3 tests)
- ✅ **GET /books/:bookId** - Get single book (2 tests)
- ✅ **POST /api-clients/** - Register API client (4 tests)
- ✅ **POST /orders** - Create order (3 tests)
- ✅ **GET /orders** - List orders (2 tests)
- ✅ **GET /orders/:orderId** - Get order (2 tests)
- ✅ **PATCH /orders/:orderId** - Update order (2 tests)
- ✅ **DELETE /orders/:orderId** - Delete order (2 tests)

### Total Test Cases: 21

## Key Features

✅ **Automatic Authentication**
- Tests automatically register a new API client
- Unique access tokens generated per test session

✅ **Comprehensive Error Testing**
- 400 Bad Request validation
- 401 Unauthorized (missing authentication)
- 404 Not Found (invalid resources)
- 409 Conflict (duplicate registrations)

✅ **Reusable Utilities**
- ApiRequestBuilder for consistent request building
- Centralized configuration management
- JSON serialization/deserialization with GSON

✅ **Well-Structured Code**
- Organized by feature (books, orders, auth, status)
- Clear separation of concerns
- Descriptive test names and documentation

## Example Test Structure

```java
@Test(description = "Verify POST /orders creates a new order with valid data")
public void testSubmitNewOrder() {
    // Get a valid book ID
    Response booksResponse = ApiRequestBuilder.getRequest(ApiConfig.BOOKS_ENDPOINT);
    assertEquals(booksResponse.getStatusCode(), ApiConfig.HTTP_OK);
    
    List<Book> books = booksResponse.jsonPath().getList(".", Book.class);
    int bookId = books.get(0).getId();
    
    // Submit an order
    Order order = new Order(bookId, "John Doe");
    Response response = ApiRequestBuilder.postRequestWithAuth(
            ApiConfig.ORDERS_ENDPOINT, 
            order, 
            accessToken
    );

    assertEquals(response.getStatusCode(), ApiConfig.HTTP_CREATED);
    String orderId = response.jsonPath().getString("orderId");
    assertNotNull(orderId);
}
```

## File Locations

```
NikeFramework/
├── pom.xml                                  (Updated with RestAssured)
├── testng-api.xml                           (TestNG configuration)
├── API_TESTING_README.md                    (Detailed documentation)
└── src/test/java/com/automation/nike/api/
    ├── config/
    │   └── ApiConfig.java
    ├── models/
    │   ├── ApiClient.java
    │   ├── Book.java
    │   ├── Order.java
    │   └── Status.java
    ├── utils/
    │   └── ApiRequestBuilder.java
    └── tests/
        ├── ApiBaseTest.java
        ├── StatusTests.java
        ├── BooksTests.java
        ├── AuthenticationTests.java
        └── OrdersTests.java
```

## Next Steps

1. Run the tests: `mvn test`
2. Review test output and coverage
3. Integrate into CI/CD pipeline
4. Extend with additional test cases as needed

## Troubleshooting

### Tests fail due to API unavailability
- Verify the API base URL is accessible: https://simple-books-api.glitch.me

### Authentication token issues
- Tokens are automatically generated per test session
- Each test client uses a unique email to prevent conflicts

### Compilation issues
- Ensure Java 11+ is installed
- Run `mvn clean install` to resolve dependency issues

## Documentation

See `API_TESTING_README.md` for:
- Detailed test descriptions
- Request/response examples
- API configuration details
- Assertion patterns
- Error handling patterns
