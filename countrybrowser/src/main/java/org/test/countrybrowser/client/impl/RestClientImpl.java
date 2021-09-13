package org.test.countrybrowser.client.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.test.countrybrowser.client.RestClient;

import java.io.IOException;


@Slf4j
public class RestClientImpl implements RestClient {

    private WebClient webClient;

    public RestClientImpl(String baseUrl) {
        log.info("The client base URL is "+ baseUrl);
        if(webClient == null) {
            webClient = WebClient.builder()
                    .baseUrl(baseUrl)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .build();
        }
    }

    @Override
    public WebClient.ResponseSpec get(String url) throws IOException {
        log.info("The client URL is "+ url);
        return webClient.get()
                .uri(url.trim())
                .retrieve();
    }
}
