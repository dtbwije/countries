package org.test.countrybrowser.service;


import org.test.countrybrowser.dto.response.CountryInfo4Response;
import org.test.countrybrowser.dto.response.CountryList4Response;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;


public interface CountryService {

    Flux<CountryList4Response> getCountryList() throws IOException;

    Mono<CountryInfo4Response> getCountryByName(String countryName);
}
