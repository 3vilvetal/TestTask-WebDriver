package objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import system.WebDriverBaseClass;

public class SignInPage extends WebDriverBaseClass {
	
	public SignInPage (WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Login on the sign in page
	 * @param user
	 * @param pass
	 * @return
	 */
	public MainPage login(String user, String pass) {
		
		driver.findElement(By.id("Email")).sendKeys(user);
		driver.findElement(By.id("Passwd")).sendKeys(pass);
		driver.findElement(By.id("signIn")).click();
		
		return new MainPage(driver);
	}
	
	/**
	 * Check that login failed
	 */
	public void assertLoginFailed() {
		Assert.assertEquals("Неверное имя пользователя или пароль. ?", driver.findElement(By.id("errormsg_0_Passwd")).getText());
	}
	
	/**
	 * Check that login succeed
	 */
	public void assertLoginSuccessed() {
		Assert.assertTrue(driver.findElement(By.id("hplogo")).isDisplayed());
	}
}
