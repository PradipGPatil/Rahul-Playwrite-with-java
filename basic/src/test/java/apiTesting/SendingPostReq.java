package apiTesting;

import java.util.HashMap;
import java.util.Map;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class SendingPostReq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Playwright playwright=	Playwright.create();
	
	APIRequestContext request = playwright.request().newContext();
	
	
	
	// create the payload
	
	Map<String, Object> map=new HashMap<>();
	
	map.put("email", "way2@autom.com");
	map.put("firstName", "paddy");
	map.put("lastName", "patil");
	
	APIResponse response = request.post("http://localhost:8080/api/users",RequestOptions.create().setData(map));
	System.out.println(response.status());
	
	
	request.dispose();
	playwright.close();

	}

}
