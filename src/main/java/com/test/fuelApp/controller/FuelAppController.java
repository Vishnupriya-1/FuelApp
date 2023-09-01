package com.test.fuelApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.fuelApp.service.FuelAppService;

@RestController
public class FuelAppController {
	
	@Autowired
	private FuelAppService fuelAppService;
	
	@RequestMapping(value = "/getItems", method = RequestMethod.GET)
	public String getItems(@RequestParam(name="token") String token,
			@RequestBody String queryString) {
		String items = fuelAppService.getItems(token, queryString);
		return items;
	}
	
	@RequestMapping(value = "/updateItemName", method = RequestMethod.GET)
	public String updateItemName(@RequestParam(name="token") String token,@RequestBody String queryString) {
		String items = fuelAppService.updateItemName(token, queryString);
		return items;
	}
}
