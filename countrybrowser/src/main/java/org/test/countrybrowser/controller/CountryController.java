package org.test.countrybrowser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.test.countrybrowser.entity.CountryInList;
import org.test.countrybrowser.entity.CountryInfo;
import org.test.countrybrowser.service.CountryService;
import reactor.core.publisher.Flux;

import java.io.IOException;

@RestController
@RequestMapping("/countryservice")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public Flux<CountryInList> getCountryList() throws IOException {
        return countryService.getCountryList();
    }

    @GetMapping("/country/name/{name}")
    public Flux<CountryInfo> getCountryByName(@PathVariable("name") String countryName) {
        return countryService.getCountryByName(countryName);
    }


}
