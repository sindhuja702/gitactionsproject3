package com.com.napier.mlsServices.TestServices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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

import com.napier.mlsServices.dao.ScreenDAO;
import com.napier.mlsServices.dto.TranslationDTO;
import com.napier.mlsServices.entity.Screen;
import com.napier.mlsServices.service.ScreenService;

@ExtendWith(MockitoExtension.class)
class ScreenServiceTest {
	    @Mock
	    private ScreenDAO screenDAO;

	    @InjectMocks
	    private ScreenService screenService;

	    @Test
	    void testFindAllScreens() {
	        List<Screen> screens = Arrays.asList(new Screen(), new Screen(), new Screen());
	        when(screenDAO.findAll()).thenReturn(screens);
	        List<Screen> result = screenService.findAll();
	        assertEquals(screens, result);
	        verify(screenDAO, times(1)).findAll();
	    }

	    @Test
	    void testSaveScreen() {
	        Screen screen = new Screen();
	        when(screenDAO.save(screen)).thenReturn(screen);
	        Screen result = screenService.save(screen);
	        assertEquals(screen, result);
	        verify(screenDAO, times(1)).save(screen);
	    }

	    @Test
	    void testFindScreenById() {
	        int screenId = 1;
	        Optional<Screen> optionalScreen = Optional.of(new Screen());
	        when(screenDAO.findById(screenId)).thenReturn(optionalScreen);
	        Optional<Screen> result = screenService.findById(screenId);
	        assertEquals(optionalScreen, result);
	        verify(screenDAO, times(1)).findById(screenId);
	    }

	    @Test
	    void testFindDistinctServiceNames() {
	        List<Object> serviceNames = Arrays.asList("Service1", "Service2", "Service3");
	        when(screenDAO.findDistinctServiceNames()).thenReturn(serviceNames);
	        List<Object> result = screenService.findDistinctServiceNames();
	        assertEquals(serviceNames, result);
	        verify(screenDAO, times(1)).findDistinctServiceNames();
	    }

	    @Test
	    void testFindDistinctModuleNamesByServiceName() {
	        String serviceName = "Service1";
	        List<Object> moduleNames = Arrays.asList("Module1", "Module2", "Module3");
	        when(screenDAO.findDistinctModuleNamesByServiceName(serviceName)).thenReturn(moduleNames);
	        List<Object> result = screenService.findDistinctModuleNamesByServiceName(serviceName);
	        assertEquals(moduleNames, result);
	        verify(screenDAO, times(1)).findDistinctModuleNamesByServiceName(serviceName);
	    }

	    @Test
	    void testFindDistinctFeatureNamesByModuleName() {
	        String moduleName = "Module1";
	        List<Object> featureNames = Arrays.asList("Feature1", "Feature2", "Feature3");
	        when(screenDAO.findDistinctFeatureNamesByModuleName(moduleName)).thenReturn(featureNames);
	        List<Object> result = screenService.findDistinctFeatureNamesByModuleName(moduleName);
	        assertEquals(featureNames, result);
	        verify(screenDAO, times(1)).findDistinctFeatureNamesByModuleName(moduleName);
	    }

	    @Test
	    void testFindDistinctScreenNamesByFeatureName() {
	        String featureName = "Feature1";
	        List<Object> screenNames = Arrays.asList("Screen1", "Screen2", "Screen3");
	        when(screenDAO.findDistinctScreenNamesByFeatureName(featureName)).thenReturn(screenNames);
	        List<Object> result = screenService.findDistinctScreenNamesByFeatureName(featureName);
	        assertEquals(screenNames, result);
	        verify(screenDAO, times(1)).findDistinctScreenNamesByFeatureName(featureName);
	    }

	    @Test
	    void testAdvSearchAllData() {
	        String searchValue = "search";
	        List<TranslationDTO> translationDTOs = Arrays.asList(new TranslationDTO(), new TranslationDTO());
	        when(screenDAO.advSearchAllData(eq(searchValue), any(), any(), any(), any(), any())).thenReturn(translationDTOs);
	        List<TranslationDTO> result = screenService.advSearchAllData(searchValue, null, null, null, null, null);
	        assertEquals(translationDTOs, result);
	        verify(screenDAO, times(1)).advSearchAllData(eq(searchValue), any(), any(), any(), any(), any());
	    }

	    @Test
	    void testAdvSearchAll() {
	        String searchValue = "search";
	        List<TranslationDTO> translationDTOs = Arrays.asList(new TranslationDTO(), new TranslationDTO());
	        when(screenDAO.advSearchAll(eq(searchValue), any(), any(), any(), any(), any())).thenReturn(translationDTOs);
	        List<TranslationDTO> result = screenService.advSearchAll(searchValue, null, null, null, null, null);
	        assertEquals(translationDTOs, result);
	        verify(screenDAO, times(1)).advSearchAll(eq(searchValue), any(), any(), any(), any(), any());
	    }
}
