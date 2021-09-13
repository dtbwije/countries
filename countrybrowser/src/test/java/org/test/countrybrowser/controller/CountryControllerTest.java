package org.test.countrybrowser.controller;

import lombok.SneakyThrows;
import okhttp3.mockwebserver.MockWebServer;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.test.countrybrowser.mock.RestCountriesService;
import org.test.countrybrowser.service.CountryServiceImpl;

import java.io.IOException;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CountryController.class)
@Import(CountryServiceImpl.class)
class CountryControllerTest {

    @Autowired
    private WebTestClient webClient;

    public static MockWebServer mockBackEnd;
    private static RestCountriesService restCountriesService;

    @BeforeAll
    static void setUp() throws IOException {
        restCountriesService = new RestCountriesService();
        restCountriesService.start();
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @BeforeEach
    void initialize() {
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
        restCountriesService.stop();
    }

    @SneakyThrows
    @Test
    @DisplayName("get country list is a success.")
    void testGetCountriesIsASuccess() {
        webClient.get().uri("/countryservice/countries").header(HttpHeaders.ACCEPT,"application/json").exchange().expectStatus().isOk();
    }

    @Test
    @DisplayName("")
    void testGetCountriesByNameIsASuccess() throws Exception {
        webClient.get().uri("/countryservice/country/name/Albania").header(HttpHeaders.ACCEPT,"application/json").exchange().expectStatus().isOk();
    }
}