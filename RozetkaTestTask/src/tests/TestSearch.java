package tests;

import java.util.ArrayList;

import objects.MainPage;
import objects.ResultsPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSearch {
	
	private FirefoxDriver driver;
	
	/**
	 * Condition before each test
	 */
	@Before
	public void setPrecondition(){
		driver = new FirefoxDriver();
		driver.get("http://rozetka.com.ua/");
	}
	
	/**
	 * Find all top sales smart phones and write results to the database
	 */
	@Test
	public void searchTopSalesSmartphonesTest() {
		
		MainPage mainPage = new MainPage(driver); //init mane page 
		
		//STEP 1: Split test handling		
		mainPage.switchSplitTest();
		
		//STEP 2: Search
		ResultsPage resultsPage = mainPage.chooseSubGroup("Телефоны, MP3, GPS", "Смартфоны"); //choose "Смартфоны" sub-group and init results page
		resultsPage.moreResults(2); //click 2 times "more results" button (display 2 more pages)
		
		//STEP 3: Find results 
		ArrayList<WebElement> topSales = resultsPage.getAllTopSales(); //all elements with "TOP SALES" label
		
		//STEP 4: Save results to database
		resultsPage.reportResults(topSales);
	}
	
	/**
	 * Condition after each test
	 */
	@After
	public void setPoscondition(){
		driver.close();
	}
}
