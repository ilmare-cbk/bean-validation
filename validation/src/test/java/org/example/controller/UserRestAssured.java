package org.example.controller;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.example.domain.User;
import org.example.domain.UserV2;
import org.springframework.http.MediaType;

public class UserRestAssured {
    private UserRestAssured() {
    }

    public static ExtractableResponse<Response> 사용자_생성_요청(User user) {
        return RestAssured
                .given().log().all()
                .body(user)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("/users")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 사용자V2_생성_요청(UserV2 user) {
        return RestAssured
                .given().log().all()
                .body(user)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("/v2/users")
                .then().log().all()
                .extract();
    }
}
