package com.napier.mlsServices.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.napier.mlsServices.entity.Translation;

@Repository
public interface TranslationRepo extends JpaRepository<Translation, Integer>{
      @Query("SELECT p FROM Translation p WHERE (:query IS NULL OR LOWER(p.labelKey) LIKE LOWER(CONCAT('%', :query, '%'))) ")
      List<Translation> searchTranslations(@Param("query") String query);
	
    	@Query("SELECT DISTINCT new map(t.labelKey as labelKey) FROM Translation t")
        List<Object> findDistinctLabelKeys();
    	
    	@Query("SELECT DISTINCT new map(t.translatedValue as translatedValue) FROM Translation t")
    	List<Object> findDistinctTranslatedValues();      
}