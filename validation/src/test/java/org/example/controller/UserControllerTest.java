package org.example.controller;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.example.domain.User;
import org.example.domain.UserV2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@DisplayName("UserController 관련 테스트")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @DisplayName("사용자 생성 성공 | 200 ok")
    @Test
    void 사용자_생성_성공() {
        User user = new User();
        user.setName("user1");
        user.setAge(20);
        user.setEmail("user@user.com");
        user.setAboutMe("I am a user");
        user.setWorking(true);

        ExtractableResponse<Response> response = UserRestAssured.사용자_생성_요청(user);

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @DisplayName("사용자 생성 실패 | 400 bad request")
    @Test
    void 사용자_생성_실패() {
        User user = new User();
        ExtractableResponse<Response> response = UserRestAssured.사용자_생성_요청(user);

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @DisplayName("사용자 V2 생성 실패 | 400 bad request")
    @Test
    void 사용자V2_생성_실패() {
        UserV2 user = new UserV2();
        ExtractableResponse<Response> response = UserRestAssured.사용자V2_생성_요청(user);

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}
