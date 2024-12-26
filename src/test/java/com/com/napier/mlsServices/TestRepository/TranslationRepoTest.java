package com.com.napier.mlsServices.TestRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.napier.mlsServices.Repository.TranslationRepo;
import com.napier.mlsServices.entity.Translation;

@ExtendWith(MockitoExtension.class)
class TranslationRepoTest {

	    @Mock
	    private TranslationRepo translationRepo;

	    @Test
	    void testSearchTranslations() {
	        String query = "value";
	        List<Translation> translations = Arrays.asList(new Translation(), new Translation());
	        when(translationRepo.searchTranslations(query)).thenReturn(translations);
	        List<Translation> result = translationRepo.searchTranslations(query);
	        assertEquals(translations, result);
	        verify(translationRepo, times(1)).searchTranslations(eq(query));
	    }

	    @Test
	    void testFindDistinctLabelKeys() {
	        List<Object> labelKeys = Arrays.asList("LabelKey1", "LabelKey2", "LabelKey3");
	        when(translationRepo.findDistinctLabelKeys()).thenReturn(labelKeys);
	        List<Object> result = translationRepo.findDistinctLabelKeys();
	        assertEquals(labelKeys, result);
	        verify(translationRepo, times(1)).findDistinctLabelKeys();
	    }

	    @Test
	    void testFindDistinctTranslatedValues() {
	        List<Object> translatedValues = Arrays.asList("Value1", "Value2", "Value3");
	        when(translationRepo.findDistinctTranslatedValues()).thenReturn(translatedValues);
	        List<Object> result = translationRepo.findDistinctTranslatedValues();
	        assertEquals(translatedValues, result);
	        verify(translationRepo, times(1)).findDistinctTranslatedValues();
	    }

}
