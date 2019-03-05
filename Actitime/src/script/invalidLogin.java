package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.XL;
import page.LoginPage;

public class invalidLogin extends BaseTest {
	
	@Test(priority=2)
	public void testinvalidLogin() throws InterruptedException{
		
		int rc = XL.getRowCount(XL_PATH, "invalidLogin");
		Reporter.log("Rowcount:"+rc,true);
		for(int i=1;i<=rc;i++){
			
		String un = XL.getData(XL_PATH, "invalidLogin", i, 0);
		String pw = XL.getData(XL_PATH, "invalidLogin", i, 1);
		Reporter.log("UN:"+un,true);
		Reporter.log("PW:"+pw,true);
		//enter invalid un
		LoginPage l=new LoginPage(driver);
		l.setUN(un);
		//enter invalid pw
		l.setPW(pw);
		//click on login 
		l.Login();
		//verify Err message
		Thread.sleep(2000);
		l.verifyErrMsgDisplay();
		Thread.sleep(2000);
	}}

}
