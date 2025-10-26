package testCases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;

public class CapturingScreenShot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright=	Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://jqueryui.com/resources/demos/slider/default.html");
		
		Locator slider=page.locator(".ui-slider-handle");
		slider.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./src/test/resources/Element.png")));
		page.screenshot(new ScreenshotOptions().setPath(Paths.get("./src/test/resources/Page.png")));
	}

}
