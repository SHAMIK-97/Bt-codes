package com.testing.automation.BeanPOJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Options {
	
	private Raw raw;

	public Raw getRaw() {
		return raw;
	}

	public void setRaw(Raw raw) {
		this.raw = raw;
	}

}
