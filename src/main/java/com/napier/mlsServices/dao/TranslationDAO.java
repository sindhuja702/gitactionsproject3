package com.napier.mlsServices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.napier.mlsServices.Repository.TranslationRepo;
import com.napier.mlsServices.entity.Translation;

@Component
public class TranslationDAO {
    @Autowired
    private TranslationRepo translationRepo;
      
    public List<Translation> searchTranslations(String searchTerm) {
        return translationRepo.searchTranslations(searchTerm);
    }

    public List<Translation> transInfo(){
	    return translationRepo.findAll();
	}

	public List<Translation> findAll() {
		return translationRepo.findAll();
	}

	public Translation save(Translation requestT) {
		return translationRepo.save(requestT);
	}

	public Translation updateTrans(Translation requestT) {		
		return translationRepo.save(requestT);
	}

	public Optional<Translation> findById(int translationId) {		
		return translationRepo.findById(translationId);
	}

	public List<Object> findDistinctLabelKeys() {
		return translationRepo.findDistinctLabelKeys();
	}

	public List<Object> findDistinctTranslatedValues() {
		return translationRepo.findDistinctTranslatedValues();
	}

    
}
