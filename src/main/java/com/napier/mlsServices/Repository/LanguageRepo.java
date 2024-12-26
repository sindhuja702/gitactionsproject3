package com.napier.mlsServices.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.napier.mlsServices.entity.Language;

public interface LanguageRepo extends JpaRepository<Language, Integer> {	
	@Query("SELECT DISTINCT new map(l.languageName as languageName) FROM Language l")
	List<Object> findDistinctLanguageNames();
}
