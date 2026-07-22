package com.automation.nike.api.tests;

import com.automation.nike.api.config.ApiConfig;
import com.automation.nike.api.models.Book;
import com.automation.nike.api.models.Order;
import com.automation.nike.api.utils.ApiRequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class OrdersTests extends ApiBaseTest {

    @Test(description = "Verify POST /orders creates a new order with valid data")
    public void testSubmitNewOrder() {
        // Get a valid book ID
        Response booksResponse = ApiRequestBuilder.getRequest(ApiConfig.BOOKS_ENDPOINT);
        assertEquals(booksResponse.getStatusCode(), ApiConfig.HTTP_OK);
        
        List<Book> books = booksResponse.jsonPath().getList(".", Book.class);
        assertFalse(books.isEmpty(), "Books list should not be empty");
        
        int bookId = books.get(0).getId();
        
        // Submit an order
        Order order = new Order(bookId, "John Doe");
        Response response = ApiRequestBuilder.postRequestWithAuth(
                ApiConfig.ORDERS_ENDPOINT, 
                order, 
                accessToken
        );

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_CREATED, 
                "Should return 201 Created");
        
        String body = response.getBody().asString();
        assertFalse(body == null || body.isEmpty(), "Response body should not be empty");
        
        String orderId = response.jsonPath().getString("orderId");
        assertNotNull(orderId, "Order ID should not be null");
        assertFalse(orderId.isEmpty(), "Order ID should not be empty");
        System.out.println("✓ Test passed: Order created with ID: " + orderId);
    }

    @Test(description = "Verify POST /orders fails without authentication")
    public void testSubmitOrderWithoutAuth() {
        Order order = new Order(1, "Jane Doe");
        
        Response response = ApiRequestBuilder.postRequest(ApiConfig.ORDERS_ENDPOINT, order);

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_UNAUTHORIZED, 
                "Should return 401 Unauthorized");
        System.out.println("✓ Test passed: Order submission without auth returns 401");
    }

    @Test(description = "Verify POST /orders with invalid book ID fails")
    public void testSubmitOrderWithInvalidBookId() {
        Order order = new Order(99999, "Jane Doe");
        
        Response response = ApiRequestBuilder.postRequestWithAuth(
                ApiConfig.ORDERS_ENDPOINT, 
                order, 
                accessToken
        );

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_BAD_REQUEST, 
                "Should return 400 Bad Request for invalid book ID");
        System.out.println("✓ Test passed: Invalid book ID returns 400");
    }

    @Test(description = "Verify POST /orders requires customerName")
    public void testSubmitOrderMissingCustomerName() {
        String incompleteJson = "{\"bookId\": 1}";
        
        Response response = ApiRequestBuilder.getAuthenticatedRequest(accessToken)
                .body(incompleteJson)
                .when()
                .post(ApiConfig.ORDERS_ENDPOINT);

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_BAD_REQUEST, 
                "Should return 400 Bad Request when customerName is missing");
        System.out.println("✓ Test passed: Missing customerName validation works");
    }

    @Test(description = "Verify GET /orders returns all orders")
    public void testGetAllOrders() {
        Response response = ApiRequestBuilder.getAuthenticatedRequest(accessToken)
                .when()
                .get(ApiConfig.ORDERS_ENDPOINT);

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_OK, 
                "Should return 200 OK");
        
        List<Order> orders = response.jsonPath().getList(".", Order.class);
        assertNotNull(orders, "Orders list should not be null");
        System.out.println("✓ Test passed: Retrieved " + orders.size() + " orders");
    }

    @Test(description = "Verify GET /orders without authentication fails")
    public void testGetOrdersWithoutAuth() {
        Response response = ApiRequestBuilder.getRequest(ApiConfig.ORDERS_ENDPOINT);

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_UNAUTHORIZED, 
                "Should return 401 Unauthorized");
        System.out.println("✓ Test passed: Get orders without auth returns 401");
    }

    @Test(description = "Verify GET /orders/:orderId returns a specific order")
    public void testGetSpecificOrder() {
        // Create an order first
        Response booksResponse = ApiRequestBuilder.getRequest(ApiConfig.BOOKS_ENDPOINT);
        List<Book> books = booksResponse.jsonPath().getList(".", Book.class);
        int bookId = books.get(0).getId();
        
        Order newOrder = new Order(bookId, "Test Customer");
        Response createResponse = ApiRequestBuilder.postRequestWithAuth(
                ApiConfig.ORDERS_ENDPOINT, 
                newOrder, 
                accessToken
        );
        
        assertEquals(createResponse.getStatusCode(), ApiConfig.HTTP_CREATED);
        String body = createResponse.getBody().asString();
        assertFalse(body == null || body.isEmpty(), "Response body should not be empty");
        String orderId = createResponse.jsonPath().getString("orderId");
        
        // Get the specific order
        Response response = ApiRequestBuilder.getAuthenticatedRequest(accessToken)
                .when()
                .get(ApiConfig.ORDERS_ENDPOINT + "/" + orderId);

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_OK, 
                "Should return 200 OK");
        
        Order retrievedOrder = response.jsonPath().getObject(".", Order.class);
        assertNotNull(retrievedOrder, "Order should not be null");
        assertEquals(retrievedOrder.getId(), orderId, "Order ID should match");
        System.out.println("✓ Test passed: Retrieved order with ID: " + orderId);
    }

    @Test(description = "Verify GET /orders/:orderId with invalid ID returns 404")
    public void testGetInvalidOrder() {
        Response response = ApiRequestBuilder.getAuthenticatedRequest(accessToken)
                .when()
                .get(ApiConfig.ORDERS_ENDPOINT + "/invalidOrderId123");

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_NOT_FOUND, 
                "Should return 404 Not Found");
        System.out.println("✓ Test passed: Invalid order ID returns 404");
    }

    @Test(description = "Verify PATCH /orders/:orderId updates customer name")
    public void testUpdateOrder() {
        // Create an order first
        Response booksResponse = ApiRequestBuilder.getRequest(ApiConfig.BOOKS_ENDPOINT);
        List<Book> books = booksResponse.jsonPath().getList(".", Book.class);
        int bookId = books.get(0).getId();
        
        Order newOrder = new Order(bookId, "Original Name");
        Response createResponse = ApiRequestBuilder.postRequestWithAuth(
                ApiConfig.ORDERS_ENDPOINT, 
                newOrder, 
                accessToken
        );
        
        assertEquals(createResponse.getStatusCode(), ApiConfig.HTTP_CREATED);
        String body = createResponse.getBody().asString();
        assertFalse(body == null || body.isEmpty(), "Response body should not be empty");
        String orderId = createResponse.jsonPath().getString("orderId");
        
        // Update the order
        Order updateOrder = new Order();
        updateOrder.setCustomerName("Updated Name");
        
        Response response = ApiRequestBuilder.patchRequest(
                ApiConfig.ORDERS_ENDPOINT + "/" + orderId, 
                updateOrder, 
                accessToken
        );

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_NO_CONTENT,
                "Should return 204 No Content");
        
        // Verify the update
        Response getResponse = ApiRequestBuilder.getAuthenticatedRequest(accessToken)
                .when()
                .get(ApiConfig.ORDERS_ENDPOINT + "/" + orderId);
        
        Order updatedOrder = getResponse.jsonPath().getObject(".", Order.class);
        assertEquals(updatedOrder.getCustomerName(), "Updated Name", 
                "Customer name should be updated");
        System.out.println("✓ Test passed: Order updated successfully");
    }

    @Test(description = "Verify PATCH /orders/:orderId without authentication fails")
    public void testUpdateOrderWithoutAuth() {
        Order updateOrder = new Order();
        updateOrder.setCustomerName("Updated Name");
        
        Response response = ApiRequestBuilder.getBaseRequest()
                .body(updateOrder)
                .when()
                .patch(ApiConfig.ORDERS_ENDPOINT + "/someOrderId");

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_UNAUTHORIZED, 
                "Should return 401 Unauthorized");
        System.out.println("✓ Test passed: Update order without auth returns 401");
    }

    @Test(description = "Verify DELETE /orders/:orderId deletes an order")
    public void testDeleteOrder() {
        // Create an order first
        Response booksResponse = ApiRequestBuilder.getRequest(ApiConfig.BOOKS_ENDPOINT);
        List<Book> books = booksResponse.jsonPath().getList(".", Book.class);
        int bookId = books.get(0).getId();
        
        Order newOrder = new Order(bookId, "Order to Delete");
        Response createResponse = ApiRequestBuilder.postRequestWithAuth(
                ApiConfig.ORDERS_ENDPOINT, 
                newOrder, 
                accessToken
        );
        
        assertEquals(createResponse.getStatusCode(), ApiConfig.HTTP_CREATED, 
                "Order creation should return 201");
        
        String orderId = createResponse.jsonPath().getString("orderId");
        assertNotNull(orderId, "Order ID should not be null");
        
        // Delete the order
        Response response = ApiRequestBuilder.deleteRequest(
                ApiConfig.ORDERS_ENDPOINT + "/" + orderId, 
                accessToken
        );

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_NO_CONTENT,
                "Should return 204 No Content");
        
        // Verify deletion by trying to get the deleted order
        Response getResponse = ApiRequestBuilder.getAuthenticatedRequest(accessToken)
                .when()
                .get(ApiConfig.ORDERS_ENDPOINT + "/" + orderId);
        
        assertEquals(getResponse.getStatusCode(), ApiConfig.HTTP_NOT_FOUND, 
                "Deleted order should not be found");
        System.out.println("✓ Test passed: Order deleted successfully");
    }

    @Test(description = "Verify DELETE /orders/:orderId without authentication fails")
    public void testDeleteOrderWithoutAuth() {
        Response response = ApiRequestBuilder.getBaseRequest()
                .when()
                .delete(ApiConfig.ORDERS_ENDPOINT + "/someOrderId");

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_UNAUTHORIZED, 
                "Should return 401 Unauthorized");
        System.out.println("✓ Test passed: Delete order without auth returns 401");
    }
}
