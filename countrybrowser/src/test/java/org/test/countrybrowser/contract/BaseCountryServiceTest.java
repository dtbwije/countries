package org.test.countrybrowser.contract;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.test.countrybrowser.CountrybrowserApplication;
import org.test.countrybrowser.controller.CountryController;
import org.test.countrybrowser.entity.CountryInList;
import org.test.countrybrowser.service.CountryService;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;


@SpringBootTest(classes = CountrybrowserApplication.class)
public class BaseCountryServiceTest {

    @Autowired
    CountryController countryController;

    @MockBean
    CountryService countryService;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(countryController);

        List<CountryInList> countryList = Arrays.asList(new CountryInList("Finland", "FI"),new CountryInList("Sweden","SW"), new CountryInList("Norway","NW"));

        Mockito.when(countryService.getCountryByName("Finland"))
                .thenReturn(new CountryInList( "Finland", "FI"));
        Mockito.when(countryService.getCountryList())
                .thenReturn(countryList);
    }
}
