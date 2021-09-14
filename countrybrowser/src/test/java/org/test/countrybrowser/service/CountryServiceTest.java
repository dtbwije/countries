package org.test.countrybrowser.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.reactive.function.client.WebClient;
import org.test.countrybrowser.client.impl.RestClientImpl;
import org.test.countrybrowser.dto.request.CountryInList;
import org.test.countrybrowser.dto.response.CountryList4Response;
import org.test.countrybrowser.mock.RestCountriesService;
import reactor.core.publisher.Flux;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CountryServiceTest {

    @Autowired
    private CountryService subject;

    private CountryInList[] countryList;
    private CountryList4Response[] countryList4Responses;
    private static RestCountriesService restCountriesService;

    @BeforeEach
    void setupTests() throws IOException {
        restCountriesService = new RestCountriesService();
        countryList = new CountryInList[]{ CountryInList.builder().alpha2Code("FI").name("Finland").build(),
                CountryInList.builder().alpha2Code("LK").name("Sri Lanka").build(),
                CountryInList.builder().alpha2Code("GB").name("Great Britain").build()};
        Flux<CountryInList> fluxList = Flux.fromArray(countryList);

    }

    @Test
    @Disabled
    @DisplayName("Valid country list is returned with correct parameters.")
    void testGetCountryListIsSuccessWithCorrectParams() throws IOException {
        restCountriesService.startForSuccess();
        countryList4Responses = new CountryList4Response[]{ CountryList4Response.builder().countryCode("FI").name("Finland").build(),
                CountryList4Response.builder().countryCode("LK").name("Sri Lanka").build(),
                CountryList4Response.builder().countryCode("GB").name("Great Britain").build()};

        Flux<CountryList4Response> expected = Flux.fromArray(countryList4Responses);

        Flux<CountryList4Response> actual = subject.getCountryList();

        assertEquals(expected,actual);
    }


}