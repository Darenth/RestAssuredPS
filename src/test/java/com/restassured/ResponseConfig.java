package com.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.listener.ResponseValidationFailureListener;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.config.FailureConfig.failureConfig;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static org.hamcrest.Matchers.equalTo;

public class ResponseConfig {

    public static final String BASE_URL = "https://api.github.com/";

    @BeforeClass
    public void setup() {
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(404)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @AfterClass
    public  void clenup(){
        RestAssured.responseSpecification=null;
    }


    @Test
    public void testWithSpecOne() {
        RestAssured.get(BASE_URL + "non/existing/url");
    }

    @Test
    public void testWithSpecTwo() {
        RestAssured.get(BASE_URL + "non/existing/url");
    }


}
