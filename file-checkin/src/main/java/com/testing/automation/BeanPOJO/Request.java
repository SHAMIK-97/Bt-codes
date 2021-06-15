package com.testing.automation.BeanPOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
	
	private String method;
	private List<Headers> header;
	private Body body;
	private Url url;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public List<Headers> getHeaders() {
		return header;
	}
	public void setHeaders(List<Headers> headers) {
		this.header = headers;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	public Url getUrl() {
		return url;
	}
	public void setUrl(Url url) {
		this.url = url;
	}

}
