package org.test.countrybrowser.client;

import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

public interface RestClient {

    String GET_COUNTRIES_LIST_URL = "/all";
    String GET_COUNTRY_URL = "/name/{countryName}";
    String BASE_URI="https://restcountries.eu/rest/v2";

    WebClient.ResponseSpec get(String url) throws IOException;

}
