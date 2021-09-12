package org.test.countrybrowser.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

public class RestClientImpl implements RestClient{

    private WebClient webClient;

    public RestClientImpl(){
        webClient =  WebClient.builder()
                .baseUrl(BASE_URI)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public WebClient.ResponseSpec get(String url) throws IOException {
        return webClient.get()
                .uri(url)
                .retrieve();
    }

}
