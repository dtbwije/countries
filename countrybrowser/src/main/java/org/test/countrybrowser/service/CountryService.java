package org.test.countrybrowser.service;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.test.countrybrowser.entity.Country;

import java.io.IOException;
import java.util.List;


public interface CountryService {
    Country getCountry(Country country);

    List<Country> getCountryList();

    Country getCountryById(Long countryId);

    Country getCountryByName(String countryName);

    CloseableHttpResponse getCountryListFromCountryService() throws IOException;
}
