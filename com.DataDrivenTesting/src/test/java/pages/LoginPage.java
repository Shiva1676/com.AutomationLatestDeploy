/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Lenovo
 *
 */
public class LoginPage {

	WebDriver driver;
	
	@FindBy(how = How.ID, using = "txtUsername")
	WebElement username;
	
	@FindBy(how = How.ID, using = "txtPassword")
	WebElement password;
	
	@FindBy(how = How.ID, using = "btnLogin")
	WebElement submitButton;
	
	
	public LoginPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	public void loginDetails(String uname, String pass){
		
		username.sendKeys(uname);
		
		password.sendKeys(pass);
		
		submitButton.click();
	}
	
}
