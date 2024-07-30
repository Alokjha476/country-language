package com.countrylanguage.app.repository;

import com.countrylanguage.app.dto.CountryLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    @Value("${query.fetch.country-list.with-object}")
    private String fetchLanguageWithObjectQuery;

    @Value("${query.fetch.officialLanguageWithObject}")
    private String getFetchOfficialLanguageQuery;



    public List<String> countryList(String language) {
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("language", language);
        return jdbcTemplate.queryForList(fetchCountryCodeQuery, queryParam, String.class);
    }
    public List<CountryLanguage> countryListWithObject(String language){
        Map<String, Object> queryParam= new HashMap<>();
        queryParam.put("language", language);
        return jdbcTemplate.query(fetchLanguageWithObjectQuery, queryParam,new BeanPropertyRowMapper<>(CountryLanguage.class));


    }

    public List<String> officialLanguage(String countryCode) {
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("countryCode", countryCode);
        return jdbcTemplate.queryForList(fetchOfficialLanguageQuery, queryParam, String.class);
    }


    public List<CountryLanguage> officialLanguageWithObject(String countryCode) {
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("countryCode", countryCode);
        return jdbcTemplate.query(getFetchOfficialLanguageQuery, queryParam, new BeanPropertyRowMapper<>(CountryLanguage.class));
    }


}
