package com.automation.nike.api.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import com.automation.nike.api.config.ApiConfig;

public class ApiRequestBuilder {

    public static RequestSpecification getBaseRequest() {
        return given()
                .baseUri(ApiConfig.BASE_URL)
                .contentType("application/json")
                .accept("application/json");
    }

    public static RequestSpecification getAuthenticatedRequest(String token) {
        return getBaseRequest()
                .header("Authorization", "Bearer " + token);
    }

    public static Response getRequest(String endpoint) {
        return getBaseRequest()
                .when()
                .get(endpoint);
    }

    public static Response getRequestWithQueryParam(String endpoint, String paramName, String paramValue) {
        return getBaseRequest()
                .queryParam(paramName, paramValue)
                .when()
                .get(endpoint);
    }

    public static Response getRequestWithMultipleParams(String endpoint, String... params) {
        RequestSpecification spec = getBaseRequest();
        for (int i = 0; i < params.length; i += 2) {
            spec = spec.queryParam(params[i], params[i + 1]);
        }
        return spec.when().get(endpoint);
    }

    public static Response postRequest(String endpoint, Object body) {
        return getBaseRequest()
                .body(body)
                .when()
                .post(endpoint);
    }

    public static Response postRequestWithAuth(String endpoint, Object body, String token) {
        return getAuthenticatedRequest(token)
                .body(body)
                .when()
                .post(endpoint);
    }

    public static Response patchRequest(String endpoint, Object body, String token) {
        return getAuthenticatedRequest(token)
                .body(body)
                .when()
                .patch(endpoint);
    }

    public static Response deleteRequest(String endpoint, String token) {
        return getAuthenticatedRequest(token)
                .when()
                .delete(endpoint);
    }

    public static String getStringFromResponse(Response response, String jsonPath) {
        try {
            String body = response.getBody().asString();
            if (body == null || body.isEmpty()) {
                return null;
            }
            return response.jsonPath().getString(jsonPath);
        } catch (Exception e) {
            return null;
        }
    }
}
