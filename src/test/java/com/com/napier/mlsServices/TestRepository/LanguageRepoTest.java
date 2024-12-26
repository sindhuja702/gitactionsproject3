package com.com.napier.mlsServices.TestRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.napier.mlsServices.Repository.LanguageRepo;

@ExtendWith(MockitoExtension.class)
class LanguageRepoTest {
	    @Mock
	    private LanguageRepo languageRepo;

	    @Test
	    void testFindDistinctLanguageNames() {
	        List<Object> languageNames = Arrays.asList("Language1", "Language2", "Language3");
	        when(languageRepo.findDistinctLanguageNames()).thenReturn(languageNames);
	        List<Object> result = languageRepo.findDistinctLanguageNames();
	        assertEquals(languageNames, result);
	        verify(languageRepo, times(1)).findDistinctLanguageNames();
	    }

}
