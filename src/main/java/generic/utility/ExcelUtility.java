package generic.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author MD IMRAN ANSARI
 *
 */
public class ExcelUtility {
	/**
	 * This method will help you to fetch data present in the specified cell.
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return data present in the passed excel cell.
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName, int rownum, int cellnum) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.excelSheetPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet(sheetName);
			String data = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
			return data;
	}
	
	public int getTotalRowNumber(String sheetName, int rownum, int cellnum) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.excelSheetPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum();
			return totalRow;
	}
	/**
	 * This method will help you to write on the Excel cell.
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws Throwable
	 */
	
	public void writeOnExcel(String sheetName, int rownum, int cellnum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.excelSheetPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet(sheetName);
			sheet.createRow(rownum).createCell(cellnum).setCellValue(data);
			FileOutputStream fos = new FileOutputStream(IPathConstants.excelSheetPath);
			wb.write(fos);
			wb.close();
			System.out.println("Data inserted into the Excel file.");
	}
}
