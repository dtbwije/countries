package org.test.countrybrowser.client.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.test.countrybrowser.client.RestClient;

import java.io.IOException;

@Component
public class RestClientImpl implements RestClient {

    private WebClient webClient;

    public RestClientImpl(String baseUrl) {
        if(webClient == null) {
            webClient = WebClient.builder()
                    .baseUrl(baseUrl)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .build();
        }
    }

    @Override
    public WebClient.ResponseSpec get(String url) throws IOException {
        return webClient.get()
                .uri(url)
                .retrieve();
    }
}
