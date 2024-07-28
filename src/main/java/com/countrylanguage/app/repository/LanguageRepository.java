package com.countrylanguage.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LanguageRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Value("${query.fetch.country-code}")
    private String fetchCountryCodeQuery;

    @Value("${query.fetch.language}")
    private String fetchOfficialLanguageQuery;

    public List<String> countryList(String language) {
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("language", language);
        return jdbcTemplate.queryForList(fetchCountryCodeQuery, queryParam, String.class);
    }

    public List<String> officialLanguage(String countryCode) {
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("countryCode", countryCode);
        return jdbcTemplate.queryForList(fetchOfficialLanguageQuery, queryParam, String.class);
    }
}
