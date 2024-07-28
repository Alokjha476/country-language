package com.countrylanguage.app.controller;

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

    @GetMapping("/getbylanguage")
    public ResponseEntity<Object> countryList(@RequestParam String language) {
        List<String> lang = languageService.getCountryList(language);
        return new ResponseEntity<>(lang, HttpStatus.OK);
    }

    @GetMapping("/getofficiallanguagebycountrycode")
    public ResponseEntity<Object> languageList(@RequestParam("countrycode") String countryCode) {
        List<String> lang = languageService.getOfficialLangList(countryCode);
        return new ResponseEntity<>(lang, HttpStatus.OK);
    }



}
