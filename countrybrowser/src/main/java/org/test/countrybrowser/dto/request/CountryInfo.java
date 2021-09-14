package org.test.countrybrowser.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryInfo {
    private String name;
    private String alpha2Code;
    private String capital;
    private double population;
    private String flag;

}
