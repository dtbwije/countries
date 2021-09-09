package org.test.countrybrowser.service;


import org.test.countrybrowser.entity.Country;

import java.util.List;


public interface CountryService {
    Country getCountry(Country country);

    List<Country> getCountryList();

    Country getCountryById(Long countryId);

    Country getCountryByName(String countryName);
}
