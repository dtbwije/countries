package org.test.countrybrowser.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/countries")
public class CountrybrowserController {

/*    @Autowired
    private CountryService countryService;*/

    @GetMapping("/")
    public String addCountry(){
        log.info("Saving the country in the org.test.countrybrowser.controller.");
        return "This really works";
        //return countryService.addCountry(country)  Country country);
    }
/*
    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable("id") Long id){
        log.info("Retrieving country in the org.test.countrybrowser.controller.");
        return countryService.getCountryById(id);
    }*/




}
