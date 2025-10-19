package testCases;

import java.lang.annotation.Documented;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class EvaluatingJs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("http://google.com");
		
		// to get the url of the page
		System.out.println(page.evaluate("document.location.href"));
		
		// adding textarea to the page
		
		page.evaluate("()"+
		"=>{"
		+ "const textArea=document.createElement('textArea');"
		+"document.body.prepend(textArea);"
		+"textArea.focus();"
		+ "}");
		
		String text = "Hello World !!";
		page.keyboard().type(text);
	}

}
