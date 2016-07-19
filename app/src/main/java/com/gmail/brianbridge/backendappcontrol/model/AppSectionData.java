package com.gmail.brianbridge.backendappcontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppSectionData {
	private Map<Integer, AppSection> appSections = new HashMap<>();
	private int anchorPage = 0;
	private String version = "";

	@JsonProperty("sections")
	public Map<Integer, AppSection> getAppSections() {
		return appSections;
	}
	public void setAppSections(Map<Integer, AppSection> appSections) {
		this.appSections = appSections;
	}

	@JsonProperty("anchor_page")
	public int getAnchorPage() {
		return anchorPage;
	}
	public void setAnchorPage(int anchorPage) {
		this.anchorPage = anchorPage;
	}

	@JsonProperty("version")
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "AppSectionData{" + "\n" +
				"appSections=" + appSections + "\n" +
				", anchorPage=" + anchorPage + "\n" +
				", version='" + version + '\'' + "\n" +
				'}';
	}
}
