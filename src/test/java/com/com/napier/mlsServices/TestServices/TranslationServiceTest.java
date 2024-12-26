package com.com.napier.mlsServices.TestServices;

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

import com.napier.mlsServices.dao.TranslationDAO;
import com.napier.mlsServices.entity.Translation;
import com.napier.mlsServices.service.TranslationService;

@ExtendWith(MockitoExtension.class)
class TranslationServiceTest {
	    @Mock
	    private TranslationDAO translationDAO;

	    @InjectMocks
	    private TranslationService translationService;

	    @Test
	    void testSearchTranslations() {
	        String query = "search";
	        List<Translation> translations = Arrays.asList(new Translation(), new Translation());
	        when(translationDAO.searchTranslations(query)).thenReturn(translations);
	        List<Translation> result = translationService.searchTranslations(query);
	        assertEquals(translations, result);
	        verify(translationDAO, times(1)).searchTranslations(query);
	    }

	    @Test
	    void testFindAllTranslations() {
	        List<Translation> translations = Arrays.asList(new Translation(), new Translation(), new Translation());
	        when(translationDAO.findAll()).thenReturn(translations);
	        List<Translation> result = translationService.findAll();
	        assertEquals(translations, result);
	        verify(translationDAO, times(1)).findAll();
	    }

	    @Test
	    void testSaveTranslation() {
	        Translation translation = new Translation();
	        when(translationDAO.save(translation)).thenReturn(translation);
	        Translation result = translationService.save(translation);
	        assertEquals(translation, result);
	        verify(translationDAO, times(1)).save(translation);
	    }

	    @Test
	    void testUpdateTranslation() {
	        Translation translation = new Translation();
	        when(translationDAO.updateTrans(translation)).thenReturn(translation);
	        Translation result = translationService.updateTrans(translation);
	        assertEquals(translation, result);
	        verify(translationDAO, times(1)).updateTrans(translation);
	    }

	    @Test
	    void testFindTranslationById() {
	        int translationId = 1;
	        Optional<Translation> optionalTranslation = Optional.of(new Translation());
	        when(translationDAO.findById(translationId)).thenReturn(optionalTranslation);
	        Optional<Translation> result = translationService.findById(translationId);
	        assertEquals(optionalTranslation, result);
	        verify(translationDAO, times(1)).findById(translationId);
	    }

	    @Test
	    void testFindDistinctLabelKeys() {
	        List<Object> labelKeys = Arrays.asList("LabelKey1", "LabelKey2", "LabelKey3");
	        when(translationDAO.findDistinctLabelKeys()).thenReturn(labelKeys);
	        List<Object> result = translationService.findDistinctLabelKeys();
	        assertEquals(labelKeys, result);
	        verify(translationDAO, times(1)).findDistinctLabelKeys();
	    }

	    @Test
	    void testFindDistinctTranslatedValues() {
	        List<Object> translatedValues = Arrays.asList("Value1", "Value2", "Value3");
	        when(translationDAO.findDistinctTranslatedValues()).thenReturn(translatedValues);
	        List<Object> result = translationService.findDistinctTranslatedValues();
	        assertEquals(translatedValues, result);
	        verify(translationDAO, times(1)).findDistinctTranslatedValues();
	    }

}
