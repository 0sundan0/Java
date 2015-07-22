import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.logging.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Test_Types {
	private WebDriver driver = new FirefoxDriver();;
	public String baseUrl;
	public String ID;
	String parentHandle = driver.getWindowHandle();
	static final Logger logger = LogManager.getLogger(Bar.class.getName());
	
		
public void driver1()
{
	baseUrl = "http://10.10.100.53/";
	driver.get(baseUrl);
	driver.manage().window().maximize();
	logger.entry();
}

public void login()
{
	logger.info("Entering login()");
	driver.findElement(By.id("user_username")).sendKeys("admin");
	driver.findElement(By.id("user_password")).sendKeys("test1234");
}

public void clickelementbyxpath(String ID){
	driver.findElement(By.xpath(ID)).click();
	logger.info("Clicking Element by Xpath" +ID );
}
public void clickelementbyid(String ID){
	driver.findElement(By.id(ID)).click();
	logger.info("Clicking Element by ID" +ID );
}
		
public void clickelementbycss(String ID){
	driver.findElement(By.cssSelector(ID));
	logger.info("Clicking Element by Css" +ID );
}

public void sendkeys(String ID, String text)
{
driver.findElement(By.xpath(ID)).sendKeys(text);
logger.info("Entering text" +ID);
}

public void getnewwindow()
{
  parentHandle = driver.getWindowHandle();
  for (String winHandle : driver.getWindowHandles()) {
	    driver.switchTo().window(winHandle);
	    logger.info("Switching to window" +winHandle );
	}
  
}
public void getoldwindow()
{
	driver.close(); 
	driver.switchTo().window(parentHandle);
	logger.info("Switching to parent window" +parentHandle );
}

public void getscreenshot()
{
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
		logger.info("Cauaght exception from main and capturing screenshot");
	} catch (IOException e1) {
		logger.error("Error while saving screenshot" +e1);
	}
}

}

