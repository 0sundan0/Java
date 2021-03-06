import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.logging.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.TakesScreenshot;

import java.sql.Timestamp;
import java.util.Date;

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
	public String filepath2;
	
	
	String parentHandle = driver.getWindowHandle();
	static final Logger logger = LogManager.getLogger(Test_Types.class.getName());
	static final ExtentReports extent = ExtentReports.get(Test_Types.class);;
	java.util.Date date= new java.util.Date();
	long reporttime = date.getTime();
	public String filepath= "D:\\Screenshots\\Reports\\"+reporttime+".html";
			
public void driver1()
{
	extent.init(filepath, true);
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
	long screenshottime = date.getTime();
	filepath2= "D:\\Screenshots\\"+screenshottime+".png";
	try {
		 File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshotFile,new File("D:\\Screenshots\\"+screenshottime+".png"));
		logger.info("Cauaght exception from main and capturing screenshot");
	} catch (IOException e1) {
		logger.error("Error while saving screenshot" +e1);
	}
}

public void verifyelement()
{
	if(driver.findElements(By.xpath(ID)).size() != 0){
		extent.log(LogStatus.PASS, "Verified the presence of ", "Element" +ID);
		}else{
		getscreenshot();
		extent.log(LogStatus.FAIL, "Image", "Action failed at this screen:", filepath);
		}
}



}

