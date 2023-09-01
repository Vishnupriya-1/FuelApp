package com.test.fuelApp.model;

public class ErrorInfo {
    private final String url;
    private final String ex;
     
    public ErrorInfo(String url, Exception ex) {
        this.url = url;
        this.ex = ex.getLocalizedMessage();
    }

	public String getUrl() {
		return url;
	}

	public String getEx() {
		return ex;
	}   
}