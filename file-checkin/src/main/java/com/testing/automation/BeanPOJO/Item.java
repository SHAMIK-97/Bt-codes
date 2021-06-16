package com.testing.automation.BeanPOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
	
	private String name;
	private ProtocolProfileBehaviour protocolProfileBehaviour;
	private Request request;
	private List<Response> response;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProtocolProfileBehaviour getProtocolProfileBehaviour() {
		return protocolProfileBehaviour;
	}
	public void setProtocolProfileBehaviour(ProtocolProfileBehaviour protocolProfileBehaviour) {
		this.protocolProfileBehaviour = protocolProfileBehaviour;
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public List<Response> getResponse() {
		return response;
	}
	public void setResponse(List<Response> response) {
		this.response = response;
	}
	
	

}
