package tests;

import objects.MainPage;
import objects.SignInPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLogin {
	
	private FirefoxDriver driver;
	
	/**
	 * Condition before each test
	 */
	@Before
	public void setPrecondition(){
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
	}
	
	/**
	 * Check adequate behavior when login failed 
	 */
	@Test
	public void loginFailed(){
		
		MainPage mainPage = new MainPage(driver);
		SignInPage signInPage = mainPage.signIn();
		
		signInPage.login("hello", "world");
		signInPage.assertLoginFailed();
	}
	
	/**
	 * Check that login was successful
	 */
	@Test
	public void loginSuccessful() {
		
		MainPage mainPage = new MainPage(driver);
		SignInPage signInPage = mainPage.signIn();
		
		signInPage.login("login", "pass");
		signInPage.assertLoginSuccessful();
	}
	
	/**
	 * Condition after each test
	 */
	@After
	public void setPoscondition(){
		driver.close();
	}
}
