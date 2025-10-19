package testCases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.FillOptions;
import com.microsoft.playwright.Locator.TypeOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingKeyBoardEvent {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://login.yahoo.com/");
		page.locator("#login-username").type("trainer@way2automation.com", new TypeOptions().setDelay(500));
		
		page.keyboard().press("Enter");
		Thread.sleep(1000);
		page.goBack();
		Thread.sleep(1000);
		page.keyboard().press("Control+A");
		Thread.sleep(1000);
		page.keyboard().press("Control+X");
		Thread.sleep(1000);
		page.keyboard().press("Control+V");
		Thread.sleep(1000);
		
		page.keyboard().down("Shift");
		Thread.sleep(500);
		for(int i=0;i<3;i++) {
			page.keyboard().press("ArrowLeft");	
		}
		
		
	}

}
