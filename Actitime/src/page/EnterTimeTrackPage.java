package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage {
private final String xp="(//div[contains(text(),'Settings')])[1]";

@FindBy(xpath="(//div[contains(text(),'Settings')])[1]")
private WebElement setting;

@FindBy(linkText="Licenses")
private WebElement licenses;
	
	public EnterTimeTrackPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public void clickSetting(){
		setting.click();
	}
	public void clickLicenses(){
		licenses.click();
	}
	
	public void verifyHomePageisDisplayed(WebDriver driver,long time,String title){
		WebDriverWait wait=new WebDriverWait(driver,time);
		try{//we use try catch block to continue the execution
		wait.until(ExpectedConditions.titleIs(title));
		Reporter.log("Home page is dispalyed",true);
		}
		catch(Exception e){
			Reporter.log("home page is not displayed",true);
			Assert.fail();
		}
	}
}
