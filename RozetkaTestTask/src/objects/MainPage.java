package objects;

import org.openqa.selenium.WebDriver;

import system.WebDriverBaseClass;

/**
 * Class that implements page object for Google main page (Home)
 * @author Vitalii L.
 *
 */
public class MainPage extends WebDriverBaseClass {
	
	public MainPage (WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Click on "Sign in" button
	 * @return
	 */
	public SignInPage signIn() {
		
		clickOnElementByXpath(".//a[@id='gb_70']");	
		
		return new SignInPage(driver);
	}
}
