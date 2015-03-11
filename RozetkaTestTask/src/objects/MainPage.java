package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import system.WebDriverBaseClass;

/**
 * Class that implements page object for Rozetka main page (Home)
 * @author Vitalii L.
 *
 */
public class MainPage extends WebDriverBaseClass {
	
	public MainPage (WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Turn off split test if it is present 
	 */
	public void switchSplitTest() {
		WebElement split = findElementSafe(driver, By.xpath(".//div[@id='split_test_switcher']/a"));
		if (split != null) split.click();
	}
	
	/**
	 * Choose group in the main page
	 * @param tabText
	 * @return
	 */
	public GropsPage chooseGroup(String tabText) {
		clickOnElementByXpath(".//span[@class='m-main-title-text' and text()='" + tabText + "']");	
		return new GropsPage(driver);
	}
	
	/**
	 * Choose group and sub-group in the main page
	 * @param tabText
	 * @param subTabText
	 * @return
	 */
	public ResultsPage chooseSubGroup(String tabText, String subTabText) {
		chooseGroup(tabText);
		clickOnElementByXpath(".//a[@class='m-main-fat-link3' and text()='" + subTabText + "']");
		return new ResultsPage(driver);
	}
}
