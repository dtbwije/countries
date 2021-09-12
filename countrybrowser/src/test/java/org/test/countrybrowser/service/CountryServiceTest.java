package org.test.countrybrowser.service;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.test.countrybrowser.entity.CountryInList;
import org.test.countrybrowser.repository.CountryRepository;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountryServiceTest {

    @Autowired
    private CountryService subject;

    @MockBean
    private CountryRepository countryRepository;

    private List<CountryInList> countryList;

    @BeforeEach
    void setupTests(){

        countryList = Arrays.asList(CountryInList.builder().countryCode("FI").countryName("Finland").build(),
                CountryInList.builder().countryCode("LK").countryName("Sri Lanka").build(),
                CountryInList.builder().countryCode("GB").countryName("Great Britain").build());
        Mockito.when(countryRepository.findAll()).thenReturn(countryList);
        Mockito.when(countryRepository.findByCountryName("Finland")).thenReturn(countryList.get(0));
        Mockito.when(countryRepository.findByCountryName("Sri Lanka")).thenReturn(countryList.get(1));
        Mockito.when(countryRepository.findByCountryName("Great Britain")).thenReturn(countryList.get(2));
    }

    @Test
    @DisplayName("Valid country list is returned with correct parameters.")
    void testGetCountryListIsSuccessWithCorrectParams() throws IOException {
        Flux<CountryInList> actual = subject.getCountryList();
        actual.
        assertEquals(3,actual.size());
        assertEquals(countryList,actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    @DisplayName("Valid country is returned with existing name  parameters.")
    void testGetCountryByNameIsASuccessWithCorrectParams(int index) {
        assertEquals(subject.getCountryByName(countryList.get(index).getCountryName()),countryList.get(index));
    }

    @Test
    void testHttpClientResponse() throws IOException {
        final CloseableHttpResponse closeableHttpResponse = subject.getCountryListFromCountryService();
        assertEquals(closeableHttpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        String bodyAsString = EntityUtils.toString(closeableHttpResponse.getEntity());
        assertThat(bodyAsString, notNullValue());
    }
}