package com.napier.mlsServices.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.napier.mlsServices.dto.TranslationDTO;
import com.napier.mlsServices.dto.ScreenDTO;
import com.napier.mlsServices.entity.Screen;
import com.napier.mlsServices.entity.Translation;
import com.napier.mlsServices.service.ScreenService;

@RestController
@RequestMapping("/mls")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ScreenController {
      
    @Autowired
    private ScreenService screenService; 
  
    @GetMapping("/advSearchAll")
    public List<TranslationDTO> advSearchAll(
            @RequestParam(name="searchValue") String searchValue,
            @RequestParam(name="dropdown1" ,required = false) String dropdown1,
            @RequestParam(name="dropdown2" ,required = false) String dropdown2,
            @RequestParam(name="dropdown3" ,required = false) String dropdown3,
            @RequestParam(name="dropdown4" ,required = false) String dropdown4,
            @RequestParam(name="dropdown5" ,required = false) String dropdown5) { 
        return screenService.advSearchAll(searchValue, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5);
    } 
    
    @GetMapping("/advSearchAllData")
    public List<TranslationDTO> advSearchAllData(
            @RequestParam(name="searchValue") String searchValue,
            @RequestParam(name="dropdown1" ,required = false) String dropdown1,
            @RequestParam(name="dropdown2" ,required = false) String dropdown2,
            @RequestParam(name="dropdown3" ,required = false) String dropdown3,
            @RequestParam(name="dropdown4" ,required = false) String dropdown4,
            @RequestParam(name="dropdown5" ,required = false) String dropdown5) { 
        return screenService.advSearchAllData(searchValue, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5);
    }   
    
    @PostMapping("/addscr")
    public Screen addScr(@RequestBody ScreenDTO requestS) {
    	return screenService.save(requestS.getScreen());
    } 

    @PutMapping("/updatescr")
    public Screen updatescr(@RequestBody ScreenDTO requestS) {
        Screen existingScreen = screenService.findById(requestS.getScreen().getScreenId()).orElse(null);
     
        if (existingScreen != null) {      
            existingScreen.setScreenName(requestS.getScreen().getScreenName());
            existingScreen.setServiceName(requestS.getScreen().getServiceName());
            existingScreen.setModuleName(requestS.getScreen().getModuleName());
            existingScreen.setFeatureName(requestS.getScreen().getFeatureName());          
     
            List<Translation> updatedTranslations = requestS.getScreen().getTranslation();         
         
            if (updatedTranslations != null) {
                for (Translation updatedTranslation : updatedTranslations) {                 
                    Translation existingTranslation = existingScreen.getTranslation()
                        .stream()
                        .filter(t -> t.getTranslationId() == updatedTranslation.getTranslationId())
                        .findFirst()
                        .orElse(null);
     
                    if (existingTranslation != null) {                   
                        existingTranslation.setLabelKey(updatedTranslation.getLabelKey());
                        existingTranslation.setTranslatedValue(updatedTranslation.getTranslatedValue());
                        existingTranslation.setStatus(updatedTranslation.getStatus());
                    } else {
                           continue;
                    }
                }
            }    
        
            return screenService.save(existingScreen);
        } else {           
            return null;
        }
    }
    
    @GetMapping("/serviceName")
    public List<Object> findDistinctServiceNames(){
    	return screenService.findDistinctServiceNames();
    }
    
    @GetMapping("/moduleForService")
    public List<Object> findDistinctModuleNamesByServiceName(@RequestParam("serviceName") String serviceName){
    	return screenService.findDistinctModuleNamesByServiceName(serviceName);
    }
    
    @GetMapping("/featureForModule")
    public List<Object> findDistinctFeatureNamesByModuleName(@RequestParam("moduleName") String moduleName){
    	return screenService.findDistinctFeatureNamesByModuleName(moduleName);
    }
    
    @GetMapping("/scrForFeature")
    public List<Object> findDistinctScreenNamesByFeatureName(@RequestParam("featureName") String featureName){
    	return screenService.findDistinctScreenNamesByFeatureName(featureName);
    }
      
    @GetMapping("/scr")
    public List<Screen> findAll(){
    	return screenService.findAll();
    }  
        
}
