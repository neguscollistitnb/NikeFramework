package com.automation.nike.api.tests;

import com.automation.nike.api.config.ApiConfig;
import com.automation.nike.api.models.ApiClient;
import com.automation.nike.api.utils.ApiRequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AuthenticationTests extends ApiBaseTest {

    @Test(description = "Verify registration of a new API client")
    public void testRegisterNewApiClient() {
        ApiClient client = new ApiClient(
                "TestClient_" + System.currentTimeMillis(),
                "test_" + System.currentTimeMillis() + "@example.com"
        );

        Response response = ApiRequestBuilder.postRequest(ApiConfig.API_CLIENTS_ENDPOINT, client);

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_CREATED, 
                "Should return 201 Created");
        
        String token = response.jsonPath().getString("accessToken");
        assertNotNull(token, "Access token should not be null");
        assertFalse(token.isEmpty(), "Access token should not be empty");
        System.out.println("✓ Test passed: API client registered with token: " + token);
    }

    @Test(description = "Verify registration fails for duplicate email")
    public void testRegisterDuplicateApiClient() {
        String uniqueEmail = "duplicate_test_" + System.currentTimeMillis() + "@example.com";
        ApiClient client1 = new ApiClient("TestClient1", uniqueEmail);
        
        // Register first client
        Response response1 = ApiRequestBuilder.postRequest(ApiConfig.API_CLIENTS_ENDPOINT, client1);
        assertEquals(response1.getStatusCode(), ApiConfig.HTTP_CREATED, 
                "First registration should succeed");

        // Try to register second client with same email
        ApiClient client2 = new ApiClient("TestClient2", uniqueEmail);
        Response response2 = ApiRequestBuilder.postRequest(ApiConfig.API_CLIENTS_ENDPOINT, client2);

        assertEquals(response2.getStatusCode(), ApiConfig.HTTP_CONFLICT, 
                "Should return 409 Conflict for duplicate email");
        System.out.println("✓ Test passed: Duplicate email registration rejected");
    }

    @Test(description = "Verify API client registration requires all required fields")
    public void testRegisterClientMissingEmail() {
        String incompleteJson = "{\"clientName\": \"TestClient\"}";

        Response response = ApiRequestBuilder.getBaseRequest()
                .body(incompleteJson)
                .when()
                .post(ApiConfig.API_CLIENTS_ENDPOINT);

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_BAD_REQUEST, 
                "Should return 400 Bad Request when email is missing");
        System.out.println("✓ Test passed: Missing email validation works");
    }

    @Test(description = "Verify valid token format")
    public void testTokenFormat() {
        ApiClient client = new ApiClient(
                "TokenTestClient_" + System.currentTimeMillis(),
                "token_test_" + System.currentTimeMillis() + "@example.com"
        );

        Response response = ApiRequestBuilder.postRequest(ApiConfig.API_CLIENTS_ENDPOINT, client);
        assertEquals(response.getStatusCode(), ApiConfig.HTTP_CREATED, 
                "Should return 201 Created");

        String token = response.jsonPath().getString("accessToken");
        assertNotNull(token, "Token should not be null");
        assertTrue(token.matches("[a-zA-Z0-9_-]+"), 
                "Token should contain only alphanumeric characters, underscores, and hyphens");
        System.out.println("✓ Test passed: Token format is valid");
    }
}
