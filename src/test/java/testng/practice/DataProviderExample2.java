package testng.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample2 {
	@DataProvider
	public Object [][] gettingExcelData() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/DataProvider.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("abc");
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		Object [][] destinations = new Object[lastRow+1][lastCell];

		for(int i=0; i<=lastRow; i++) {
			for(int j=0; j<lastCell; j++) {
				destinations[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return destinations;
	}

	@Test (dataProvider = "gettingExcelData")
	public void ticketBooking(String from, String to) {
		
		System.out.println(from +"--->"+to);
	}
	
//	@Test (dataProviderClass = Ex.class, dataProvider = "getExcelData")
//	public void ticketBooking(String from, String to) {
//		
//				System.out.println(from +"--->"+to);
//	}

}