package com.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BasicTest3Body {
    public static final String BASE_URL = "https://api.github.com/";
    Response response;

    @BeforeClass
    public void BeforeClass() {

        //ystem.out.println("BeforeClass");
    }


    @Test
    public void jsonPathReturnsMap() {
        response = RestAssured.get("https://api.github.com/rate_limit");
        ResponseBody body = response.getBody();
        JsonPath jPath = body.jsonPath();
        JsonPath jPath2 = response.body().jsonPath();

        Map<String, String> fullJson = jPath2.get();
        Map<String, String> subMap = jPath2.get("resources");
        Map<String, String> subMap2 = jPath2.get("resources.core");

        int value = jPath.get("resources.core.limit");
        int value2 = jPath.get("resources.graphql.remaining");

        System.out.println("fullJson " + fullJson);
        System.out.println("subMap " + subMap);
        System.out.println("subMap2 " + subMap2);
        System.out.println("value " + value);
        System.out.println("value2 " + value2);

    }

    @Test
    public void complexBodyExample() {
        RestAssured.get(BASE_URL + "users/andrejs-ps")
                .then()
                .body("url", response -> Matchers.containsString(response.body().jsonPath().get("login")));


    }

}
