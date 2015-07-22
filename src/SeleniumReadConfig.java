import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;

public class SeleniumReadConfig {
	
	
public static void main(String[] args) {
	Test_Types test  =new Test_Types();
	test.driver1();
	//test.login();
	try
	{
		FileInputStream fileInputStream = new FileInputStream("D:\\Eclipse\\workspace\\Selenium\\src\\TestCases.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet worksheet = workbook.getSheet("testcases");
		int lastrow= worksheet.getLastRowNum();
		test.logger.info("Number of lines with non null values"+lastrow);
		
		for (int i= 1; i<= lastrow; i++){
			HSSFRow row1 = worksheet.getRow(i);
			HSSFCell A1 = row1.getCell(0);
			String action = A1.getStringCellValue();
			test.logger.info("reading action from excel and the action is" +action);
			HSSFCell A2 = row1.getCell(1);
			String Identifier = A2.getStringCellValue();
			test.logger.info("reading Identifier from excel and identifier is" +Identifier);
			HSSFCell A3 = row1.getCell(2);
			String value = A3.getStringCellValue();
			test.logger.info("reading value from excel and value is" +value);
			HSSFCell A4 = row1.getCell(3);
			String newtarget = A4.getStringCellValue();
			test.logger.info("reading value from excel and value is" +newtarget);
			System.out.println(newtarget);
						
			switch (action) {
			case "click":
				try{
					if (Identifier.equals("xpath"))
					{
						test.clickelementbyxpath(value);
					}
					else if(Identifier.equals("ID"))
					{
						test.clickelementbyid(value);
					}
					
					else if (Identifier.equals("CSS"))
					{
						test.clickelementbycss(value);
					}
				}
				catch (NoSuchElementException e) {
				test.logger.error("Exception" +e);
					test.getscreenshot();
				test.logger.info("screenshot saved");
				}
			case "DND":

				try{
					if (Identifier.equals("xpath"))
					{
						test.draganddrop(value, newtarget);
					}
				
				}
				catch (NoSuchElementException e) {
				test.logger.error("Exception" +e);
					test.getscreenshot();
				test.logger.info("screenshot saved");
				}
					
							}
		}
	 }catch (FileNotFoundException e) {
		e.printStackTrace();
	 } catch (IOException e) {
			e.printStackTrace();
				
	 }
}
}


	
	
	
	
	
	