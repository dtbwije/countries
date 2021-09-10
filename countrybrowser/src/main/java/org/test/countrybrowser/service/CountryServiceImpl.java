package org.test.countrybrowser.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.countrybrowser.entity.Country;
import org.test.countrybrowser.repository.CountryRepository;

import java.util.List;
import java.util.function.Supplier;

@Service
@Slf4j
public class CountryServiceImpl implements CountryService{

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country getCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> getCountryList() {
        log.info("Getting all countries list at the service.");
        List<Country> countryList = countryRepository.findAll();
        return countryList;
    }

    @Override
    public Country getCountryById(Long countryId) {
        CountrySupplier supplier = () -> {
            Country a = new Country();
            a.setCountryName("Non existent");
            a.setId(new Long(1234));
            a.setCountryCode("Non");
            return a;
        };
        return countryRepository.findById(countryId).orElseGet((Supplier<? extends Country>) supplier);
    }

    @Override
    public Country getCountryByName(String countryName) {
        return countryRepository.findByCountryName(countryName);
    }

    @FunctionalInterface
    interface CountrySupplier{
        Country newCountry();
    }
}
