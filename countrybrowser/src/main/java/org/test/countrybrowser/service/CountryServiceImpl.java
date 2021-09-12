package org.test.countrybrowser.service;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.test.countrybrowser.client.RestClient;
import org.test.countrybrowser.client.RestClientImpl;
import org.test.countrybrowser.dto.request.CountryInList;
import org.test.countrybrowser.dto.request.CountryInfo;
import org.test.countrybrowser.dto.response.CountryInfo4Response;
import org.test.countrybrowser.dto.response.CountryList4Response;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Flux<CountryList4Response> getCountryList() throws IOException {
        log.info("Getting all countries list at the service.");
        return restClient
                .get(RestClient.GET_COUNTRIES_LIST_URL)
                .bodyToFlux(CountryInList.class).log()
                .map(countryInList -> new CountryList4Response(countryInList.getName(),countryInList.getCapital()));
    }

    @SneakyThrows
    @Override
    public Mono<CountryInfo4Response> getCountryByName(@NonNull String countryName) {
        String url = RestClient.GET_COUNTRY_URL.replace("{countryName}", countryName);
        return restClient.get(url).bodyToFlux(CountryInfo.class).next()
                .log()
                .map(countryInfo -> new CountryInfo4Response(countryInfo.getName(),
                        countryInfo.getAlpha2Code(),
                        countryInfo.getCapital(),
                        countryInfo.getPopulation(),
                        countryInfo.getFlagFileUrl()));
    }

}
