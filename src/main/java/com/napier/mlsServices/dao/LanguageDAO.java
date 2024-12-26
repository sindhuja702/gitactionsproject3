package com.napier.mlsServices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.napier.mlsServices.Repository.LanguageRepo;
import com.napier.mlsServices.entity.Language;

@Component
public class LanguageDAO {
    @Autowired
    private LanguageRepo languageRepo;

	public List<Language> findAll() {		
		return languageRepo.findAll();
	}

	public Language save(Language language) {		
		return languageRepo.save(language);
	}

	public Optional<Language> findById(int languageId) {
		return languageRepo.findById(languageId);
	}

	public List<Object> findDistinctLanguageNames() {
		return languageRepo.findDistinctLanguageNames();
	}
    
    
}
