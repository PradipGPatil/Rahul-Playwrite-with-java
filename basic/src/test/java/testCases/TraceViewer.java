package testCases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class TraceViewer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		// create browser context
		
		BrowserContext context = browser.newContext();
		
		// set sources to false
		
		context.tracing().start(new Tracing.StartOptions()
				  .setScreenshots(true)
				  .setSnapshots(true)
				  .setSources(false));
		// change browser to context
		Page page=context.newPage();
		
		page.navigate("https://www.way2automation.com/");
		
		page.locator("//*[text()=\"All Courses\"]/parent::a").nth(0).hover();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page.locator("#menu-item-27583").click();
		
		context.tracing().stop(new Tracing.StopOptions()
				  .setPath(Paths.get("trace.zip")));
		
		page.close();
		
		// close the context
		context.close();
		playwright.close();
	}

}
