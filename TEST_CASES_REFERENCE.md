# API Test Cases - Complete Reference

## Overview
This document provides a quick reference for all 21 test cases organized by endpoint.

---

## 1. STATUS ENDPOINT

### GET /status
**Class:** StatusTests.java

| # | Test Name | Description | Expected Result |
|---|---|---|---|
| 1 | testGetApiStatus | Verify API status endpoint returns 200 | HTTP 200 with status field = 200 |

---

## 2. BOOKS ENDPOINTS

### GET /books (with filters)
**Class:** BooksTests.java

| # | Test Name | Description | Expected Result |
|---|---|---|---|
| 2 | testGetAllBooks | Verify GET /books returns a list of books | HTTP 200, non-empty list |
| 3 | testGetBooksByType | Verify GET /books with type=fiction filter | HTTP 200, all books type=fiction |
| 4 | testGetBooksWithLimit | Verify GET /books with limit query parameter | HTTP 200, results <= limit |
| 5 | testGetBooksWithTypeAndLimit | Verify GET /books with both type and limit | HTTP 200, filtered by type and limited |
| 6 | testGetBooksWithLimitAboveMax | Verify limit parameter rejects values > 20 | HTTP 400 Bad Request |

### GET /books/:bookId
**Class:** BooksTests.java

| # | Test Name | Description | Expected Result |
|---|---|---|---|
| 7 | testGetSingleBook | Verify GET /books/:bookId returns a single book | HTTP 200 with book details |
| 8 | testGetInvalidBook | Verify GET /books/:bookId with invalid ID returns 404 | HTTP 404 Not Found |

---

## 3. AUTHENTICATION ENDPOINT

### POST /api-clients/
**Class:** AuthenticationTests.java

| # | Test Name | Description | Expected Result |
|---|---|---|---|
| 9 | testRegisterNewApiClient | Verify registration of a new API client | HTTP 201, valid access token |
| 10 | testRegisterDuplicateApiClient | Verify registration fails for duplicate email | HTTP 409 Conflict |
| 11 | testRegisterClientMissingEmail | Verify API client registration requires all required fields | HTTP 400, email validation error |
| 12 | testTokenFormat | Verify valid token format | Token matches alphanumeric pattern |

---

## 4. ORDERS ENDPOINTS

### POST /orders (Create Order)
**Class:** OrdersTests.java

| # | Test Name | Description | Expected Result |
|---|---|---|---|
| 13 | testSubmitNewOrder | Verify POST /orders creates a new order with valid data | HTTP 201, valid order ID returned |
| 14 | testSubmitOrderWithoutAuth | Verify POST /orders fails without authentication | HTTP 401 Unauthorized |
| 15 | testSubmitOrderWithInvalidBookId | Verify POST /orders with invalid book ID fails | HTTP 400 Bad Request |
| 16 | testSubmitOrderMissingCustomerName | Verify POST /orders requires customerName | HTTP 400, field validation error |

### GET /orders (List Orders)
**Class:** OrdersTests.java

| # | Test Name | Description | Expected Result |
|---|---|---|---|
| 17 | testGetAllOrders | Verify GET /orders returns all orders | HTTP 200, non-null list |
| 18 | testGetOrdersWithoutAuth | Verify GET /orders without authentication fails | HTTP 401 Unauthorized |

### GET /orders/:orderId (Get Single Order)
**Class:** OrdersTests.java

| # | Test Name | Description | Expected Result |
|---|---|---|---|
| 19 | testGetSpecificOrder | Verify GET /orders/:orderId returns a specific order | HTTP 200 with order details |
| 20 | testGetInvalidOrder | Verify GET /orders/:orderId with invalid ID returns 404 | HTTP 404 Not Found |

### PATCH /orders/:orderId (Update Order)
**Class:** OrdersTests.java

| # | Test Name | Description | Expected Result |
|---|---|---|---|
| 21 | testUpdateOrder | Verify PATCH /orders/:orderId updates customer name | HTTP 200, customer name updated |
| 22 | testUpdateOrderWithoutAuth | Verify PATCH /orders/:orderId without authentication fails | HTTP 401 Unauthorized |

### DELETE /orders/:orderId (Delete Order)
**Class:** OrdersTests.java

| # | Test Name | Description | Expected Result |
|---|---|---|---|
| 23 | testDeleteOrder | Verify DELETE /orders/:orderId deletes an order | HTTP 200, order no longer exists (404) |
| 24 | testDeleteOrderWithoutAuth | Verify DELETE /orders/:orderId without authentication fails | HTTP 401 Unauthorized |

---

## Test Matrix by HTTP Status Code

