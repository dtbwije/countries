package org.test.countrybrowser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.test.countrybrowser.entity.Country;
import org.test.countrybrowser.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/countryservice")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/country")
    public Country getCountries(@RequestBody Country country){
        return countryService.getCountry(country);
    }

    @GetMapping("/countries")
    public List<Country> getCountryList() {
        return countryService.getCountryList();
    }

    @GetMapping("/country/{id}")
    public Country getCountryById(@PathVariable("id") Long countryId){
        return countryService.getCountryById(countryId);
    }

    @GetMapping("/country/name/{name}")
    public Country getCountryByName(@PathVariable("name") String countryName) {
        return countryService.getCountryByName(countryName);
    }


}
