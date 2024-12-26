package com.napier.mlsServices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.napier.mlsServices.dao.ScreenDAO;
import com.napier.mlsServices.dto.TranslationDTO;
import com.napier.mlsServices.entity.Screen;

@Service
public class ScreenService {	
	@Autowired
	private ScreenDAO screenDAO;

	public List<Screen> findAll() {
		return screenDAO.findAll();
	}

	public Screen save(Screen screen) {		
		return screenDAO.save(screen);
	}

	public Optional<Screen> findById(int screenId) {	
		return screenDAO.findById(screenId);
	}

	public List<TranslationDTO> advSearchAllData(String searchValue, String dropdown1, String dropdown2,
			String dropdown3, String dropdown4, String dropdown5) {
	
		return screenDAO.advSearchAllData(searchValue, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5);
	}
  
	public List<Object> findDistinctServiceNames() {		
		return screenDAO.findDistinctServiceNames();
	}

	public List<Object> findDistinctModuleNamesByServiceName(String serviceName) {
		return screenDAO.findDistinctModuleNamesByServiceName(serviceName);
	}

	public List<Object> findDistinctFeatureNamesByModuleName(String moduleName) {
		return screenDAO.findDistinctFeatureNamesByModuleName(moduleName);
	}

	public List<Object> findDistinctScreenNamesByFeatureName(String featureName) {
		return screenDAO.findDistinctScreenNamesByFeatureName(featureName);
	}

	public List<TranslationDTO> advSearchAll(String searchValue, String dropdown1, String dropdown2,
			String dropdown3, String dropdown4, String dropdown5) {
		return screenDAO.advSearchAll(searchValue, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5);
	}
	
}
