package generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoLib {
	
	public static void takephoto(WebDriver driver, String path){
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		   File src = ts.getScreenshotAs(OutputType.FILE);
		   File desc= new File(path);
		 
		  try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		  
			   
			   
		   }
	}


