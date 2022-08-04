package com.restassured;

import groovyjarjarantlr.Token;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;

public class OtherMethods {

    public static final String BASE_URL = "https://api.github.com/user/repos";
    public static final String TOKEN = "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";


    @Test(description = "Create a repo")
    public  void postTest(){
        RestAssured
                .given()
                    .header("Authorization","token "+ TOKEN)
                    .body("{\"name\": \"deleteme-patched\", \"description\": \"test1\"}")
                .when()
                    .post(BASE_URL)
                .then()
                    .statusCode(201);
    }



    @Test(description = "Update a repo")
    public  void patchTest(){
        RestAssured
                .given()
                .header("Authorization","token "+ TOKEN)
                .body("{ \"description\": \"test3\"}")
                .when()
                .patch("https://api.github.com/repos/Darenth/deleteme-patched")
                .then()
                .statusCode(200);
    }

    @Test(description = "Update via put method a repo")
    public  void putTest(){
        RestAssured
                .given()
                .header("Authorization","token "+ TOKEN)
                .body("{\"name\": \"deleteme-patched32\", \"description\": \"test1321\"}")
                .when()
                .put(BASE_URL)
                .then()
                .statusCode(201);
    }

    @Test(description = "Delete a repo")
    public  void deleteTest(){
        RestAssured
                .given()
                .header("Authorization","token "+ TOKEN)
                .when()
                .delete("https://api.github.com/repos/Darenth/deleteme-patched1")
                .then()
                .statusCode(204);
    }
}
