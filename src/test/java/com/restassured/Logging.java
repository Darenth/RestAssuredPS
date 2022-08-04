package com.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Logging {

    public static final String BASE_URL = "https://jsonplaceholder.typecode.com/posts";
    public static final String BASE_URL1 = "https://api.github.com/user/repos";
    public static final String TOKEN = "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";


    @Test
    public void testWithSpecOne() {
        RestAssured.given().log().all()
                .when()
                .get(BASE_URL)
                .then()
                .log().headers();
    }

    @Test
    public void basicValidationExample() {
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }



    @Test
    public  void myTest(){
        RestAssured
                .given()
                    .header("Authorization","token "+TOKEN)
                    .body("{\"name\": \"AAa\"}")
                .when()
                    .post(BASE_URL1)
                .then()
                .statusCode(201);

    }

    @Test(description = "deleting")
    public  void  deleteMyRepo(){
        RestAssured
                .given()
                .header("Authorization", "token " + TOKEN)
                .body("{\"name\":\"AAa\" }")
                .delete("https://api.github.com/repos/Darenth/AAa")
                .then()
                .statusCode(204);
    }

}
