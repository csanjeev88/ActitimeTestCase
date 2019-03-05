package page;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LicensePage {
	
	private final String xp="//nobr[text()='Issue Date:']/../../td[2]";
	@FindBy(xpath=xp)
	private WebElement issuedate;
	
	public LicensePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public void verifyissuedate(String expected){
		String actual = issuedate.getText();
		
		Assert.assertEquals(actual, expected);
	}
}
