package org.test.countrybrowser.entity;

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


    public String getCountryName() {
        return name;
    }

    public void setCountryName(String countryName) {
        this.name = name;
    }

    public String getCountryCode() {
        return alpha2Code;
    }

    public void setCountryCode(String countryCode) {
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


//TODO cleanup
/**
 * {
 *         "name": "Sri Lanka",
 *         "topLevelDomain": [
 *             ".lk"
 *         ],
 *         "alpha2Code": "LK",
 *         "alpha3Code": "LKA",
 *         "callingCodes": [
 *             "94"
 *         ],
 *         "capital": "Colombo",
 *         "altSpellings": [
 *             "LK",
 *             "ilaṅkai",
 *             "Democratic Socialist Republic of Sri Lanka"
 *         ],
 *         "region": "Asia",
 *         "subregion": "Southern Asia",
 *         "population": 20966000,
 *         "latlng": [
 *             7,
 *             81
 *         ],
 *         "demonym": "Sri Lankan",
 *         "area": 65610,
 *         "gini": 40.3,
 *         "timezones": [
 *             "UTC+05:30"
 *         ],
 *         "borders": [
 *             "IND"
 *         ],
 *         "nativeName": "śrī laṃkāva",
 *         "numericCode": "144",
 *         "currencies": [
 *             {
 *                 "code": "LKR",
 *                 "name": "Sri Lankan rupee",
 *                 "symbol": "Rs"
 *             }
 *         ],
 *         "languages": [
 *             {
 *                 "iso639_1": "si",
 *                 "iso639_2": "sin",
 *                 "name": "Sinhalese",
 *                 "nativeName": "සිංහල"
 *             },
 *             {
 *                 "iso639_1": "ta",
 *                 "iso639_2": "tam",
 *                 "name": "Tamil",
 *                 "nativeName": "தமிழ்"
 *             }
 *         ],
 *         "translations": {
 *             "de": "Sri Lanka",
 *             "es": "Sri Lanka",
 *             "fr": "Sri Lanka",
 *             "ja": "スリランカ",
 *             "it": "Sri Lanka",
 *             "br": "Sri Lanka",
 *             "pt": "Sri Lanka",
 *             "nl": "Sri Lanka",
 *             "hr": "Šri Lanka",
 *             "fa": "سری\u200cلانکا"
 *         },
 *         "flag": "https://restcountries.eu/data/lka.svg",
 *         "regionalBlocs": [
 *             {
 *                 "acronym": "SAARC",
 *                 "name": "South Asian Association for Regional Cooperation",
 *                 "otherAcronyms": [],
 *                 "otherNames": []
 *             }
 *         ],
 *         "cioc": "SRI"
 *     }
 */
