import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.logging.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Test_Types {
	private WebDriver driver = new FirefoxDriver();;
	public String baseUrl;
	public String ID;
	public String source;
	public String newtarget;
	
	String parentHandle = driver.getWindowHandle();
	static final Logger logger = LogManager.getLogger(Test_Types.class.getName());
	static final ExtentReports extent = ExtentReports.get(Test_Types.class);;
	
			
public void driver1()
{
	extent.init("C:\\Results.html", true);
	//extent.startTest("Main");
	baseUrl = "https://10.10.100.53/";
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
	extent.log(LogStatus.PASS, "clickelementbyxpath", "Clicked on ID" +ID); 
	
}
public void clickelementbyid(String ID){
	driver.findElement(By.id(ID)).click();
	logger.info("Clicking Element by ID" +ID );
	extent.log(LogStatus.PASS, "clickelementbyid", "Clicked on ID" +ID); 
}
		
public void clickelementbycss(String ID){
	driver.findElement(By.cssSelector(ID));
	logger.info("Clicking Element by Css" +ID );
	extent.log(LogStatus.PASS, "clickelementbycss", "Clicked on ID" +ID); 
}

public void sendkeys(String ID, String text)
{
driver.findElement(By.xpath(ID)).sendKeys(text);
logger.info("Entering text" +ID);
extent.log(LogStatus.PASS, "Entering Text", "on the ID" +ID); 
}

public void getnewwindow()
{
  parentHandle = driver.getWindowHandle();
  for (String winHandle : driver.getWindowHandles()) {
	    driver.switchTo().window(winHandle);
	    logger.info("Switching to window" +winHandle );
	    extent.log(LogStatus.PASS, "Switching to New Window", "With ID" +winHandle); 
	}
  
}
public void getoldwindow()
{
	driver.close(); 
	driver.switchTo().window(parentHandle);
	logger.info("Switching to parent window" +parentHandle );
}

public void draganddrop(String source, String newtarget)
{
	WebElement element = driver.findElement(By.xpath(source)); 
	WebElement target =  driver.findElement(By.xpath(newtarget)) ;
	(new Actions(driver)).dragAndDrop(element, target).build().perform();
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

