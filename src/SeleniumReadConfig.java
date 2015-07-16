import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class SeleniumReadConfig {
	
//public void readconfig(){
	public static void main(String[] args) {
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
			HSSFCell A2 = row1.getCell(1);
			HSSFCell A3 = row1.getCell(2);
			System.out.println(A1);
			System.out.println(A2);
			System.out.println(A3);
			try
				{
				switch (A1)
				
				}
			
		
		
		/*
		HSSFRow row1 = worksheet.getRow(0);
		System.out.println(row1);
		HSSFCell A1 = row1.getCell(0);
		System.out.println(A1);
		*/

	
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		}

	
	
	
	
	
	