package com.com.napier.mlsServices.TestDAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.napier.mlsServices.Repository.LanguageRepo;
import com.napier.mlsServices.dao.LanguageDAO;
import com.napier.mlsServices.entity.Language;

@ExtendWith(MockitoExtension.class)
class LanguageDaoTest {
	    @Mock
	    private LanguageRepo languageRepo;

	    @InjectMocks
	    private LanguageDAO languageDAO;

	    @Test
	    void testFindAll() {
	        List<Language> languages = Arrays.asList(new Language(), new Language());
	        when(languageRepo.findAll()).thenReturn(languages);
	        List<Language> result = languageDAO.findAll();
	        assertEquals(languages, result);
	        verify(languageRepo, times(1)).findAll();
	    }

	    @Test
	    void testSave() {
	        Language language = new Language();
	        when(languageRepo.save(language)).thenReturn(language);
	        Language result = languageDAO.save(language);
	        assertEquals(language, result);
	        verify(languageRepo, times(1)).save(language);
	    }

	    @Test
	    void testFindById() {
	        int languageId = 1;
	        Optional<Language> languageOptional = Optional.of(new Language());
	        when(languageRepo.findById(languageId)).thenReturn(languageOptional);
	        Optional<Language> result = languageDAO.findById(languageId);
	        assertEquals(languageOptional, result);
	        verify(languageRepo, times(1)).findById(languageId);
	    }

	    @Test
	    void testFindDistinctLanguageNames() {
	        List<Object> languageNames = Arrays.asList("Language1", "Language2", "Language3");
	        when(languageRepo.findDistinctLanguageNames()).thenReturn(languageNames);
	        List<Object> result = languageDAO.findDistinctLanguageNames();
	        assertEquals(languageNames, result);
	        verify(languageRepo, times(1)).findDistinctLanguageNames();
	    }

}
