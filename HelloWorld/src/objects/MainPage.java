package objects;

import org.openqa.selenium.WebDriver;

import system.WebDriverBaseClass;

public class MainPage extends WebDriverBaseClass {
	
	public MainPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public SignInPage signIn() {
		
		clickOnElementByXpath(".//a[@id='gb_70']");	
		
		return new SignInPage(driver);
	}
}
