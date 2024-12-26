package com.napier.mlsServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.napier.mlsServices.dto.LanguageDTO;
import com.napier.mlsServices.entity.Language;
import com.napier.mlsServices.service.LanguageService;

@RestController
@RequestMapping("/mls")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LanguageController {
	@Autowired
	private LanguageService languageService;

	 @GetMapping("/languageName")
	    public List<Object> findDistinctLanguageNames(){
	    	return languageService.findDistinctLanguageNames();
	    }
	    
    @PostMapping("/addlang")
    public Language addLang(@RequestBody LanguageDTO requestL) {
    	return languageService.save(requestL.getLanguage());
    }   
    
    @GetMapping("/lang")
    public List<Language> langInfo(){
    	return languageService.findAll();
    }
}
