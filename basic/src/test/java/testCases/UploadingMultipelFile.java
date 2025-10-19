package testCases;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class UploadingMultipelFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_multiple");
		
		// 
		page.frameLocator("#iframeResult").locator("#myFile").setInputFiles(
				new Path[]{
					Paths.get("./src/test/resources/istockphoto-1285833149-2048x2048.jpg"),
					Paths.get("./src/test/resources/istockphoto-1285833149-2048x2048.jpg")
				}
				);
	}

}
