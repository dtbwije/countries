package org.test.countrybrowser.contract;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.test.countrybrowser.CountrybrowserApplication;
import org.test.countrybrowser.controller.CountryController;
import org.test.countrybrowser.entity.Country;
import org.test.countrybrowser.service.CountryService;


@SpringBootTest(classes = CountrybrowserApplication.class)
public class BaseCountryServiceTest {

    @Autowired
    CountryController countryController;

    @MockBean
    CountryService countryService;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(countryController);

        Mockito.when(countryService.getCountryByName("Finland"))
                .thenReturn(new Country(1L, "Finland", "FI"));
    }
}
