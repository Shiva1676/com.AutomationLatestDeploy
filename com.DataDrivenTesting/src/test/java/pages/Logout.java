/**
 * 
 */
package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Lenovo
 *
 */
public class Logout {

	WebDriver driver;

	@FindBy(how = How.ID, using = "welcome")
	WebElement welcomeTab;

	@FindBy(how = How.XPATH, using = ".//*[text()= 'Logout']")
	WebElement logoutButton;

	public Logout(WebDriver driver) {

		this.driver = driver;
	}

	public boolean logOutDetails() {

		boolean status = false;

		try {
			status = welcomeTab.isDisplayed();

			welcomeTab.click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			System.out.println("Test case of the data is:" +status);

		} catch (Exception e) {

			System.out.println("Test case of the data is:" +status + " " + "Element not found");
			
		}

		logoutButton.click();
		
		return status;
	}

}
