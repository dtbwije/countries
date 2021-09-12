package org.test.countrybrowser.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryInList {

    private String name;
    private String alpha2Code;

    @JsonProperty("CountryName")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String countryName) {
        this.name = name;
    }

    @JsonProperty("CountryCode")
    public String getAlpha2Code() {
        return alpha2Code;
    }

    @JsonProperty("alpha2Code")
    public void setAlpha2Code(String countryCode) {
        this.alpha2Code = alpha2Code;
    }

    @Override
    public String toString() {
        return "Country{"  +
                ", countryName='" + name + '\'' +
                ", cpuntryCode='" + alpha2Code + '\'' +
                '}';
    }


}