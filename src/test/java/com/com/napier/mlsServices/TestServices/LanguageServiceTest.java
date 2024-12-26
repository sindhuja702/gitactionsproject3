package com.com.napier.mlsServices.TestServices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.napier.mlsServices.dao.LanguageDAO;
import com.napier.mlsServices.entity.Language;
import com.napier.mlsServices.service.LanguageService;

@ExtendWith(MockitoExtension.class)
class LanguageServiceTest {
	    @Mock
	    private LanguageDAO languageDAO;

	    @InjectMocks
	    private LanguageService languageService;

	    @Test
	    void testFindAllLanguages() {
	        List<Language> languages = Arrays.asList(new Language(), new Language(), new Language());
	        when(languageDAO.findAll()).thenReturn(languages);
	        List<Language> result = languageService.findAll();
	        assertEquals(languages, result);
	        verify(languageDAO, times(1)).findAll();
	    }

	    @Test
	    void testSaveLanguage() {
	        Language language = new Language();
	        when(languageDAO.save(language)).thenReturn(language);
	        Language result = languageService.save(language);
	        assertEquals(language, result);
	        verify(languageDAO, times(1)).save(language);
	    }

	    @Test
	    void testFindDistinctLanguageNames() {
	        List<Object> languageNames = Arrays.asList("English", "Spanish", "French");
	        when(languageDAO.findDistinctLanguageNames()).thenReturn(languageNames);
	        List<Object> result = languageService.findDistinctLanguageNames();
	        assertEquals(languageNames, result);
	        verify(languageDAO, times(1)).findDistinctLanguageNames();
	    }

}
