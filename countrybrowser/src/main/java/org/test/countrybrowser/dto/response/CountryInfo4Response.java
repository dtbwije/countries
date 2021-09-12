package org.test.countrybrowser.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryInfo4Response {

    private String name;
    private String code;
    private String capital;
    private double population;
    private String flagFileUrl;

}
