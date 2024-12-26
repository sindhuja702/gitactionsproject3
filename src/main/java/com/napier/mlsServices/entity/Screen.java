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
@Table(name = "screens")
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int screenId;
    private String screenName;
    private String serviceName;
    private String moduleName;
    private String featureName;
    
    @OneToMany(targetEntity=Translation.class,cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name="screen_id" , referencedColumnName="screenId")
    @JsonIgnore 
	private List<Translation> translation;

	public Screen() {
		super();
	}

	public Screen(int screenId, String screenName, String serviceName, String moduleName, String featureName,
			List<Translation> translation) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.serviceName = serviceName;
		this.moduleName = moduleName;
		this.featureName = featureName;
		this.translation = translation;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
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

	public List<Translation> getTranslation() {
		return translation;
	}

	public void setTranslation(List<Translation> translation) {
		this.translation = translation;
	}

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", screenName=" + screenName + ", serviceName=" + serviceName
				+ ", moduleName=" + moduleName + ", featureName=" + featureName + ", translation=" + translation + "]";
	}
	
	
}
