package testCases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PopupAndTabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");

		// here we are navigating to another tab. used lamda function which return the page object
		Page tab2=page.waitForPopup(()->{
			page.locator("text=Privacy Policy").nth(0).click();
		});
		
		tab2.locator("text=Sign Up").click();
		tab2.locator("#name").fill("Pradip Patil");
	
		// closing the browser
		tab2.close();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page.close();
		playwright.close();
	}

	
}
