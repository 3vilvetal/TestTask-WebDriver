package system;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverBaseClass {
	
	public WebDriver driver;
	WebDriverWait wait;
	
	/**
	 * Method that returns list of Web elements by XPATH
	 * @param xpath
	 * @return List of WebElements 
	 * @throws 
	 * this is example of XPATH that will prepare all element of menu you can get text for each element
	 * .//div[@class='navbar navbar-fixed-top']/div[@class='navbar-inner']/ul[@class='nav']//li/a
	 */
	public ArrayList<WebElement> getMultiElementsByXpath(String xpath) {
		return (ArrayList<WebElement>) (driver.findElements(By.xpath(xpath)));
	}
	
	/**
	 * Method that return text of single element by XPATH
	 * @param xpath
	 * @return String 
	 * @throws 
	 */
	public String getOneElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}

	/**
	 * Method that click on element by XPATH
	 * @param xpath
	 */	
	public void clickOnElementByXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	/**
	 * Method created to gather a list of attributes from multiple elements by XPATH
	 * @param xpath
	 * @param attribute
	 * @return collection of attribute values
	 */
	public ArrayList<String> getArrayOfAttributesByXpath(String xpath, String attribute) {
		
		ArrayList<WebElement> widgetsElements = getMultiElementsByXpath(xpath);
		ArrayList<String> arrayOfAttributes = new ArrayList<String>();
		
		String temp;
		for (WebElement element: widgetsElements) {
			temp = element.getAttribute(attribute);
			if (temp != null) arrayOfAttributes.add(temp);
		}
		return arrayOfAttributes;
	}
	
	/**
	 * Don't crash test (return null) in case when WebDriver didn't find an element on a page
	 * @param driver
	 * @param by
	 * @return
	 */
	public WebElement findElementSafe(WebDriver driver, By by)
    {
        try
        {
            return driver.findElement(by);
        }
        catch (NoSuchElementException exception)
        {
            return null;
        }
    }
}
