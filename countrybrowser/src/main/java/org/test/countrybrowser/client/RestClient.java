package org.test.countrybrowser.client;

import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;

public interface RestClient {

    String GET_COUNTRIES_LIST_URL = "https://restcountries.eu/rest/v2/all";
    String GET_COUNTRY_URL = "https://restcountries.eu/rest/v2/name/";

    CloseableHttpResponse get(String url) throws IOException;

    void close() throws IOException;
}
