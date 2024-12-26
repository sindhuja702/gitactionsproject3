package com.napier.mlsServices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.napier.mlsServices.entity.Translation;
import com.napier.mlsServices.service.TranslationService;

@RestController
@RequestMapping("/mls")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TranslationController {	
	@Autowired
	private TranslationService translationService;  
	
	@GetMapping("/labelKey")
    public List<Object> findDistinctLabelKeys(){
    	return translationService.findDistinctLabelKeys();
    }
	
	@GetMapping("/transValue")
    public List<Object> findDistinctTranslatedValues(){
    	return translationService.findDistinctTranslatedValues();
    }
    
    @GetMapping("/trans")
    public List<Translation> findAll(){
    	return translationService.findAll();
    }
    
	  @GetMapping("/search")
	  public ResponseEntity<List<Translation>> searchTranslations(@RequestParam("query") String query){
	  	return ResponseEntity.ok(translationService.searchTranslations(query));
	  }
    
	  @PutMapping("/updateTrans")
	    public ResponseEntity<?> updateTranslation(@RequestBody Translation requestT) {
	        try {
	            Translation updatedTranslation = translationService.updateTranslation(requestT);
	            return new ResponseEntity<>(updatedTranslation, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Failed to update translation: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	   @PostMapping("/addTrans")
	    public Translation addTranslations(@RequestBody Translation requestT) {
	    	return translationService.save(requestT);
	    }
	   
	   @PutMapping("/updateStatus")
	   public ResponseEntity<Translation> updateTranslationStatus(@RequestParam int translationId, @RequestParam int newStatus) {
	       Optional<Translation> existingTranslationOptional = translationService.findById(translationId);
	       
	       if (existingTranslationOptional.isPresent()) {
	           Translation existingTranslation = existingTranslationOptional.get();
	           existingTranslation.setStatus(newStatus);
	           Translation updatedTranslation = translationService.save(existingTranslation);
	           return ResponseEntity.ok(updatedTranslation);
	       } else {
	    	   return null;

	       }
	   }

	    
}
