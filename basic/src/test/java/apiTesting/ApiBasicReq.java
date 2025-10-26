package apiTesting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class ApiBasicReq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// we need to run local server before hiting this api call
		
	Playwright playwrite=	Playwright.create();
	
	// 1) here do not need any external package it has buidl in feature and jsonParsor as well
	
	//APIRequestContext class is used for making HTTP API calls (like GET, POST, PUT, etc.)
	//directly from your tests, without opening a browser.
	APIRequestContext request = playwrite.request().newContext();
	
	APIResponse response = request.get("http://localhost:8080/api/users");

	System.out.println(response.status());
	String reponseBody=response.text();
	System.out.println(reponseBody);
	
	// in order to terminate session we need to close the request
	request.dispose();
	playwrite.close();
	
	// suppose we need to do validation
	
	// converted string in jsonArray 
	 JsonArray responseBodyAsJson = JsonParser.parseString(reponseBody).getAsJsonArray();
	 // take 1 object from the array 
	 JsonObject firstName1 = responseBodyAsJson.get(0).getAsJsonObject();
	 /// taken fistName from jsonObject and converted into string
	 String firstName=firstName1.get("firstName").getAsString();
	System.out.println("firat name : "+firstName);
	}

}
