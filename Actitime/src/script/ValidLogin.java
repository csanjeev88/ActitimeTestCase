package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.XL;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLogin extends BaseTest {
	
	@Test(priority=1)
	public void testValidLogin() throws InterruptedException{
		String un=XL.getData(XL_PATH, "ValidLoginPage", 1, 0);
		String pw=XL.getData(XL_PATH, "ValidLoginPage", 1, 1);
		String title=XL.getData(XL_PATH, "ValidLoginPage", 1, 2);
		
		//Enter valid username
		LoginPage l=new LoginPage(driver);
		l.setUN(un);
		//Enter valid password
		l.setPW(pw);
		//click on loginButton
		l.Login();
		//verify home page is displayed
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.verifyHomePageisDisplayed(driver, EOT, title);
		
		e.clickSetting();
		Thread.sleep(2000);
		
	}
	

}
