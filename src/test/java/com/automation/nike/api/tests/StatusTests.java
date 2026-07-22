package com.automation.nike.api.tests;

import com.automation.nike.api.config.ApiConfig;
import com.automation.nike.api.utils.ApiRequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StatusTests extends ApiBaseTest {

    @Test(description = "Verify API status endpoint returns 200")
    public void testGetApiStatus() {
        Response response = ApiRequestBuilder.getRequest(ApiConfig.STATUS_ENDPOINT);

        assertEquals(response.getStatusCode(), ApiConfig.HTTP_OK, 
                "Status endpoint should return 200 OK");
        assertEquals(response.jsonPath().getInt("status"), 200, 
                "Status field should be 200");
        System.out.println("✓ Test passed: API status is 200");
    }
}