| HTTP Status | Expected Cases | Tests |
|---|---|---|
| **200 OK** | Success responses | All GET, PATCH, DELETE success cases |
| **201 Created** | Resource created | POST /api-clients, POST /orders |
| **400 Bad Request** | Invalid input | Invalid book ID, missing fields, limit validation |
| **401 Unauthorized** | Missing auth | All operations without token |
| **404 Not Found** | Resource not found | Invalid book ID, invalid order ID |
| **409 Conflict** | Duplicate resource | Duplicate email registration |

---

## Test Matrix by Endpoint

```
Status Endpoint (1 test)
└── GET /status (1)

Books Endpoints (8 tests)
├── GET /books (5)
│   ├── No filters (1)
│   ├── With type filter (1)
│   ├── With limit filter (1)
│   ├── With both filters (1)
│   └── Limit > 20 validation (1)
└── GET /books/:bookId (3)
    ├── Valid book ID (1)
    └── Invalid book ID (1)

Authentication Endpoint (4 tests)
└── POST /api-clients/ (4)
    ├── New client (1)
    ├── Duplicate email (1)
    ├── Missing fields (1)
    └── Token format (1)

Orders Endpoints (8 tests)
├── POST /orders (4)
│   ├── Valid order (1)
│   ├── Without auth (1)
│   ├── Invalid book ID (1)
│   └── Missing fields (1)
├── GET /orders (2)
│   ├── List orders (1)
│   └── Without auth (1)
├── GET /orders/:orderId (2)
│   ├── Valid order ID (1)
│   └── Invalid order ID (1)
├── PATCH /orders/:orderId (2)
│   ├── Update order (1)
│   └── Without auth (1)
└── DELETE /orders/:orderId (2)
    ├── Delete order (1)
    └── Without auth (1)
```

---

## Test Execution Time Estimate

- **Status Tests**: ~500ms
- **Books Tests**: ~2-3 seconds (includes API calls)
- **Authentication Tests**: ~2-3 seconds
- **Orders Tests**: ~5-8 seconds (creates/deletes resources)

**Total Estimated Runtime**: 10-15 seconds

---

## Test Dependencies

The tests follow this logical order:
1. **Status Tests** - No dependencies
2. **Books Tests** - Uses public /books endpoint
3. **Authentication Tests** - Creates unique clients
4. **Orders Tests** - Depends on Books (needs book IDs), requires Auth tokens

---

## Assertions Used

| Type | Count | Examples |
|---|---|---|
| assertEquals | ~40 | Status codes, field values |
| assertNotNull | ~15 | Response bodies, tokens, IDs |
| assertTrue/False | ~10 | List size checks, format validation |
| assertFalse isEmpty | ~5 | Non-empty list validation |

---

## Error Scenarios Covered

✅ **Input Validation**
- Missing required fields
- Invalid parameter values
- Parameter value boundaries

✅ **Authentication**
- Missing authentication token
- Invalid/expired tokens

✅ **Resource Handling**
- Non-existent resources (404)
- Duplicate resource creation (409)
- Valid CRUD operations

✅ **Data Integrity**
- Field presence validation
- Type correctness
- State persistence

---

## Running Specific Tests

### Run all books tests
```bash
mvn test -Dtest=BooksTests
```

### Run all order tests
```bash
mvn test -Dtest=OrdersTests
```

### Run single test method
```bash
mvn test -Dtest=BooksTests#testGetAllBooks
```

### Run multiple specific tests
```bash
mvn test -Dtest=StatusTests,BooksTests,AuthenticationTests
```

### Run tests with specific pattern
```bash
mvn test -Dtest=*Tests
```

---

## Test Report Output

When running tests, you'll see output like:
```
[INFO] Tests run: 21, Failures: 0, Skipped: 0, Time elapsed: 12.34s
[INFO] BUILD SUCCESS
```

Each test also prints:
```
✓ Test passed: <test description>
```

---

## Coverage Summary

- **Total Endpoints**: 9
- **Total Test Methods**: 21
- **HTTP Status Codes Tested**: 5 (200, 201, 400, 401, 404, 409)
- **Error Scenarios**: 8
- **Success Scenarios**: 13
- **Authentication Tests**: 12
- **CRUD Operations**: 15

---

## Quick Checklist for New Tests

When adding new tests, ensure:
- [ ] Test has descriptive @Test(description = "...")
- [ ] Test method name matches test description
- [ ] Uses appropriate HTTP assertion
- [ ] Includes error messages in assertions
- [ ] Cleans up resources (creates/deletes)
- [ ] Handles authentication properly
- [ ] Logs success with println

---

## Notes

- All tests are independent and can run in any order
- Authentication is automatically set up per session
- Unique client emails prevent conflicts
- Tests use system timestamps for data uniqueness
- Response assertions include descriptive error messages
