package com.napier.mlsServices.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.napier.mlsServices.dto.TranslationDTO;
import com.napier.mlsServices.entity.Screen;

@Repository
public interface ScreenRepo extends JpaRepository<Screen, Integer>{   
	
	    @Query("SELECT DISTINCT new map(s.serviceName as serviceName) FROM Screen s")
	    List<Object> findDistinctServiceNames();
	  
	    @Query("SELECT DISTINCT new map(s.moduleName as moduleName) FROM Screen s WHERE s.serviceName = :serviceName")
	    List<Object> findDistinctModuleNamesByServiceName(String serviceName);
	    
	    @Query("SELECT DISTINCT new map(s.featureName as featureName) FROM Screen s WHERE s.moduleName = :moduleName")
	    List<Object> findDistinctFeatureNamesByModuleName(String moduleName);
	    
	    @Query("SELECT DISTINCT new map(s.screenName as screenName) FROM Screen s WHERE s.featureName = :featureName")
	    List<Object> findDistinctScreenNamesByFeatureName(String featureName);
	
		 @Query("SELECT new com.napier.mlsServices.dto.TranslationDTO(" +
		            "c.screenId, c.serviceName, c.moduleName, c.featureName, c.screenName, " +
		            "p.translationId, p.labelKey, p.translatedValue, p.status, " +
		            "l.languageId, l.languageName, l.languageDescription) " +
		            "FROM Screen c " +
		            "JOIN c.translation p " +
		            "JOIN p.language l " +
		            "WHERE (:searchValue IS NULL OR LOWER(c.serviceName) LIKE LOWER(CONCAT('%', :searchValue, '%'))) " +
		            "AND (:dropdown1 IS NULL OR c.moduleName = :dropdown1) " +
		            "AND (:dropdown2 IS NULL OR c.featureName = :dropdown2) " +
		            "AND (:dropdown3 IS NULL OR c.screenName = :dropdown3) " +
		            "AND (:dropdown4 IS NULL OR l.languageName = :dropdown4) " +
		            "AND (:dropdown5 IS NULL OR p.labelKey = :dropdown5) ")
		    List<TranslationDTO> advSearchAll(
		            @Param("searchValue") String searchValue,
		            @Param("dropdown1") String dropdown1,
		            @Param("dropdown2") String dropdown2,
		            @Param("dropdown3") String dropdown3,
		            @Param("dropdown4") String dropdown4,
		            @Param("dropdown5") String dropdown5);
		 
		 @Query("SELECT new com.napier.mlsServices.dto.TranslationDTO(" +
		            "c.screenId, c.serviceName, c.moduleName, c.featureName, c.screenName, " +
		            "p.translationId, p.labelKey, p.translatedValue, p.status, " +
		            "l.languageId, l.languageName, l.languageDescription) " +
		            "FROM Screen c " +
		            "JOIN c.translation p " +
		            "JOIN p.language l " +
		            "WHERE (:searchValue IS NULL OR LOWER(c.serviceName) LIKE LOWER(CONCAT('%', :searchValue, '%'))) " +
		            "AND (:dropdown1 IS NULL OR c.moduleName = :dropdown1) " +
		            "AND (:dropdown2 IS NULL OR c.featureName = :dropdown2) " +
		            "AND (:dropdown3 IS NULL OR c.screenName = :dropdown3) " +
		            "AND (:dropdown4 IS NULL OR l.languageName = :dropdown4) " +
		            "AND (:dropdown5 IS NULL OR p.labelKey = :dropdown5) " +
		            "AND p.status = 0")
		    List<TranslationDTO> advSearchAllData(
		            @Param("searchValue") String searchValue,
		            @Param("dropdown1") String dropdown1,
		            @Param("dropdown2") String dropdown2,
		            @Param("dropdown3") String dropdown3,
		            @Param("dropdown4") String dropdown4,
		            @Param("dropdown5") String dropdown5);
			
}

