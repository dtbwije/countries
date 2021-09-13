package org.test.countrybrowser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.countrybrowser.dto.response.CountryInfo4Response;
import org.test.countrybrowser.dto.response.CountryList4Response;
import org.test.countrybrowser.service.CountryService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping("/countryservice")
public class CountryController {

    @Autowired
    private CountryService countryService;


    @GetMapping("/countries")
    public Flux<CountryList4Response> getCountryList() throws IOException {
        return countryService.getCountryList();
    }

    @GetMapping("/country/name/{name}")
    public Mono<CountryInfo4Response> getCountryByName(@PathVariable("name") String countryName) {
        return countryService.getCountryByName(countryName);
    }

}
