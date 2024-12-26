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

import com.napier.mlsServices.Repository.ScreenRepo;
import com.napier.mlsServices.dto.TranslationDTO;

@ExtendWith(MockitoExtension.class)
class ScreenRepoTest {
	    @Mock
	    private ScreenRepo screenRepo;

	    @Test
	    void testFindDistinctServiceNames() {
	        List<Object> serviceNames = Arrays.asList("Service1", "Service2", "Service3");
	        when(screenRepo.findDistinctServiceNames()).thenReturn(serviceNames);
	        List<Object> result = screenRepo.findDistinctServiceNames();
	        assertEquals(serviceNames, result);
	        verify(screenRepo, times(1)).findDistinctServiceNames();
	    }

	    @Test
	    void testFindDistinctModuleNamesByServiceName() {
	        String serviceName = "Service1";
	        List<Object> moduleNames = Arrays.asList("Module1", "Module2", "Module3");
	        when(screenRepo.findDistinctModuleNamesByServiceName(serviceName)).thenReturn(moduleNames);
	        List<Object> result = screenRepo.findDistinctModuleNamesByServiceName(serviceName);
	        assertEquals(moduleNames, result);
	        verify(screenRepo, times(1)).findDistinctModuleNamesByServiceName(serviceName);
	    }

	    @Test
	    void testFindDistinctFeatureNamesByModuleName() {
	        String moduleName = "Module1";
	        List<Object> featureNames = Arrays.asList("Feature1", "Feature2", "Feature3");
	        when(screenRepo.findDistinctFeatureNamesByModuleName(moduleName)).thenReturn(featureNames);
	        List<Object> result = screenRepo.findDistinctFeatureNamesByModuleName(moduleName);
	        assertEquals(featureNames, result);
	        verify(screenRepo, times(1)).findDistinctFeatureNamesByModuleName(moduleName);
	    }

	    @Test
	    void testFindDistinctScreenNamesByFeatureName() {
	        String featureName = "Feature1";
	        List<Object> screenNames = Arrays.asList("Screen1", "Screen2", "Screen3");
	        when(screenRepo.findDistinctScreenNamesByFeatureName(featureName)).thenReturn(screenNames);
	        List<Object> result = screenRepo.findDistinctScreenNamesByFeatureName(featureName);
	        assertEquals(screenNames, result);
	        verify(screenRepo, times(1)).findDistinctScreenNamesByFeatureName(featureName);
	    }

	    @Test
	    void testAdvSearchAll() {
	        String searchValue = "value";
	        String dropdown1 = "drop1";
	        String dropdown2 = "drop2";
	        String dropdown3 = "drop3";
	        String dropdown4 = "drop4";
	        String dropdown5 = "drop5";
	        List<TranslationDTO> translations = Arrays.asList(new TranslationDTO(), new TranslationDTO());
	        when(screenRepo.advSearchAll(searchValue, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5))
	                .thenReturn(translations);
	        List<TranslationDTO> result = screenRepo.advSearchAll(searchValue, dropdown1, dropdown2, dropdown3, dropdown4,
	                dropdown5);
	        assertEquals(translations, result);
	        verify(screenRepo, times(1)).advSearchAll(
	                eq(searchValue), eq(dropdown1), eq(dropdown2), eq(dropdown3), eq(dropdown4), eq(dropdown5));
	    }

	    @Test
	    void testAdvSearchAllData() {
	        String searchValue = "value";
	        String dropdown1 = "drop1";
	        String dropdown2 = "drop2";
	        String dropdown3 = "drop3";
	        String dropdown4 = "drop4";
	        String dropdown5 = "drop5";
	        List<TranslationDTO> translations = Arrays.asList(new TranslationDTO(), new TranslationDTO());
	        when(screenRepo.advSearchAllData(searchValue, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5))
	                .thenReturn(translations);
	        List<TranslationDTO> result = screenRepo.advSearchAllData(searchValue, dropdown1, dropdown2, dropdown3, dropdown4,
	                dropdown5);
	        assertEquals(translations, result);
	        verify(screenRepo, times(1)).advSearchAllData(
	                eq(searchValue), eq(dropdown1), eq(dropdown2), eq(dropdown3), eq(dropdown4), eq(dropdown5));
	    }

}
