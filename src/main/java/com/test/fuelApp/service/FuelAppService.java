package com.test.fuelApp.service;

public interface FuelAppService {
	
	public String getItems(String token,String queryString);
	public String updateItemName(String token,String queryString);
}
