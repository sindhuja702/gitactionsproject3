package com.com.napier.mlsServices.TestControllers;

import static org.junit.jupiter.api.Assertions.*;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.napier.mlsServices.controller.TranslationController;
import com.napier.mlsServices.entity.Translation;
import com.napier.mlsServices.service.TranslationService;

@ExtendWith(MockitoExtension.class)
class TranslationControllerTest {
	    @Mock
	    private TranslationService translationService;
	    @InjectMocks
	    private TranslationController translationController;

	    @Test
	    void testFindDistinctLabelKeys() {
	        List<Object> labelKeys = Arrays.asList("LabelKey1", "LabelKey2", "LabelKey3");
	        when(translationService.findDistinctLabelKeys()).thenReturn(labelKeys);
	        List<Object> result = translationController.findDistinctLabelKeys();
	        assertEquals(labelKeys, result);
	        verify(translationService, times(1)).findDistinctLabelKeys();
	    }

	    @Test
	    void testFindDistinctTranslatedValues() {
	        List<Object> translatedValues = Arrays.asList("Value1", "Value2", "Value3");
	        when(translationService.findDistinctTranslatedValues()).thenReturn(translatedValues);
	        List<Object> result = translationController.findDistinctTranslatedValues();
	        assertEquals(translatedValues, result);
	        verify(translationService, times(1)).findDistinctTranslatedValues();
	    }

	    @Test
	    void testFindAllTranslations() {
	        List<Translation> translations = Arrays.asList(new Translation(), new Translation(), new Translation());
	        when(translationService.findAll()).thenReturn(translations);
	        List<Translation> result = translationController.findAll();
	        assertEquals(translations, result);
	        verify(translationService, times(1)).findAll();
	    }

	    @Test
	    void testSearchTranslations() {
	        String query = "searchQuery";
	        List<Translation> searchResults = Arrays.asList(new Translation(), new Translation());
	        when(translationService.searchTranslations(query)).thenReturn(searchResults);
	        ResponseEntity<List<Translation>> responseEntity = translationController.searchTranslations(query);
	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(searchResults, responseEntity.getBody());
	        verify(translationService, times(1)).searchTranslations(query);
	    }

}
