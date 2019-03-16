/**
 * 
 */
package utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Lenovo
 *
 */
public class ExcelInfo {

	FileInputStream fis;

	static XSSFWorkbook wb;

	XSSFSheet sheet;

	static XSSFCell cell;

	static DataFormatter df;

	public ExcelInfo() {

		// String path = System.getProperty("user.dir") +
		// "/ExcelData/LoginData.xlsx";

		File src = new File(
				"C:\\Users\\Lenovo\\workspace1\\HybridFramework\\Latest\\com.DataDrivenTesting\\ExcelData\\LoginData.xlsx");

		try {
			fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

			sheet = wb.getSheet("Sheet1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to load excel sheet");

			System.out.println(e.getMessage());
		}

	}

	public static int getRows(String sheetname) {

		int rows = wb.getSheet(sheetname).getPhysicalNumberOfRows();

		return rows;
	}

	public static int getColumn(String sheetname) {

		int column = wb.getSheet(sheetname).getRow(0).getPhysicalNumberOfCells();

		return column;
	}

	//

	public static XSSFCell data(String sheetname, int row, int column) {

		XSSFCell cell = wb.getSheet(sheetname).getRow(row).getCell(column);

		return cell;
	}

	// Getting the data

	public static Object[][] getHRMData(String sheetname) {

		int rows = ExcelInfo.getRows(sheetname);

		int columns = ExcelInfo.getColumn(sheetname);

		Object[][] arr = new Object[rows][columns];

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < columns; j++) {

				cell = wb.getSheet(sheetname).getRow(i).getCell(j);

				if (cell != null) {

					df = new DataFormatter();

					arr[i][j] = df.formatCellValue(cell);

				}

			}
		}

		return arr;
	}

}
