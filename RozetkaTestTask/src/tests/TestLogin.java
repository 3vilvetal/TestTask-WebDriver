package tests;

import java.util.ArrayList;

import objects.MainPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLogin {
	
	private FirefoxDriver driver;
	
	/**
	 * Condition before each test
	 */
	@Before
	public void setPrecondition(){
		driver = new FirefoxDriver();
		driver.get("http://rozetka.com.ua/");
	}
	
	
	@Test
	public void search(){
		
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseSubGroup("Телефоны, MP3, GPS", "Смартфоны");
		
		ArrayList<WebElement> topSales = mainPage.getMultiElementsByXpath(".//div[@class='gtile-i-image  popularity']");
		System.out.println(topSales.get(1).findElement(By.xpath(".//../../../div[@class='gtile-i-title']/a")).getText());
		
//		List <WebElement> temp = driver.findElementsByCssSelector(".goods .action .tag, .goods .novelty .tag, .goods .popularity .tag");
//		WebElement parent = temp.get(0).findElement(By.xpath(".."));
//		System.out.println(parent.getAttribute("class"));
		
	}
	
	
	/**
	 * Condition after each test
	 */
	@After
	public void setPoscondition(){
		driver.close();
	}
}
