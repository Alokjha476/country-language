package com.countrylanguage.app.controller;


import com.countrylanguage.app.dto.CountryLanguage;
import com.countrylanguage.app.service.LanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    // http://localhost:8080/api/getbylanguage?language=English
    @GetMapping("/getbylanguage")
    public ResponseEntity<Object> countryList(@RequestParam String language) {
        List<String> lang = languageService.getCountryList(language);
        if (lang.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lang, HttpStatus.OK);
    }

    @GetMapping("/getLanguage")
    public ResponseEntity<Object> countryListWithObject(@RequestParam String language) {
        List<CountryLanguage> list = languageService.countryListWithObject(language);
        try {
            if (language.isEmpty()) {
                return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            System.out.println("Language is not available");

        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // http://localhost:8080/api/getofficiallanguagebycountrycode?countrycode=rus
    @GetMapping("/getofficiallanguagebycountrycode")
    public ResponseEntity<Object> languageList(@RequestParam("countrycode") String countryCode) {
        List<String> lang = languageService.getOfficialLangList(countryCode);
        return new ResponseEntity<>(lang, HttpStatus.OK);
    }


    // http://localhost:8080/api/getentity?countrycode=rus
    @GetMapping("/getentity")
    public ResponseEntity<Object> languageList1(@RequestParam("countrycode") String countryCode) {
        List<CountryLanguage> lang = languageService.getOfficialLangListWithObject(countryCode);
        return new ResponseEntity<>(lang, HttpStatus.OK);
    }


}
