package org.test.countrybrowser.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Data
@Component
@ConfigurationProperties(prefix = "country")
public class CountryAppConfiguration {

    @NotBlank
    private String url;
}
