package org.test.countrybrowser.service;


import org.test.countrybrowser.entity.CountryInList;
import org.test.countrybrowser.entity.CountryInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;


public interface CountryService {

    Flux<CountryInList> getCountryList() throws IOException;

    Flux<CountryInfo> getCountryByName(String countryName);
}
