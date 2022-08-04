package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class ValidatableNestedBody {

    public static final String BASE_URL = "https://api.github.com/";


    @Test
    public  void nestedBodyValidation(){
        RestAssured.get(BASE_URL + "rate_limit")
                .then()
                .rootPath("resources.core.")
                    .body("limit",equalTo(60))
                    .body("remaining",lessThanOrEqualTo(60))
                    .body("reset",notNullValue())
                .rootPath("resources.search.")
                    .body("limit",equalTo(10))
                    .body("remaining",lessThanOrEqualTo(10))
                .noRootPath()
                    .body("resources.graphql.limit", is(0)); // this is no best practice by Andrejs, if I goo his understood.

    }
}
