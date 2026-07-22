package com.automation.nike.api.tests;

import org.testng.annotations.BeforeClass;
import com.automation.nike.api.models.ApiClient;
import com.automation.nike.api.utils.ApiRequestBuilder;
import com.automation.nike.api.config.ApiConfig;
import io.restassured.response.Response;
import com.google.gson.Gson;

public class ApiBaseTest {
    protected String accessToken;
    protected Gson gson = new Gson();

    @BeforeClass
    public void setupAuthentication() {
        ApiClient client = new ApiClient("Nike_Test_Client_" + System.currentTimeMillis(), 
                                         "nike_test_" + System.currentTimeMillis() + "@example.com");
        
        Response response = ApiRequestBuilder.postRequest(ApiConfig.API_CLIENTS_ENDPOINT, client);
        
        if (response.getStatusCode() == ApiConfig.HTTP_CREATED) {
            accessToken = response.jsonPath().getString("accessToken");
            System.out.println("✓ Authentication successful. Token: " + accessToken);
        } else if (response.getStatusCode() == ApiConfig.HTTP_CONFLICT) {
            System.out.println("⚠ Client already registered, attempting to reuse existing client");
        }
    }
}
