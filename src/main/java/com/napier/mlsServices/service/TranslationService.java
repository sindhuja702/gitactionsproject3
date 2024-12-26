package com.napier.mlsServices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.napier.mlsServices.dao.TranslationDAO;
import com.napier.mlsServices.entity.Translation;

@Service
public class TranslationService {
	
	@Autowired
	private TranslationDAO translationDAO;
	
    public List<Translation> searchTranslations(String query){
    	return translationDAO.searchTranslations(query);
    }
    
	public List<Translation> findAll() {
		return translationDAO.findAll();
	}

	public Translation save(Translation requestT) {		
		return translationDAO.save(requestT);
	}

	@Transactional
	public Translation updateTrans(Translation requestT) {		
		return translationDAO.updateTrans(requestT);
	}

	public Optional<Translation> findById(int translationId) {		
		return translationDAO.findById(translationId);
	}

	public List<Object> findDistinctLabelKeys() {
		return translationDAO.findDistinctLabelKeys();
	}

	public List<Object> findDistinctTranslatedValues() {
		return translationDAO.findDistinctTranslatedValues();
	}	
	public Translation updateTranslation(Translation updatedTranslation) {
        Translation existingTranslation = translationDAO.findById(updatedTranslation.getTranslationId())
                .orElseThrow(() -> new RuntimeException("Translation not found"));
        existingTranslation.setLabelKey(updatedTranslation.getLabelKey());
        existingTranslation.setTranslatedValue(updatedTranslation.getTranslatedValue());
        existingTranslation.setStatus(updatedTranslation.getStatus());
        existingTranslation.setLanguage(updatedTranslation.getLanguage());
        existingTranslation.setScreen(updatedTranslation.getScreen());
        return translationDAO.save(existingTranslation);
    }
}
