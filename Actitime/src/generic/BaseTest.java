package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public abstract class BaseTest implements IAutoConst{

		public WebDriver driver;
		static{
			System.setProperty(Chrome_Key, Chrome_value);
		}
		@BeforeMethod
		public void openApp(){
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(IOT, TimeUnit.SECONDS);
			driver.get(App_URL);
		
	}
     @AfterMethod
     public void closeApp(ITestResult iTestResult){
    	 int status=iTestResult.getStatus();
 		String name=iTestResult.getName();
 		if(status==1) {
 			Reporter.log("Test "+name+" is PASS",true);
 		}
 		else {
 			Reporter.log("Test "+name+" is FAIL/SKIP",true);
 			AutoLib.takephoto(driver,IMG_PATH+name+".png");			
 		}
    	 driver.close();
     }
}
