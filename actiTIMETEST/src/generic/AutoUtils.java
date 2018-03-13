package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoUtils {
	public static String getValue(String path,String sheet,int row,int cell) {
		String value="";	
		try {
				Workbook wb = WorkbookFactory.create(new FileInputStream(path));
				value=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
			} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
				e.printStackTrace();
			}
		return value;
	}
	
	public static int getRowCount(String path,String sheet) {
		int value =0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			value=wb.getSheet(sheet).getLastRowNum();
		}catch(EncryptedDocumentException | InvalidFormatException | IOException e) {
			
		}
		return value;
		
		
	}
	public static  int getCellCount(String path,String sheet,int row) {
		int value =0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			value=wb.getSheet(sheet).getRow(row).getLastCellNum();
		}catch(EncryptedDocumentException | InvalidFormatException | IOException e) {
			
		}
		return value;
		
	}
	public static void getPhoto(WebDriver driver ,String path) {
		try {
			String date = new Date().toString();
			date=date.replaceAll(":", "-");
		    String destFile=path+date+".png";
			 TakesScreenshot t = (TakesScreenshot)driver;
			File srcFile = t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(destFile));
		}catch(Exception e) {
			
		}
	}
	public static String getProperty(String path,String key) {
		
		String value="";
		try {
		Properties p=new Properties();
		p.load(new FileInputStream(path));
		value=p.getProperty(key);
		}catch(IOException e) {
			
		}
		return value;
	}
}
