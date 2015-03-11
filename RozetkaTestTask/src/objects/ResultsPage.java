package objects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import system.MysqlConnection;
import system.WebDriverBaseClass;

public class ResultsPage extends WebDriverBaseClass {
	
	public ResultsPage (WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Click on "More results" button
	 * @param counter
	 */
	public void moreResults(int counter) {
		for (int i = 0; i < counter; i++) clickOnElementByXpath(".//a[@name='more_goods']");
	}
	
	/**
	 * Get all top sales items
	 * @return
	 */
	public ArrayList<WebElement> getAllTopSales() {
		return getMultiElementsByXpath(".//div[@class='gtile-i-image  popularity']");
	}
	
	/**
	 * Insert values to database table (only 'name' and 'price' values)
	 * @param elements
	 */
	public void reportResults(ArrayList<WebElement> elements) {
		
		MysqlConnection connection = new MysqlConnection();
		String name, price;
		
		for (int i = 0; i < elements.size(); i++) {
			name = elements.get(i).findElement(By.xpath(".//../../../div[@class='gtile-i-title']/a")).getText();
			price = elements.get(i).findElement(By.xpath(".//../../../div[@class='row-price-buy']/div/div/div")).getText();
			
			connection.updateTable("INSERT INTO test_results (name, price) VALUES ('" + name + "', '" + price + "')");
		}
	}
}
