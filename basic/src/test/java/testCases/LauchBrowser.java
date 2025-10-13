package testCases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LauchBrowser {

	public static void main(String arg[]) {
		// create the instance of the browser
		Playwright playwright=Playwright.create();
		
		// lauch method retrun the instance of the browser
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		// create instance of the page 
	   Page page = browser.newPage();
	   
	   // navigate to the page
	   page.navigate("https://www.way2automation.com/");
	   System.out.println(page.title());
	   try {
	   Thread.sleep(5000);
	   }catch(Exception e){
		   
	   }
	   
	   // close the page
	   page.close();
	   
	   // close the session
	   playwright.close();
	}
}
