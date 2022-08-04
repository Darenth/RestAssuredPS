package com.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class GlobalConstants {


    @BeforeSuite
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api/users";
        RestAssured.rootPath = "data";
    }

    @Test
    public void repeatingItems() {
        RestAssured.get()
                .then()
                .body("id[0]", equalTo(1));


    }
}
