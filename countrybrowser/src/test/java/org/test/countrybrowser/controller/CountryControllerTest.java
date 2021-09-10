package org.test.countrybrowser.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.test.countrybrowser.entity.Country;
import org.test.countrybrowser.service.CountryService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@WebMvcTest
class CountryControllerTest {

    @Autowired
    private CountryController subject;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    private List<Country> inputCountryList;

    private List<Country> outputCountryList;

    @BeforeEach
    public void setupTest(){
        inputCountryList = Arrays.asList(Country.builder().countryCode("FI").countryName("Finland").build(),
                Country.builder().countryCode("LK").countryName("Sri Lanka").build(),
                Country.builder().countryCode("GB").countryName("Great Britain").build());

        outputCountryList = Arrays.asList(Country.builder().id(1L).countryCode("FI").countryName("Finland").build(),
                Country.builder().id(2L).countryCode("LK").countryName("Sri Lanka").build(),
                Country.builder().id(3L).countryCode("GB").countryName("Great Britain").build());

        when(countryService.getCountryList()).thenReturn(outputCountryList);
        when(countryService.getCountryByName("Finland")).thenReturn(outputCountryList.get(0));


    }

    @SneakyThrows
    @Test
    @DisplayName("get country list is a success.")
    void testGetCountriesIsASuccess() {
        mockMvc.perform(MockMvcRequestBuilders.get("/countryservice/countries").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("")
    void testGetCountriesByNameIsASuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/countryservice/country/name/Finland").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }
}