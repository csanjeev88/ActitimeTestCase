package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement login;
	
	@FindBy(xpath="//span[contains(text(),'invalid')]")
	private WebElement errMsg;
	
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public void setUN(String un){
		unTB.sendKeys(un);
	}
	
	public void setPW(String pw){
		pwTB.sendKeys(pw);
	}
	
	public void Login(){
		login.click();
	}
	public void verifyErrMsgDisplay(){
	Assert.assertTrue(errMsg.isDisplayed());//for check it is display or not and true or false
	}
}
