package page;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excel {
	public static void main(String[] args) throws Exception{
			
			Workbook wb = WorkbookFactory.create(new FileInputStream("C://Users//Pro//Desktop//k.xlsx"));
			 Cell value = wb.getSheet("Sheet1").getRow(0).getCell(0);
			value.setCellValue("kishor1");
			FileOutputStream fos = new FileOutputStream("C://Users//Pro//Desktop//k.xlsx");
			wb.write(fos);
			fos.close();
		}
}
