package com.napier.mlsServices.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "languages")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int languageId;
    private String languageName;	 
    private String languageDescription;

    
    @OneToMany( targetEntity=Translation.class,cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name="language_id" , referencedColumnName="languageId")
    @JsonIgnore 
	private List<Translation> translation;

		public Language() {
			super();
		}
		
		public Language(int languageId, String languageName, String languageDescription, List<Translation> translation) {
			super();
			this.languageId = languageId;
			this.languageName = languageName;
			this.languageDescription = languageDescription;
			this.translation = translation;
		}
		
		public int getLanguageId() {
			return languageId;
		}
		
		public void setLanguageId(int languageId) {
			this.languageId = languageId;
		}
		
		public String getLanguageName() {
			return languageName;
		}
		
		public void setLanguageName(String languageName) {
			this.languageName = languageName;
		}
		
		public String getLanguageDescription() {
			return languageDescription;
		}
		
		public void setLanguageDescription(String languageDescription) {
			this.languageDescription = languageDescription;
		}
		
		public List<Translation> getTranslation() {
			return translation;
		}
		
		public void setTranslation(List<Translation> translation) {
			this.translation = translation;
		}
		
		@Override
		public String toString() {
			return "Language [languageId=" + languageId + ", languageName=" + languageName + ", languageDescription="
					+ languageDescription + ", translation=" + translation + "]";
		}
}
		    
	
    
