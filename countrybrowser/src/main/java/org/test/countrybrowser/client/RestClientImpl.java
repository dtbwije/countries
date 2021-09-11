package org.test.countrybrowser.client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class RestClientImpl implements RestClient{

    private CloseableHttpClient closableRestClient;

    public RestClientImpl(){
        closableRestClient =  HttpClientBuilder.create().build();
    }


    @Override
    public CloseableHttpResponse get(String url) throws IOException {
        return closableRestClient.execute(new HttpGet(url));
    }

    @Override
    public void close() throws IOException {
        closableRestClient.close();
    }
}
