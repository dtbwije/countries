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

import static org.springframework.http.MediaType.APPLICATION_JSON;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CountryController.class)
@Import(CountryServiceImpl.class)
class CountryControllerTest {

    @Autowired
    private WebTestClient webClient;

    public static MockWebServer mockBackEnd;
    private static RestCountriesService restCountriesService;

    private static final String EXPECTED_LIST = "[{\"name\":\"Afghanistan\",\"countryCode\":\"Kabul\"},{\"name\":\"Åland Islands\",\"countryCode\":\"Mariehamn\"},{\"name\":\"Albania\",\"countryCode\":\"Tirana\"}]";

    private static final String EXPECTED_COUNTRY = "{\"name\":\"Afghanistan\",\"code\":\"AF\",\"capital\":\"Kabul\",\"population\":2.7657145E7,\"flagFileUrl\":\"https://restcountries.eu/data/afg.svg\"}";

    @BeforeAll
    static void setUp() throws IOException {
        restCountriesService = new RestCountriesService();
        restCountriesService.startForSuccess();
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
        webClient.get().uri("/countryservice/countries").header(HttpHeaders.ACCEPT,"application/json").exchange().expectHeader()
                .contentType(APPLICATION_JSON).expectBody().json(EXPECTED_LIST);
    }

    @Test
    @DisplayName("")
    void testGetCountriesByNameIsASuccess() throws Exception {
        webClient.get().uri("/countryservice/country/name/Sri Lanka").header(HttpHeaders.ACCEPT,"application/json").exchange()
                .expectHeader().contentType(APPLICATION_JSON).expectBody().json(EXPECTED_COUNTRY);
    }
}