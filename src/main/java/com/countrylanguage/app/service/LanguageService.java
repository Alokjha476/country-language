package com.countrylanguage.app.service;

import com.countrylanguage.app.repository.LanguageRepository;
import org.springframework.stereotype.Service;

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

    public List<String> getOfficialLangList(String code) {
        return languageRepository.officialLanguage(code);
    }

}
