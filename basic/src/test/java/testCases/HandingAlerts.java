package testCases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandingAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	 Playwright	playwright=Playwright.create();
	 
	 Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	 Page page = browser.newPage();
	 page.navigate("https://mail.rediff.com/cgi-bin/login.cgi");
	

	 // when ever alert listner is called it immedialtly accept the alear 
	 // so are not able to see alert box here 
	 // we can declare alerts before and after locating element 
	 // it will be applicable to all page
	 page.onDialog(dialog->{
		 dialog.accept();
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 System.out.println(dialog.message());
	 });
	 
	 Thread.sleep(2000);
	 
	 page.locator(".signin-btn").click();
	}

}
