package com.com.napier.mlsServices.TestControllers;

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

import com.napier.mlsServices.controller.LanguageController;
import com.napier.mlsServices.dto.LanguageDTO;
import com.napier.mlsServices.entity.Language;
import com.napier.mlsServices.service.LanguageService;

@ExtendWith(MockitoExtension.class)
class LanguageControllerTest {

	    @Mock
	    private LanguageService languageService;

	    @InjectMocks
	    private LanguageController languageController;

	    @Test
	    void testFindDistinctLanguageNames() {
	        List<Object> languageNames = Arrays.asList("English", "Spanish", "French");
	        when(languageService.findDistinctLanguageNames()).thenReturn(languageNames);
	        List<Object> responseEntity = languageController.findDistinctLanguageNames();
	        assertEquals(languageNames, responseEntity);
	        verify(languageService, times(1)).findDistinctLanguageNames();
	    }

	    @Test
	    void testAddLanguage() {
	        LanguageDTO languageDTO = new LanguageDTO();
	        Language language = new Language();
	        languageDTO.setLanguage(language);
	        when(languageService.save(language)).thenReturn(language);
	        Language responseEntity = languageController.addLang(languageDTO);
	        assertEquals(language, responseEntity);
	        verify(languageService, times(1)).save(language);
	    }

	    @Test
	    void testLangInfo() {
	        List<Language> languages = Arrays.asList(new Language(), new Language(), new Language());
	        when(languageService.findAll()).thenReturn(languages);
	        List<Language> responseEntity = languageController.langInfo();
	        assertEquals(languages, responseEntity);
	        verify(languageService, times(1)).findAll();
	    }

}
