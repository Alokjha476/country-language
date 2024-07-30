package com.countrylanguage.app.dto;

import lombok.Data;

@Data
public class CountryLanguage {
    private String countryCode;
    private String language;
    private Double percentage;
    private String isOfficial;
}
