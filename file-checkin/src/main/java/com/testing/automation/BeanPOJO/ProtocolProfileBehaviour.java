package com.testing.automation.BeanPOJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProtocolProfileBehaviour {
	
	private DisabledSystemHeaders disabledSystemHeaders;

	public DisabledSystemHeaders getDisabledSystemHeaders() {
		return disabledSystemHeaders;
	}

	public void setDisabledSystemHeaders(DisabledSystemHeaders disabledSystemHeaders) {
		this.disabledSystemHeaders = disabledSystemHeaders;
	}

}
