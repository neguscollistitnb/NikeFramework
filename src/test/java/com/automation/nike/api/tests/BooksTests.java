package com.automation.nike.api.tests;

import com.automation.nike.api.config.ApiConfig;
import com.automation.nike.api.models.Book;
import com.automation.nike.api.utils.ApiRequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class BooksTests extends ApiBaseTest {

    @Test(description = "Verify GET /books returns a list of books")
    public void testGetAllBooks() {
        Response response = ApiRequestBuilder.getRequest(ApiConfig.BOOKS_ENDPOINT);

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_OK, 
                "Should return 200 OK");
        
        List<Book> books = response.jsonPath().getList(".", Book.class);
        assertNotNull(books, "Books list should not be null");
        assertFalse(books.isEmpty(), "Books list should not be empty");
        System.out.println("✓ Test passed: Retrieved " + books.size() + " books");
    }

    @Test(description = "Verify GET /books with type=fiction filter")
    public void testGetBooksByType() {
        Response response = ApiRequestBuilder.getRequestWithQueryParam(ApiConfig.BOOKS_ENDPOINT, "type", "fiction");

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_OK, 
                "Should return 200 OK");
        
        List<Book> books = response.jsonPath().getList(".", Book.class);
        assertNotNull(books, "Books list should not be null");
        
        for (Book book : books) {
            assertEquals(book.getType(), "fiction", 
                    "All books should be of type 'fiction'");
        }
        System.out.println("✓ Test passed: Retrieved " + books.size() + " fiction books");
    }

    @Test(description = "Verify GET /books with limit query parameter")
    public void testGetBooksWithLimit() {
        int limit = 5;
        Response response = ApiRequestBuilder.getRequestWithQueryParam(ApiConfig.BOOKS_ENDPOINT, "limit", String.valueOf(limit));

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_OK, 
                "Should return 200 OK");
        
        List<Book> books = response.jsonPath().getList(".", Book.class);
        assertNotNull(books, "Books list should not be null");
        assertTrue(books.size() <= limit, 
                "Number of books should be <= " + limit);
        System.out.println("✓ Test passed: Retrieved " + books.size() + " books (limit: " + limit + ")");
    }

    @Test(description = "Verify GET /books with both type and limit parameters")
    public void testGetBooksWithTypeAndLimit() {
        Response response = ApiRequestBuilder.getRequestWithMultipleParams(
                ApiConfig.BOOKS_ENDPOINT, 
                "type", "fiction", 
                "limit", "3");

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_OK, 
                "Should return 200 OK");
        
        List<Book> books = response.jsonPath().getList(".", Book.class);
        assertNotNull(books, "Books list should not be null");
        assertTrue(books.size() <= 3, "Number of books should be <= 3");
        
        for (Book book : books) {
            assertEquals(book.getType(), "fiction", 
                    "All books should be of type 'fiction'");
        }
        System.out.println("✓ Test passed: Retrieved " + books.size() + " fiction books with limit 3");
    }

    @Test(description = "Verify GET /books/:bookId returns a single book")
    public void testGetSingleBook() {
        // First get a list of books to find a valid book ID
        Response listResponse = ApiRequestBuilder.getRequest(ApiConfig.BOOKS_ENDPOINT);
        assertEquals(listResponse.getStatusCode(), ApiConfig.HTTP_OK, 
                "Should return 200 OK");
        
        List<Book> books = listResponse.jsonPath().getList(".", Book.class);
        assertFalse(books.isEmpty(), "Books list should not be empty");
        
        int bookId = books.get(0).getId();
        
        // Now get the specific book
        Response response = ApiRequestBuilder.getRequest(ApiConfig.BOOKS_ENDPOINT + "/" + bookId);
        
        assertEquals(response.getStatusCode(), ApiConfig.HTTP_OK, 
                "Should return 200 OK");
        
        Book book = response.jsonPath().getObject(".", Book.class);
        assertNotNull(book, "Book should not be null");
        assertEquals(book.getId(), bookId, "Book ID should match requested ID");
        assertNotNull(book.getName(), "Book name should not be null");
        System.out.println("✓ Test passed: Retrieved book with ID " + bookId + " - " + book.getName());
    }

    @Test(description = "Verify GET /books/:bookId with invalid ID returns 404")
    public void testGetInvalidBook() {
        int invalidBookId = 99999;
        Response response = ApiRequestBuilder.getRequest(ApiConfig.BOOKS_ENDPOINT + "/" + invalidBookId);

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_NOT_FOUND, 
                "Should return 404 Not Found for invalid book ID");
        System.out.println("✓ Test passed: Invalid book ID returns 404");
    }

    @Test(description = "Verify limit parameter rejects values > 20")
    public void testGetBooksWithLimitAboveMax() {
        Response response = ApiRequestBuilder.getRequestWithQueryParam(ApiConfig.BOOKS_ENDPOINT, "limit", "25");

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_BAD_REQUEST, 
                "Should return 400 Bad Request for limit > 20");
        System.out.println("✓ Test passed: Limit above 20 returns 400");
    }
}
