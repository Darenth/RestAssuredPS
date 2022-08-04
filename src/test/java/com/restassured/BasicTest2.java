package com.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BasicTest2 {
    public static final String BASE_URL = "https://api.github.com";
    Response response;

    @BeforeClass
    public void BeforeClass() {
        response = RestAssured.get(BASE_URL);
        //ystem.out.println("BeforeClass");
    }


    @Test
    public void convenienceMethods() {
        RestAssured.get(BASE_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .header("x-ratelimit-limit", "60");
    }


    @Test
    public void complexHamcrestMatchers() {
        RestAssured.get(BASE_URL)
                .then()
                .header("x-ratelimit-limit", Integer::parseInt, Matchers.equalTo(60));
    }


    @Test
    public void prettyPrint() {
        RestAssured.get(BASE_URL)
                .prettyPrint();// all details of response in pretty way for debugging
    }

    @Test
    public void getHeaders() {
        Headers headers = response.getHeaders();
        String val = headers.getValue("header1");
        int size = headers.size();
        List<Header> list = headers.asList();
        boolean isPresent = headers.hasHeaderWithName("header2");
        //assertTrue(isPresent);

    }

    @Test
    public void timeExample() {
        response.getTime();
        response.getTimeIn(TimeUnit.MINUTES);

    }

}
