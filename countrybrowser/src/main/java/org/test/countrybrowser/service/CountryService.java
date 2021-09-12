package org.test.countrybrowser.service;


import org.test.countrybrowser.dto.request.CountryInList;
import org.test.countrybrowser.dto.request.CountryInfo;
import reactor.core.publisher.Flux;

import java.io.IOException;


public interface CountryService {

    Flux<CountryInList> getCountryList() throws IOException;

    Flux<CountryInfo> getCountryByName(String countryName);
}
