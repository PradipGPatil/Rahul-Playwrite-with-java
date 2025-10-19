package testCases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playWright = Playwright.create();
		Browser browser = playWright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		
		// find the number of the frame on the page
		Locator frame = page.locator("iframe");
		System.out.println(frame.count());
		
		// print all frames on page
		for(int i=0;i<frame.count();i++) {
			System.out.println(frame.nth(i).getAttribute("id"));
		}
		// we set the delay of 2 sec instead of defualt 30 sec
		page.frameLocator("#iframeResult").locator("xpath=//*[@id=\"demo\"]/preceding-sibling::button").click(new Locator.ClickOptions().setDelay(2000));
		System.out.println("program end here");
	}

}
