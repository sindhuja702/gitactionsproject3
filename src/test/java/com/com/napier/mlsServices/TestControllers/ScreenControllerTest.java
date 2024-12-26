package com.com.napier.mlsServices.TestControllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.napier.mlsServices.controller.ScreenController;
import com.napier.mlsServices.dto.ScreenDTO;
import com.napier.mlsServices.dto.TranslationDTO;
import com.napier.mlsServices.entity.Screen;
import com.napier.mlsServices.entity.Translation;
import com.napier.mlsServices.service.ScreenService;

@ExtendWith(MockitoExtension.class)
class ScreenControllerTest {
	    @Mock
	    private ScreenService screenService;

	    @InjectMocks
	    private ScreenController screenController;
	    
	    @Test
	    void testAddScreen() {	   
	        ScreenDTO screenDTO = new ScreenDTO();
	        Screen screen = new Screen();
	        screenDTO.setScreen(screen);
	        when(screenService.save(screen)).thenReturn(screen);	      
	        Screen responseEntity = screenController.addScr(screenDTO);
	        assertEquals(screen, responseEntity);
	        verify(screenService, times(1)).save(screen);
	    }

	    @Test
	    void testUpdateScreen() {	      
	        ScreenDTO screenDTO = new ScreenDTO();
	        Screen screen = new Screen();
	        screen.setScreenId((int) 1L);
	        screenDTO.setScreen(screen);

	        Translation translation = new Translation();
	        translation.setTranslationId((int) 1L);
	        translation.setLabelKey("Label1");
	        translation.setTranslatedValue("Value1");
	        translation.setStatus(1);
	        screen.setTranslation(Collections.singletonList(translation));	      
	        when(screenService.findById((int) 1L)).thenReturn(Optional.of(screen));
	        when(screenService.save(screen)).thenReturn(screen);
	        Screen responseEntity = screenController.updatescr(screenDTO);
	        assertEquals(screen, responseEntity);
	        verify(screenService, times(1)).findById((int) 1L);
	        verify(screenService, times(1)).save(screen);
	    }

	    @Test
	    @Disabled
	    void testUpdateScreenWithNonExistingScreen() {
	        ScreenDTO screenDTO = new ScreenDTO();
	        Screen screen = new Screen();
	        screen.setScreenId(0);
	        screenDTO.setScreen(screen);
	        when(screenService.findById(0)).thenReturn(Optional.empty());
	        Screen responseEntity = screenController.updatescr(screenDTO);
	        assertEquals(HttpStatus.NOT_FOUND, responseEntity);
	        verify(screenService, times(1)).findById((int) 1L);
	        verify(screenService, times(0)).save(screen);
	    }

	    @Test
	    void testFindDistinctServiceNames() {	       
	        List<Object> serviceNames = Arrays.asList("Service1", "Service2", "Service3");	       
	        when(screenService.findDistinctServiceNames()).thenReturn(serviceNames);	       
	        List<Object> responseEntity = screenController.findDistinctServiceNames();	     
	        assertEquals(serviceNames, responseEntity);	       
	        verify(screenService, times(1)).findDistinctServiceNames();
	    }
	    @Test
	    void testFindDistinctModuleNamesByServiceName() {	       
	        String serviceName = "Service1";
	        List<Object> moduleNames = Arrays.asList("Module1", "Module2", "Module3");	        
	        when(screenService.findDistinctModuleNamesByServiceName(serviceName)).thenReturn(moduleNames);	        
	        List<Object> responseEntity = screenController.findDistinctModuleNamesByServiceName(serviceName);
	        assertEquals(moduleNames, responseEntity);	        
	        verify(screenService, times(1)).findDistinctModuleNamesByServiceName(serviceName);
	    }

	    @Test
	    void testFindDistinctFeatureNamesByModuleName() {	      
	        String moduleName = "Module1";
	        List<Object> featureNames = Arrays.asList("Feature1", "Feature2", "Feature3");
	        when(screenService.findDistinctFeatureNamesByModuleName(moduleName)).thenReturn(featureNames);
	        List<Object> responseEntity = screenController.findDistinctFeatureNamesByModuleName(moduleName);
	        assertEquals(featureNames, responseEntity);
	        verify(screenService, times(1)).findDistinctFeatureNamesByModuleName(moduleName);
	    }

	    @Test
	    void testFindDistinctScreenNamesByFeatureName() {	   
	        String featureName = "Feature1";
	        List<Object> screenNames = Arrays.asList("Screen1", "Screen2", "Screen3");	      
	        when(screenService.findDistinctScreenNamesByFeatureName(featureName)).thenReturn(screenNames);	      
	        List<Object> responseEntity = screenController.findDistinctScreenNamesByFeatureName(featureName);
	        assertEquals(screenNames, responseEntity);
	        verify(screenService, times(1)).findDistinctScreenNamesByFeatureName(featureName);
	    }

	    @Test
	    void testFindAllScreens() {
	        List<Screen> screens = Arrays.asList(new Screen(), new Screen(), new Screen());
	        when(screenService.findAll()).thenReturn(screens);
	        List<Screen> responseEntity = screenController.findAll();
	        assertEquals(screens, responseEntity);
	        verify(screenService, times(1)).findAll();
	    }
	    
	    @Test
	    void testAdvSearchAll() {
	        String searchValue = "SearchValue";
	        String dropdown1 = "Dropdown1";
	        String dropdown2 = "Dropdown2";
	        String dropdown3 = "Dropdown3";
	        String dropdown4 = "Dropdown4";
	        String dropdown5 = "Dropdown5";
	        List<TranslationDTO> translationDTOs = Arrays.asList(new TranslationDTO(), new TranslationDTO());
	        when(screenService.advSearchAll(searchValue, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5))
	                .thenReturn(translationDTOs);
	        List<TranslationDTO> responseEntity = screenController.advSearchAll(searchValue, dropdown1,
	                dropdown2, dropdown3, dropdown4, dropdown5);
	        assertEquals(translationDTOs, responseEntity);
	        verify(screenService, times(1)).advSearchAll(searchValue, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5);
	    }

	    @Test
	    void testAdvSearchAllData() {
	        String searchValue = "SearchValue";
	        String dropdown1 = "Dropdown1";
	        String dropdown2 = "Dropdown2";
	        String dropdown3 = "Dropdown3";
	        String dropdown4 = "Dropdown4";
	        String dropdown5 = "Dropdown5";
	        List<TranslationDTO> translationDTOs = Arrays.asList(new TranslationDTO(), new TranslationDTO());
	        when(screenService.advSearchAllData(searchValue, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5))
	                .thenReturn(translationDTOs);
	        List<TranslationDTO> responseEntity = screenController.advSearchAllData(searchValue, dropdown1,
	                dropdown2, dropdown3, dropdown4, dropdown5);
	        assertEquals(translationDTOs, responseEntity);
	        verify(screenService, times(1)).advSearchAllData(searchValue, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5);
	    }

}
