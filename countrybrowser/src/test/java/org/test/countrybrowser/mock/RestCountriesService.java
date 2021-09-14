package org.test.countrybrowser.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.apache.http.HttpHeaders;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class RestCountriesService {

    private WireMockServer wireMockServer;

    public RestCountriesService(){
        wireMockServer = new WireMockServer(9002);
        wireMockServer.start();
    }

    public void startForSuccess(){
        wireMockServer.stubFor(get(urlEqualTo("/all")).willReturn(aResponse().withHeader(HttpHeaders.CONTENT_TYPE,"application/json").withBody(LIST_RESPONSE)));
        wireMockServer.stubFor(get(urlMatching("/name/.*")).willReturn(aResponse().withHeader(HttpHeaders.CONTENT_TYPE,"application/json").withBody(LIST_RESPONSE)));
    }

    public void stop() {
        wireMockServer.stop();
    }

    public final static String LIST_RESPONSE = "[ {     \"name\": \"Afghanistan\",     \"topLevelDomain\":" +
            " [         \".af\"     ],     \"alpha2Code\": \"AF\",     \"alpha3Code\": \"AFG\",     " +
            "\"callingCodes\": [         \"93\"     ],     \"capital\": \"Kabul\",     \"altSpellings\": [\n " +
            "           \"AF\",         \"Afġānistān\"     ],     \"region\": \"Asia\",     " +
            "\"subregion\": \"Southern Asia\",     \"population\": 27657145,     \"latlng\": [         33," +
            "         65     ],     \"demonym\": \"Afghan\",     \"area\": 652230,     \"gini\": 27.8," +
            "     \"timezones\": [         \"UTC+04:30\"     ],     \"borders\": [         \"IRN\"," +
            "         \"PAK\",         \"TKM\",         \"UZB\",         \"TJK\",         \"CHN\"\n" +
            "        ],     \"nativeName\": \"افغانستان\",     \"numericCode\": \"004\",     \"currencies\": " +
            "[         {             \"code\": \"AFN\",             \"name\": \"Afghan afghani\",\n  " +
            "              \"symbol\": \"؋\"         }     ],     \"languages\": [         {     " +
            "        \"iso639_1\": \"ps\",             \"iso639_2\": \"pus\",             \"name\": \"Pashto\",\n  " +
            "              \"nativeName\": \"پښتو\"         },         {             \"iso639_1\": \"uz\",\n " +
            "               \"iso639_2\": \"uzb\",             \"name\": \"Uzbek\",            " +
            " \"nativeName\": \"Oʻzbek\"         },         {             \"iso639_1\": \"tk\",\n " +
            "               \"iso639_2\": \"tuk\",             \"name\": \"Turkmen\",             " +
            "\"nativeName\": \"Türkmen\"         }     ],     \"translations\": {         " +
            "\"de\": \"Afghanistan\",         \"es\": \"Afganistán\",         \"fr\": \"Afghanistan\",\n  " +
            "          \"ja\": \"アフガニスタン\",         \"it\": \"Afghanistan\",         " +
            "\"br\": \"Afeganistão\",         \"pt\": \"Afeganistão\",         \"nl\": \"Afghanistan\",\n " +
            "           \"hr\": \"Afganistan\",         \"fa\": \"افغانستان\"     },    " +
            " \"flag\": \"https://restcountries.eu/data/afg.svg\",     \"regionalBlocs\": [\n " +
            "           {             \"acronym\": \"SAARC\",            " +
            " \"name\": \"South Asian Association for Regional Cooperation\",             \"otherAcronyms\": [],\n" +
            "                \"otherNames\": []         }     ],     \"cioc\": \"AFG\" }, {\n" +
            "        \"name\": \"Åland Islands\",     \"topLevelDomain\": [         \".ax\"     ],\n" +
            "        \"alpha2Code\": \"AX\",     \"alpha3Code\": \"ALA\",     \"callingCodes\": [\n" +
            "            \"358\"     ],     \"capital\": \"Mariehamn\",     \"altSpellings\": [\n" +
            "            \"AX\",         \"Aaland\",         \"Aland\",         \"Ahvenanmaa\"\n" +
            "        ],     \"region\": \"Europe\",     \"subregion\": \"Northern Europe\",\n" +
            "        \"population\": 28875,     \"latlng\": [         60.116667,         19.9\n" +
            "        ],     \"demonym\": \"Ålandish\",     \"area\": 1580,     \"gini\": null,\n " +
            "       \"timezones\": [         \"UTC+02:00\"     ],     \"borders\": [],\n " +
            "       \"nativeName\": \"Åland\",     \"numericCode\": \"248\",     \"currencies\": [\n" +
            "            {             \"code\": \"EUR\",             \"name\": \"Euro\",\n " +
            "               \"symbol\": \"€\"         }     ],     \"languages\": [\n " +
            "           {             \"iso639_1\": \"sv\",             \"iso639_2\": \"swe\",\n " +
            "               \"name\": \"Swedish\",             \"nativeName\": \"svenska\"\n " +
            "           }     ],     \"translations\": {         \"de\": \"Åland\",         \"es\": \"Alandia\"," +
            "         \"fr\": \"Åland\",         \"ja\": \"オーランド諸島\",         \"it\": \"Isole Aland\",         " +
            "\"br\": \"Ilhas de Aland\",         \"pt\": \"Ilhas de Aland\",         \"nl\": \"Ålandeilanden\",         " +
            "\"hr\": \"Ålandski otoci\",         \"fa\": \"جزایر الند\"     },     " +
            "\"flag\": \"https://restcountries.eu/data/ala.svg\",     \"regionalBlocs\": [\n " +
            "           {             \"acronym\": \"EU\",             \"name\": \"European Union\",\n  " +
            "              \"otherAcronyms\": [],             \"otherNames\": []         }     ],\n" +
            "        \"cioc\": \"\" }, {     \"name\": \"Albania\",     \"topLevelDomain\": [\n " +
            "           \".al\"     ],     \"alpha2Code\": \"AL\",     \"alpha3Code\": \"ALB\",\n " +
            "       \"callingCodes\": [         \"355\"     ],     \"capital\": \"Tirana\",\n " +
            "       \"altSpellings\": [         \"AL\",         \"Shqipëri\",         \"Shqipëria\",\n " +
            "           \"Shqipnia\"     ],     \"region\": \"Europe\",     \"subregion\": \"Southern Europe\",\n " +
            "       \"population\": 2886026,     \"latlng\": [         41,         20     ],     \"demonym\": \"Albanian\", " +
            "    \"area\": 28748,     \"gini\": 34.5,     \"timezones\": [         \"UTC+01:00\"     ],     \"borders\": [ " +
            "        \"MNE\",         \"GRC\",         \"MKD\",         \"KOS\"     ],     \"nativeName\": \"Shqipëria\",  " +
            "   \"numericCode\": \"008\",     \"currencies\": [         {             \"code\": \"ALL\", " +
            "            \"name\": \"Albanian lek\",             \"symbol\": \"L\"         }     ],     \"languages\": [ " +
            "        {             \"iso639_1\": \"sq\",             \"iso639_2\": \"sqi\",             \"name\": \"Albanian\", " +
            "            \"nativeName\": \"Shqip\"         }     ],     \"translations\": {         \"de\": \"Albanien\", " +
            "        \"es\": \"Albania\",         \"fr\": \"Albanie\",         \"ja\": \"アルバニア\",         \"it\": \"Albania\"," +
            "         \"br\": \"Albânia\",         \"pt\": \"Albânia\",         \"nl\": \"Albanië\",         \"hr\": \"Albanija\", " +
            "        \"fa\": \"آلبانی\"     },     \"flag\": \"https://restcountries.eu/data/alb.svg\",     \"regionalBlocs\": [ " +
            "        {             \"acronym\": \"CEFTA\",             \"name\": \"Central European Free Trade Agreement\",  " +
            "           " +
            "\"otherAcronyms\": [],             \"otherNames\": []         }     ],     \"cioc\": \"ALB\" " +
            "}\n]";
    
    private static final String SINGLE_UNIT_RESPONSE = "[ {     \"name\": \"Sri Lanka\",     \"topLevelDomain\": [\n  " +
            "          \".lk\"     ],     \"alpha2Code\": \"LK\",     \"alpha3Code\": \"LKA\",     " +
            "\"callingCodes\": [         \"94\"     ],     \"capital\": \"Colombo\",     " +
            "\"altSpellings\": [         \"LK\",         \"ilaṅkai\",         " +
            "\"Democratic Socialist Republic of Sri Lanka\"     ],     \"region\": \"Asia\",     " +
            "\"subregion\": \"Southern Asia\",     \"population\": 20966000,     \"latlng\": [         7, " +
            "        81     ],     \"demonym\": \"Sri Lankan\",     \"area\": 65610,     \"gini\": 40.3," +
            "     \"timezones\": [         \"UTC+05:30\"     ],     \"borders\": [         \"IND\"    " +
            " ],     \"nativeName\": \"śrī laṃkāva\",     \"numericCode\": \"144\",     \"currencies\": [ " +
            "        {             \"code\": \"LKR\",             \"name\": \"Sri Lankan rupee\",   " +
            "          \"symbol\": \"Rs\"         }     ],     \"languages\": [         {    " +
            "         \"iso639_1\": \"si\",             \"iso639_2\": \"sin\",             \"name\": \"Sinhalese\",\n  " +
            "              \"nativeName\": \"සිංහල\"         },         {             \"iso639_1\": \"ta\",   " +
            "          \"iso639_2\": \"tam\",             \"name\": \"Tamil\",             \"nativeName\": \"தமிழ்\"   " +
            "      }     ],     \"translations\": {         \"de\": \"Sri Lanka\",         " +
            "\"es\": \"Sri Lanka\",         \"fr\": \"Sri Lanka\",         \"ja\": \"スリランカ\",  " +
            "       \"it\": \"Sri Lanka\",         \"br\": \"Sri Lanka\",         \"pt\": \"Sri Lanka\",   " +
            "      \"nl\": \"Sri Lanka\",         \"hr\": \"Šri Lanka\",         \"fa\": \"سری\\u200cلانکا\"  " +
            "   },     \"flag\": \"https://restcountries.eu/data/lka.svg\",     \"regionalBlocs\": [  " +
            "       {             \"acronym\": \"SAARC\",             " +
            "\"name\": \"South Asian Association for Regional Cooperation\",         " +
            "    \"otherAcronyms\": [],             \"otherNames\": []         }  " +
            "   ],     \"cioc\": \"SRI\" }\n]\n";
}