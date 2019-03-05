package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.XL;
import page.EnterTimeTrackPage;
import page.LicensePage;
import page.LoginPage;

public class CheckIssueDate extends BaseTest {

	@Test(priority=3)
	public void testCheckIssueDate() throws InterruptedException{
		String un = XL.getData(XL_PATH, "IssueDate", 1, 0);
		String pw = XL.getData(XL_PATH, "IssueDate", 1, 1);
		String idate = XL.getData(XL_PATH, "IssueDate", 1, 2);
		//enter valid  un
		LoginPage l=new LoginPage(driver);
				l.setUN(un);
				//enter valid pw
				l.setPW(pw);
				//click login
				l.Login();
				//click setting
				Thread.sleep(2000);
				EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
				e.clickSetting();
				Thread.sleep(2000);
				//click license
				e.clickLicenses();
				Thread.sleep(2000);
				//verify Issuedate
				LicensePage p=new LicensePage(driver);
				p.verifyissuedate(idate);
				
		
	}
	
}
