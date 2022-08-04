package com.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class HeadAndOptionsDemo {

    public static final String BASE_URL = "https://api.github.com/";


    @Test
    public  void headTest(){
        RestAssured.head(BASE_URL)
                .then()
                .statusCode(200)
                .body(emptyOrNullString());
    }

    @Test
    public  void optionTest(){
        RestAssured.options(BASE_URL)
                .then()
                .statusCode(204) //no content
                .header("access-control-allow-methods",equalTo("GET, POST, PATCH, PUT, DELETE"))
                .body(emptyOrNullString());
    }
}
