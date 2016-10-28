package me.brendler.integration;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class CurrencyConverterTests {

    @Before
    public void configureRestAssuredClient() throws Exception {
        RestAssured.baseURI = "http://localhost:8080/";
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetOk() throws Exception {
        // @formatter:off
        given()
                .request()
                .contentType(MediaType.APPLICATION_JSON_UTF8.toString())
				.param("amount", 1.0)
				.param("from", "EUR")
				.param("to", "USD")
                .log().all()
        .when()
                .get("/convert")
        .then()
                .statusCode(HttpStatus.OK.value())
                .log().body()
        ;
        // @formatter:on
    }

    @Test
    public void testGetNotOkInvalidFromCurrency() throws Exception {
        // @formatter:off
        given()
                .request()
                .contentType(MediaType.APPLICATION_JSON_UTF8.toString())
				.param("amount", 1.0)
				.param("from", "ABC")
				.param("to", "USD")
                .log().all()
        .when()
                .get("/convert")
        .then()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .log().body()
        ;
        // @formatter:on
    }

}
