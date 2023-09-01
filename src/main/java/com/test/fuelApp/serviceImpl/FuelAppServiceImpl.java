package com.test.fuelApp.serviceImpl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.test.fuelApp.service.FuelAppService;

@Service
public class FuelAppServiceImpl implements FuelAppService {
	
	public String getItems(String token,String queryString) {
		StringBuffer response = null;
		try
		{
			URL obj = new URL("https://api.monday.com/v2");
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type","application/json");
			connection.setRequestProperty("Authorization",token);
			connection.setDoOutput(true);
			DataOutputStream  dataOutputStream= new DataOutputStream (connection.getOutputStream());
			dataOutputStream.writeBytes(queryString);
			dataOutputStream.close();
	
			int responseCode = connection.getResponseCode();	
			if (responseCode == HttpURLConnection.HTTP_OK) { //success
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
			    response = new StringBuffer();
	
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
			} else {
				System.out.println("Monday.com POST request did not work for getting the items");
			}
									
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
		return response.toString();
	}
	
	public String updateItemName(String token,String queryString) {
		StringBuffer response = null;
		try
		{
			URL obj = new URL("https://api.monday.com/v2");
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type","application/json");
			connection.setRequestProperty("Authorization",token);
			connection.setDoOutput(true);
			DataOutputStream dataOutputStream = new DataOutputStream (connection.getOutputStream());
			dataOutputStream.writeBytes(queryString);
			dataOutputStream.close();
			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { //success
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
			    response = new StringBuffer();
	
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
			} else {
				System.out.println("Monday.com POST request did not work for updating the item name");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return response.toString();
	}
}
