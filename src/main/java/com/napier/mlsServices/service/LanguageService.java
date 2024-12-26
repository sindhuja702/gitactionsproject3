package com.napier.mlsServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.napier.mlsServices.dao.LanguageDAO;
import com.napier.mlsServices.entity.Language;

@Service
public class LanguageService {

	@Autowired
	private LanguageDAO languageDAO;

	public List<Language> findAll() {
		return languageDAO.findAll();
	}

	public Language save(Language language) {		
		return languageDAO.save(language);
	}

	public List<Object> findDistinctLanguageNames() {
		return languageDAO.findDistinctLanguageNames();
	}



}
