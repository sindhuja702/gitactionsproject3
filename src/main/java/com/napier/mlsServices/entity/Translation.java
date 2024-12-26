package com.napier.mlsServices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "translations")
public class Translation {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY) 
       private int translationId;
       private String labelKey;
       private String translatedValue;
       private int status;
       
       @ManyToOne
       @JoinColumn(name = "language_id")
       private Language language;

       @ManyToOne
       @JoinColumn(name = "screen_id")
       private Screen screen;

	public Translation() {
		super();
	}

	public Translation(int translationId, String labelKey, String translatedValue, int status, Language language,
			Screen screen) {
		super();
		this.translationId = translationId;
		this.labelKey = labelKey;
		this.translatedValue = translatedValue;
		this.status = status;
		this.language = language;
		this.screen = screen;
	}

	public int getTranslationId() {
		return translationId;
	}

	public void setTranslationId(int translationId) {
		this.translationId = translationId;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	public String getTranslatedValue() {
		return translatedValue;
	}

	public void setTranslatedValue(String translatedValue) {
		this.translatedValue = translatedValue;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}
              
}
