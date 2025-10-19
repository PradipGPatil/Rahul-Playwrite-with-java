package testCases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadingFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.selenium.dev/downloads/");
		
		
		
		Download jarFile=page.waitForDownload(()->{
			page.locator("//p[text()=\"Java\"]/parent::div/child::p").nth(1).click();
		});
		jarFile.saveAs(Paths.get("./src/test/resources"));
	}

}
