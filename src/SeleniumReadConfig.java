import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class SeleniumReadConfig {
	
	
public static void main(String[] args) {
	Tesst test  =new Tesst();
	test.driver1();
	test.login();
	try
	{
		FileInputStream fileInputStream = new FileInputStream("D:\\Eclipse\\workspace\\Selenium\\src\\TestCases.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet worksheet = workbook.getSheet("testcases");
		int lastrow= worksheet.getLastRowNum();
		System.out.println("Number of lines with non null values "+lastrow);
		
		
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
			System.out.println(A1);
			System.out.println(A2);
			System.out.println(A3);
			System.out.println(A1);
				
			switch (action) {
			case "click":
					if (Identifier.endsWith("xpath"));
					test.clickelementbyxpath(value);
					}
			
		}
				
	 }catch (FileNotFoundException e) {
		e.printStackTrace();
	 } catch (IOException e) {
			e.printStackTrace();
				
	 }
}
}


	
	
	
	
	
	