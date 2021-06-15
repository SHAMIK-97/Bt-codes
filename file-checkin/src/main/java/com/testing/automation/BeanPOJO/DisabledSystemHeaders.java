package com.testing.automation.BeanPOJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisabledSystemHeaders {
	
	private boolean acceptencoding;
	
	public boolean isAcceptencoding() {
		return acceptencoding;
	}

	public void setAcceptencoding(boolean acceptencoding) {
		this.acceptencoding = acceptencoding;
	}

	

}
