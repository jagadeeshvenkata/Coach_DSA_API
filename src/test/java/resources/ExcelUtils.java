package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;

	private static XSSFSheet xlsxWorkSheet;
	private static XSSFWorkbook xlsxWorkBook;
	private static XSSFCell xlsxCell;
	@SuppressWarnings("unused")
	private static XSSFRow xlsxRow;

	private static HSSFSheet xlsWorkSheet;
	private static HSSFWorkbook xlsWorkBook;
	private static HSSFCell xlsCell;
	@SuppressWarnings("unused")
	private static HSSFRow xlsRow;
	public static String path = System.getProperty("user.dir") + "\\src\\test\\resources\\data.xlsx";

	/** To get the Excel-XLSX File with Path and SheetName */
	public static void getExcelFile_XLSX(String SheetName) throws Exception {
		try {
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			xlsxWorkBook = new XSSFWorkbook(fis);
			xlsxWorkSheet = xlsxWorkBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	/** To get the Excel-XLS File with Path and SheetName */
	public static void getExcelFile_XLS(String SheetName) throws Exception {
		try {
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			xlsWorkBook = new HSSFWorkbook(fis);
			xlsWorkSheet = xlsWorkBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	/** To Return the Excel-XLSX Values given Path to the File and Sheet Name */

	public static Object[][] getTableArray_XLSX(String FilePath, String SheetName) throws Exception {
		Object[][] tabArray = null;
		try {
			File file = new File(FilePath);
			FileInputStream ExcelFile = new FileInputStream(file);
			xlsxWorkBook = new XSSFWorkbook(ExcelFile);
			xlsxWorkSheet = xlsxWorkBook.getSheet(SheetName);

			int startRow = 1;
			int startCol = 0;
			int ci, cj;
			int totalRows = ExcelUtils.xlsxRowCount();
			int totalCols = ExcelUtils.xlsxColumnCount();
			tabArray = new Object[totalRows - 1][totalCols];
			ci = 0;
			for (int i = startRow; i < totalRows; i++) {
				cj = 0;
				for (int j = startCol; j < totalCols; j++) {
					tabArray[ci][cj] = getCellData_XLSX(i, j);
					cj++;
				}
				ci++;
			}
		} catch (FileNotFoundException e) {
			throw new Exception("Could not Find the Excel File/Sheet");
		} catch (Exception e) {
			throw new Exception("Could not Open the Excel File");
		}
		return (tabArray);
	}

	/** To Return the Excel-XLS Values given Path to the File and Sheet Name */
	public static Object[][] getTableArray_XLS(String FilePath, String SheetName) throws Exception {
		Object[][] tabArray = null;
		try {
			File file = new File(FilePath);
			FileInputStream ExcelFile = new FileInputStream(file);
			xlsWorkBook = new HSSFWorkbook(ExcelFile);
			xlsWorkSheet = xlsWorkBook.getSheet(SheetName);

			int startRow = 1;
			int startCol = 0;
			int ci, cj;
			int totalRows = ExcelUtils.xlsRowCount();
			int totalCols = ExcelUtils.xlsColumnCount();
			tabArray = new Object[totalRows - 1][totalCols];
			ci = 0;
			for (int i = startRow; i < totalRows; i++) {
				cj = 0;
				for (int j = startCol; j < totalCols; j++) {
					tabArray[ci][cj] = getCellData_XLS(i, j);
					cj++;
				}
				ci++;
			}
		} catch (FileNotFoundException e) {
			throw new Exception("Could not Find the Excel File/Sheet");
		} catch (Exception e) {
			throw new Exception("Could not Open the Excel File");
		}
		return (tabArray);
	}

	/** To Return the Excel-XLSX Values given Path to the File */
	public static Object[][] getTableArray_XLSX() throws Exception {
		Object[][] tabArray = null;
		try {
			File file = new File(path);
			FileInputStream ExcelFile = new FileInputStream(file);
			xlsxWorkBook = new XSSFWorkbook(ExcelFile);
			xlsxWorkSheet = xlsxWorkBook.getSheetAt(0);

			int startRow = 1;
			int startCol = 0;
			int ci, cj;
			int totalRows = ExcelUtils.xlsxRowCount();
			int totalCols = ExcelUtils.xlsxColumnCount();
			tabArray = new Object[totalRows - 1][totalCols];
			ci = 0;
			for (int i = startRow; i < totalRows; i++) {
				cj = 0;
				for (int j = startCol; j < totalCols; j++) {
					tabArray[ci][cj] = getCellData_XLSX(i, j);
					cj++;
				}
				ci++;
			}
		} catch (FileNotFoundException e) {
			throw new Exception("Could not Find the Excel File/Sheet");
		} catch (Exception e) {
			throw new Exception("Could not Open the Excel File");
		}
		return (tabArray);
	}

	/** To Return the Excel-XLS Values given Path to the File */
	public static Object[][] getTableArray_XLS(String FilePath) throws Exception {
		Object[][] tabArray = null;
		try {
			File file = new File(FilePath);
			FileInputStream ExcelFile = new FileInputStream(file);
			xlsWorkBook = new HSSFWorkbook(ExcelFile);
			xlsWorkSheet = xlsWorkBook.getSheetAt(0);

			int startRow = 1;
			int startCol = 0;
			int ci, cj;
			int totalRows = ExcelUtils.xlsxRowCount();
			int totalCols = ExcelUtils.xlsxColumnCount();
			tabArray = new Object[totalRows - 1][totalCols];
			ci = 0;
			for (int i = startRow; i < totalRows; i++) {
				cj = 0;
				for (int j = startCol; j < totalCols; j++) {
					tabArray[ci][cj] = getCellData_XLS(i, j);
					cj++;
				}
				ci++;
			}
		} catch (FileNotFoundException e) {
			throw new Exception("Could not Find the Excel File/Sheet");
		} catch (Exception e) {
			throw new Exception("Could not Open the Excel File");
		}
		return (tabArray);
	}

	/** To get cell data from Excel-XLSX */
	public static Object getCellData_XLSX(int RowNum, int ColNum) throws Exception {
		Object CellData = null;
		try {
			xlsxCell = xlsxWorkSheet.getRow(RowNum).getCell(ColNum);

			DataFormatter formatter = new DataFormatter();
			CellData = formatter.formatCellValue(xlsxCell);
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static String getCellDataasString(String xlfile, String sheetName, int rownum, int colnum)
			throws IOException {

		fi = new FileInputStream(xlfile);
		xlsxWorkBook = new XSSFWorkbook(fi);
		xlsxWorkSheet = xlsxWorkBook.getSheet(sheetName);

		xlsxRow = xlsxWorkSheet.getRow(rownum);
		xlsxCell = xlsxRow.getCell(colnum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(xlsxCell);
			return cellData;

		} catch (Exception e) {
			data = "";

		}
		xlsxWorkBook.close();
		fi.close();
		return data;

	}

	/** To get cell data from Excel-XLS */
	public static Object getCellData_XLS(int RowNum, int ColNum) throws Exception {
		Object CellData = null;
		try {
			xlsCell = xlsWorkSheet.getRow(RowNum).getCell(ColNum);
			if (xlsCell.getCellType() == CellType.STRING) {
				String stringCellData = xlsCell.getStringCellValue();
				CellData = stringCellData;
			} else if (xlsCell.getCellType() == CellType.NUMERIC) {
				double numericCellData = xlsCell.getNumericCellValue();
				CellData = numericCellData;
			} else if (xlsCell.getCellType() == CellType.BOOLEAN) {
				boolean booleanCellData = xlsCell.getBooleanCellValue();
				CellData = booleanCellData;
			}
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * To iterate through excel sheet and get cellData into array-XLSX Row Count
	 * 
	 * @throws Exception
	 */

	public static String[][] getDataInStringArray(String path, String sheetname) throws Exception {

		int rownum = xlsxRowCount();
		int colnum = xlsxColumnCount();

		String[][] data = new String[rownum][colnum];

		try {
			for (int i = 1; i <= rownum; i++) {
				for (int j = 0; j < colnum; j++) {

					data[i - 1][j] = (String) getCellData_XLSX(i, j);

				}

			}
			// System.out.println("ARRAY OF TEST DATA FROM EXCEL"+data.toString());
			return data;
		}

		catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	// Write string data to xlsx sheet
	public static void setCellData(String xlfile, String sheetName, int rownum, int colnum, String data)

			throws IOException {

		try {
			fi = new FileInputStream(xlfile);

			xlsxWorkBook = new XSSFWorkbook(fi);
			xlsxWorkSheet = xlsxWorkBook.getSheet(sheetName);
			try {
				xlsxRow = xlsxWorkSheet.getRow(rownum);

				xlsxCell = xlsxRow.createCell(colnum);
				xlsxCell.setCellValue(data);
				fo = new FileOutputStream(xlfile);
				xlsxWorkBook.write(fo);
				xlsxWorkBook.close();
				fo.close();

				fi.close();

			} catch (Exception e) {
				
				xlsxRow = xlsxWorkSheet.createRow(rownum);
				xlsxCell = xlsxRow.createCell(colnum);
				xlsxCell.setCellValue(data);
				fo = new FileOutputStream(xlfile);
				xlsxWorkBook.write(fo);
				xlsxWorkBook.close();
				fo.close();

				fi.close();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
	// Write integer data to xlsx sheet
	public static void setCellData(String xlfile, String sheetName, int rownum, int colnum, int data)

			throws IOException {

		try {
			fi = new FileInputStream(xlfile);

			xlsxWorkBook = new XSSFWorkbook(fi);
			xlsxWorkSheet = xlsxWorkBook.getSheet(sheetName);
			try {
				xlsxRow = xlsxWorkSheet.getRow(rownum);

				xlsxCell = xlsxRow.createCell(colnum);
				xlsxCell.setCellValue(data);
				fo = new FileOutputStream(xlfile);
				xlsxWorkBook.write(fo);
				xlsxWorkBook.close();
				fo.close();

				fi.close();

			} catch (Exception e) {
				
				xlsxRow = xlsxWorkSheet.createRow(rownum);
				xlsxCell = xlsxRow.createCell(colnum);
				xlsxCell.setCellValue(data);
				fo = new FileOutputStream(xlfile);
				xlsxWorkBook.write(fo);
				xlsxWorkBook.close();
				fo.close();

				fi.close();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
	
	
	
	

	/** To get Excel-XLSX Row Count */
	public static int xlsxRowCount() {
		int rowNum = xlsxWorkSheet.getLastRowNum();
		return rowNum;
	}

	/** To get Excel-XLS Row Count */
	public static int xlsRowCount() {
		int rowNum = xlsWorkSheet.getLastRowNum() + 1;
		return rowNum;
	}

	/** To get Excel-XLSX Column Count */
	public static int xlsxColumnCount() {
		int rowNum = xlsxWorkSheet.getRow(0).getLastCellNum();
		return rowNum;
	}

	/** To get Excel-XLS Column Count */
	public static int xlsColumnCount() {
		int rowNum = xlsWorkSheet.getRow(0).getLastCellNum();
		return rowNum;
	}
}