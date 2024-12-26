package com.napier.mlsServices.dto;

public class TranslationDTO {
	private int screenId;
	private String serviceName;
    private String moduleName;
    private String featureName;
    private String screenName;
    private int translationId;
    private String labelKey;
    private String translatedValue;
    private int status;
    private int languageId;
    private String languageName;	 
    private String languageDescription;
	public TranslationDTO() {
		super();
	}
	public TranslationDTO(int screenId, String serviceName, String moduleName, String featureName,
			String screenName, int translationId, String labelKey, String translatedValue, int status, int languageId,
			String languageName, String languageDescription) {
		super();
		this.screenId = screenId;
		this.serviceName = serviceName;
		this.moduleName = moduleName;
		this.featureName = featureName;
		this.screenName = screenName;
		this.translationId = translationId;
		this.labelKey = labelKey;
		this.translatedValue = translatedValue;
		this.status = status;
		this.languageId = languageId;
		this.languageName = languageName;
		this.languageDescription = languageDescription;
	}
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
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
	@Override
	public String toString() {
		return "RequestScrTransLang2 [screenId=" + screenId + ", serviceName=" + serviceName + ", moduleName="
				+ moduleName + ", featureName=" + featureName + ", screenName=" + screenName + ", translationId="
				+ translationId + ", labelKey=" + labelKey + ", translatedValue=" + translatedValue + ", status="
				+ status + ", languageId=" + languageId + ", languageName=" + languageName + ", languageDescription="
				+ languageDescription + "]";
	}
    
}
