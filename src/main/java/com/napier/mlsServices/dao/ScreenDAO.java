package com.napier.mlsServices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.napier.mlsServices.Repository.ScreenRepo;
import com.napier.mlsServices.dto.TranslationDTO;
import com.napier.mlsServices.entity.Screen;

@Component
public class ScreenDAO {
     
	@Autowired
	private ScreenRepo screenRepo;

	public List<Screen> findAll() {
		return screenRepo.findAll();
	}

	public Screen save(Screen screen) {		
		return screenRepo.save(screen);
	}

	public Optional<Screen> findById(int screenId) {		
		return screenRepo.findById(screenId);
	}

	public List<TranslationDTO> advSearchAllData(String searchValue, String dropdown1, String dropdown2,
			String dropdown3, String dropdown4, String dropdown5) {
		return screenRepo.advSearchAllData(searchValue, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5);
	}

	public List<Object> findDistinctServiceNames() {
		return screenRepo.findDistinctServiceNames();
	}

	public List<Object> findDistinctModuleNamesByServiceName(String serviceName) {
		return screenRepo.findDistinctModuleNamesByServiceName(serviceName);
	}

	public List<Object> findDistinctFeatureNamesByModuleName(String moduleName) {
		return screenRepo.findDistinctFeatureNamesByModuleName(moduleName);
	}

	public List<Object> findDistinctScreenNamesByFeatureName(String featureName) {
		return screenRepo.findDistinctScreenNamesByFeatureName(featureName);
	}

	public List<TranslationDTO> advSearchAll(String searchValue, String dropdown1, String dropdown2,
			String dropdown3, String dropdown4, String dropdown5) {
		return screenRepo.advSearchAll(searchValue, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5);
	}
	
}
