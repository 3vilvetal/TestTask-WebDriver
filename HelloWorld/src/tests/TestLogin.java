package tests;

import objects.MainPage;
import objects.SignInPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLogin {
	
	private FirefoxDriver driver;
	
	@Before
	public void setPrecondition(){
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void loginFailed(){
		
		MainPage mainPage = new MainPage(driver);
		SignInPage signInPage = mainPage.signIn();
		
		signInPage.login("hello", "world");
		signInPage.assertLoginFailed();
	}
	
	@Test
	public void loginSuccessed() {
		
		MainPage mainPage = new MainPage(driver);
		SignInPage signInPage = mainPage.signIn();
		
		signInPage.login("login", "pass");
		signInPage.assertLoginSuccessed();
	}
	
	@After
	public void setPoscondition(){
		driver.close();
	}
}
