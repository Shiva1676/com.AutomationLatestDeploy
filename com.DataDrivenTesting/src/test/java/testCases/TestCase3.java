/**
 * 
 */
package testCases;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import browserFactory.ConfigurationProvider;
import browserFactory.StartBrowser;
import pages.LoginPage;
import pages.Logout;
import utility.ExcelInfo;

/**
 * @author Lenovo
 *
 */
public class TestCase3 {

	ConfigurationProvider config;

	WebDriver driver;

	LoginPage login;

	boolean status = false;

	ExcelInfo excel;
	
	static DataFormatter df;
	
	static XSSFCell  cell;

	@BeforeSuite
	public void startBrowser() {

		excel = new ExcelInfo();

		System.out.println("============Excel loaded successfully============");

		config = new ConfigurationProvider();

		System.out.println("======Configuration file loaded sucessfully=======");

		driver = StartBrowser.getBrowser(config.getBrowser(), config.getURL());

	}

	@AfterSuite
	public void closeBrowser() {

		driver.quit();

	}

	@Test(dataProvider = "data")
	public void hrmLoginpage(String uname, String pass) {

		login = PageFactory.initElements(driver, LoginPage.class);

		login.loginDetails(uname, pass);

		Logout logout = PageFactory.initElements(driver, Logout.class);

		try {
			status = logout.logOutDetails();

			System.out.println("Login credentials are:" + uname + " " + pass);

		} catch (Exception e) {
			// TODO Auto-generated catch block

			System.out.println("Login credentials are:" + uname + " " + pass);

		}

	}

	@DataProvider(name = "data")
	public static Object[][] getHRMData() {

		int rows = ExcelInfo.getRows("Sheet1");

		int columns = ExcelInfo.getColumn("Sheet1");

		Object[][] arr = new Object[rows][columns];

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < columns; j++) {
				
				if(j==0)
					  cell = ExcelInfo.data("Sheet1", i, j);
				
				if(cell!=null)
				 df = new DataFormatter();
				
				arr[i][j] = df.formatCellValue(cell);
				
				if(j==1)
					  cell = ExcelInfo.data("Sheet1", i, j);
                 
				 df = new DataFormatter();
					
					arr[i][j] = df.formatCellValue(cell);

			}
		}

		return arr;
	}

}
