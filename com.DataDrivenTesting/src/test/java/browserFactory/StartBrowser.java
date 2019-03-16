/**
 * 
 */
package browserFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Lenovo
 *
 */
public class StartBrowser {

	static WebDriver driver;
	
	public static WebDriver getBrowser(String browser, String url){
		
		if(browser.equalsIgnoreCase("Chrome")){
			
			driver = new ChromeDriver();
			
		}else if (browser.equalsIgnoreCase("Firefox")) {
			
			driver = new FirefoxDriver();
			
		}else if (browser.equalsIgnoreCase("IE")) {
			
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		return driver;
		
	}
	
}
