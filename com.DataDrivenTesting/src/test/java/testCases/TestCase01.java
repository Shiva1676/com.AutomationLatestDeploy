/**
 * 
 */
package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import browserFactory.ConfigurationProvider;
import browserFactory.StartBrowser;
import pages.LoginPage;

/**
 * @author Lenovo
 *
 */
public class TestCase01 {

	ConfigurationProvider config;

	WebDriver driver;

	LoginPage login;

	@Test(dataProvider = "data")
	public void hrmLoginpage(String uname, String pass) {

		config = new ConfigurationProvider();

		System.out.println("======Configuration file loaded sucessfully=======");

		driver = StartBrowser.getBrowser(config.getBrowser(), config.getURL());

		login = PageFactory.initElements(driver, LoginPage.class);

		login.loginDetails(uname, pass);

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws IOException {

		File src = new File(
				"C:\\Users\\Lenovo\\workspace1\\HybridFramework\\Latest\\com.DataDrivenTesting\\ExcelData\\LoginData.xlsx");

		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Sheet1");

		int row = sheet.getPhysicalNumberOfRows();

		// int column =
		// 2;//wb.getSheet("Login").getRow(0).getPhysicalNumberOfCells();

		int column = wb.getSheet("Sheet1").getRow(0).getLastCellNum();

		Object[][] arr = new Object[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				XSSFCell cell = wb.getSheet("Sheet1").getRow(i).getCell(j);
				// final DataFormatter df = new DataFormatter();
				// arr[i][j] = getCellValue(cell);

				if (cell != null) {

					final DataFormatter df = new DataFormatter();

					arr[i][j] = df.formatCellValue(cell);
				}

			}
		}
		wb.close();
		return arr;

	}

}
