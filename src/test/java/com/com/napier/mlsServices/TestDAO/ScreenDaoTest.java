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

import com.napier.mlsServices.Repository.ScreenRepo;
import com.napier.mlsServices.dao.ScreenDAO;
import com.napier.mlsServices.dto.TranslationDTO;
import com.napier.mlsServices.entity.Screen;

@ExtendWith(MockitoExtension.class)
class ScreenDaoTest {

	    @Mock
	    private ScreenRepo screenRepo;

	    @InjectMocks
	    private ScreenDAO screenDAO;

	    @Test
	    void testFindAllScreens() {
	        List<Screen> screens = Arrays.asList(new Screen(), new Screen(), new Screen());
	        when(screenRepo.findAll()).thenReturn(screens);
	        List<Screen> result = screenDAO.findAll();
	        assertEquals(screens, result);
	        verify(screenRepo, times(1)).findAll();
	    }

	    @Test
	    void testSaveScreen() {
	        Screen screen = new Screen();
	        when(screenRepo.save(screen)).thenReturn(screen);
	        Screen result = screenDAO.save(screen);
	        assertEquals(screen, result);
	        verify(screenRepo, times(1)).save(screen);
	    }

	    @Test
	    void testFindScreenById() {
	        int screenId = 1;
	        Optional<Screen> optionalScreen = Optional.of(new Screen());
	        when(screenRepo.findById(screenId)).thenReturn(optionalScreen);
	        Optional<Screen> result = screenDAO.findById(screenId);
	        assertEquals(optionalScreen, result);
	        verify(screenRepo, times(1)).findById(screenId);
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
	        List<TranslationDTO> result = screenDAO.advSearchAllData(searchValue, dropdown1, dropdown2, dropdown3, dropdown4,
	                dropdown5);
	        assertEquals(translations, result);
	        verify(screenRepo, times(1)).advSearchAllData(searchValue, dropdown1, dropdown2, dropdown3, dropdown4,
	                dropdown5);
	    }

	    @Test
	    void testFindDistinctServiceNames() {
	        List<Object> serviceNames = Arrays.asList("Service1", "Service2", "Service3");
	        when(screenRepo.findDistinctServiceNames()).thenReturn(serviceNames);
	        List<Object> result = screenDAO.findDistinctServiceNames();
	        assertEquals(serviceNames, result);
	        verify(screenRepo, times(1)).findDistinctServiceNames();
	    }

	    @Test
	    void testFindDistinctModuleNamesByServiceName() {
	        String serviceName = "Service1";
	        List<Object> moduleNames = Arrays.asList("Module1", "Module2", "Module3");
	        when(screenRepo.findDistinctModuleNamesByServiceName(serviceName)).thenReturn(moduleNames);
	        List<Object> result = screenDAO.findDistinctModuleNamesByServiceName(serviceName);
	        assertEquals(moduleNames, result);
	        verify(screenRepo, times(1)).findDistinctModuleNamesByServiceName(serviceName);
	    }

	    @Test
	    void testFindDistinctFeatureNamesByModuleName() {
	        String moduleName = "Module1";
	        List<Object> featureNames = Arrays.asList("Feature1", "Feature2", "Feature3");
	        when(screenRepo.findDistinctFeatureNamesByModuleName(moduleName)).thenReturn(featureNames);
	        List<Object> result = screenDAO.findDistinctFeatureNamesByModuleName(moduleName);
	        assertEquals(featureNames, result);
	        verify(screenRepo, times(1)).findDistinctFeatureNamesByModuleName(moduleName);
	    }

	    @Test
	    void testFindDistinctScreenNamesByFeatureName() {
	        String featureName = "Feature1";
	        List<Object> screenNames = Arrays.asList("Screen1", "Screen2", "Screen3");
	        when(screenRepo.findDistinctScreenNamesByFeatureName(featureName)).thenReturn(screenNames);
	        List<Object> result = screenDAO.findDistinctScreenNamesByFeatureName(featureName);
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
	        List<TranslationDTO> result = screenDAO.advSearchAll(searchValue, dropdown1, dropdown2, dropdown3, dropdown4,
	                dropdown5);
	        assertEquals(translations, result);
	        verify(screenRepo, times(1)).advSearchAll(searchValue, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5);
	    }

}
