package com.gmail.brianbridge.backendappcontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppSection {
	private String name;

	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AppSection{" + "\n" +
				"name='" + name + '\'' + "\n" +
				'}' + "\n";
	}
}
