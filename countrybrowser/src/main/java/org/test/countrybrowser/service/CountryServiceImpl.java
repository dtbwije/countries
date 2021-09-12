package org.test.countrybrowser.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.test.countrybrowser.client.RestClient;
import org.test.countrybrowser.client.RestClientImpl;
import org.test.countrybrowser.dto.request.CountryInList;
import org.test.countrybrowser.dto.request.CountryInfo;
import reactor.core.publisher.Flux;

import java.io.IOException;

@Service
@Slf4j
public class CountryServiceImpl implements CountryService{

    //TODO implement autowire
    private RestClient restClient;

    public CountryServiceImpl(){
        restClient = new RestClientImpl();
    }


    @Override
    public Flux<CountryInList> getCountryList() throws IOException {
        log.info("Getting all countries list at the service.");
        return  restClient.get(RestClient.GET_COUNTRIES_LIST_URL).bodyToFlux(CountryInList.class);

    }

    @SneakyThrows
    @Override
    public Flux<CountryInfo> getCountryByName(String countryName) {
        return restClient.get(RestClient.GET_COUNTRY_URL).bodyToFlux(CountryInfo.class);
    }

}
