package script;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.BaseTest;

public class Irctc {
	
	static{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
		
		String path="./data/input.xlsx";
	 Workbook wb = WorkbookFactory.create(new FileInputStream(path));
	    String city = wb.getSheet("irctc").getRow(1).getCell(0).toString();
	    System.out.println(city);
	    
	    String xp="//label[text()='"+city+"']/../label[2]";
	    System.out.println(xp);
	    
	    WebDriver driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.get("http://irctc.com/displayServlet");
	    String ph="";
	    try{
	    	ph=driver.findElement(By.xpath(xp)).getText();
	    }
	    catch(Exception e){
	    	ph="city not found";
	    }
	    System.out.println(ph);
	    driver.close();
	    
	    wb.getSheet("irctc").getRow(1).createCell(1).setCellValue(ph);
	    wb.write(new FileOutputStream(path));
	    wb.close();
	    
	    
	}
}
