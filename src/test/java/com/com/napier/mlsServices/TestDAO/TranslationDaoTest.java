package com.com.napier.mlsServices.TestDAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
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

import com.napier.mlsServices.Repository.TranslationRepo;
import com.napier.mlsServices.dao.TranslationDAO;
import com.napier.mlsServices.entity.Translation;

@ExtendWith(MockitoExtension.class)
class TranslationDaoTest {
	@Mock
    private TranslationRepo translationRepo;

    @InjectMocks
    private TranslationDAO translationDAO;

    @Test
    void testSearchTranslations() {
        String searchTerm = "value";
        List<Translation> translations = Arrays.asList(new Translation(), new Translation());
        when(translationRepo.searchTranslations(searchTerm)).thenReturn(translations);
        List<Translation> result = translationDAO.searchTranslations(searchTerm);
        assertEquals(translations, result);
        verify(translationRepo, times(1)).searchTranslations(eq(searchTerm));
    }

    @Test
    void testTransInfo() {
        List<Translation> translations = Arrays.asList(new Translation(), new Translation());
        when(translationRepo.findAll()).thenReturn(translations);
        List<Translation> result = translationDAO.transInfo();
        assertEquals(translations, result);
        verify(translationRepo, times(1)).findAll();
    }

    @Test
    void testFindAll() {
        List<Translation> translations = Arrays.asList(new Translation(), new Translation());
        when(translationRepo.findAll()).thenReturn(translations);
        List<Translation> result = translationDAO.findAll();
        assertEquals(translations, result);
        verify(translationRepo, times(1)).findAll();
    }

    @Test
    void testSave() {
        Translation translation = new Translation();
        when(translationRepo.save(translation)).thenReturn(translation);
        Translation result = translationDAO.save(translation);
        assertEquals(translation, result);
        verify(translationRepo, times(1)).save(translation);
    }

    @Test
    void testUpdateTrans() {
        Translation translation = new Translation();
        when(translationRepo.save(translation)).thenReturn(translation);
        Translation result = translationDAO.updateTrans(translation);
        assertEquals(translation, result);
        verify(translationRepo, times(1)).save(translation);
    }

    @Test
    void testFindById() {
        int translationId = 1;
        Optional<Translation> translationOptional = Optional.of(new Translation());
        when(translationRepo.findById(translationId)).thenReturn(translationOptional);
        Optional<Translation> result = translationDAO.findById(translationId);
        assertEquals(translationOptional, result);
        verify(translationRepo, times(1)).findById(translationId);
    }

    @Test
    void testFindDistinctLabelKeys() {
        List<Object> labelKeys = Arrays.asList("LabelKey1", "LabelKey2", "LabelKey3");
        when(translationRepo.findDistinctLabelKeys()).thenReturn(labelKeys);
        List<Object> result = translationDAO.findDistinctLabelKeys();
        assertEquals(labelKeys, result);
        verify(translationRepo, times(1)).findDistinctLabelKeys();
    }

    @Test
    void testFindDistinctTranslatedValues() {
        List<Object> translatedValues = Arrays.asList("Value1", "Value2", "Value3");
        when(translationRepo.findDistinctTranslatedValues()).thenReturn(translatedValues);
        List<Object> result = translationDAO.findDistinctTranslatedValues();
        assertEquals(translatedValues, result);
        verify(translationRepo, times(1)).findDistinctTranslatedValues();
    }

}
