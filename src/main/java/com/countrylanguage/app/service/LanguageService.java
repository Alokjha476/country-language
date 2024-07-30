package com.countrylanguage.app.service;

import com.countrylanguage.app.dto.CountryLanguage;
import com.countrylanguage.app.repository.LanguageRepository;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.Counter;

import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<String> getCountryList(String lang) {
        return languageRepository.countryList(lang);
    }
    public List<CountryLanguage> countryListWithObject(String lang){
        return languageRepository.countryListWithObject(lang);

    }


    public List<String> getOfficialLangList(String code) {
        return languageRepository.officialLanguage(code);
    }

    public List<CountryLanguage> getOfficialLangListWithObject(String code) {
        return languageRepository.officialLanguageWithObject(code);
    }


}
