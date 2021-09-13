package org.test.countrybrowser;

import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.test.countrybrowser.controller.CountryController;
import org.test.countrybrowser.mock.RestCountriesService;
import org.test.countrybrowser.service.CountryServiceImpl;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CountryController.class)
@Import(CountryServiceImpl.class)
@AutoConfigureWebTestClient()
public class MockServerTests {

    private WebTestClient webClient;

    private RestCountriesService restCountriesService;

    @BeforeEach
    void initialize() {
        webClient = WebTestClient.bindToServer().baseUrl("http://localhost:9002").build();
        restCountriesService = new RestCountriesService();
        restCountriesService.start();
    }

    @AfterEach
    void tearDown(){
        restCountriesService.stop();
    }


    @SneakyThrows
    @Test
    @DisplayName("Testing the mock server get country list")
    void testGetCountriesIsASuccess() {
        webClient.get().uri("/all").header(HttpHeaders.ACCEPT,"application/json").exchange().expectStatus().isOk();
        webClient.get().uri("/name/Albania").header(HttpHeaders.ACCEPT,"application/json").exchange().expectStatus().isOk();
    }

}
