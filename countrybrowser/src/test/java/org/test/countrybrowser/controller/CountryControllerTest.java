package org.test.countrybrowser.controller;

import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.test.countrybrowser.service.CountryService;
import org.test.countrybrowser.service.CountryServiceImpl;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CountryController.class)
@Import(CountryServiceImpl.class)
class CountryControllerTest {

    @Autowired
    private WebTestClient webClient;

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