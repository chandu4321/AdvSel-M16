package genericlib;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Chandana N
 */
public class WebdriverUtil {

/**
 * the method is used to maximize the window
 * @param driver
 */
	public void maximizeTheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

/**
 * this method is used to refresh the page
 * @param driver
 */
	public void refershThePage(WebDriver driver) {
		driver.navigate().refresh();
	}

/**
 * this method is used to forward  the page
 * @param driver
 */
	public void forwardThePage(WebDriver driver) {
		driver.navigate().forward();
	}

/**
 * this method is used to implicitly wait
 * @param driver
 */
	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

/**
 * this method for explicit wait elementToBeClickable
 * @param driver
 * @param element
 */
	public void elementClickableWait(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
/**
 * this method for explicit wait elementToBeSelected
 * @param driver
 * @param element
 */
	public void elementToBeSelectedWait(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

/**
 * this method is used to switch the frame
 * @param driver
 * @param element
 */
	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

/**
 * this method is used for switch back the frame
 * @param driver
 * @param element
 */
	public void switchBackFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

/**
 * this method is used to select the dropdown using value
 * @param element
 * @param value
 */
	public void selectDropdownByValue(WebElement element, String value) {
		Select sel= new Select(element);
		sel.selectByValue(value);
	}

/**
 * this method is used to select the dropdown using visible text
 * @param element
 * @param text
 */
	public void selectDropdownByVisibleText(WebElement element, String text) {
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}

/**
 * this method is used to deselect the dropdown using value
 * @param element
 * @param value
 */
	public void deSelectDropdownByValue(WebElement element, String value) {
		Select sel= new Select(element);
		sel.deselectByValue(value);
	}

/**
 * this method to handle alert popup-accept
 * @param driver
 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

/**
 * this method to handle alert popup-dismiss
 * @param driver
 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();;
	}

/**
 * this method is used for double click on element
 * @param driver
 * @param element
 */
	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		Actions actions= new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
/**
 * this method is used to for right click on element
 * @param driver
 * @param element
 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions actions= new Actions(driver);
		actions.contextClick(element).perform();		
	}
	
/**
 * this method is used to scroll window down	
 * @param driver
 */
	public void scrollDownWindow(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);");
	}
	
/**
 * this method is used to scroll window up
 * @param driver
 */
	public void scrollUpWindow(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-500);");
	}

/**
 * this method is used to close the Browser
 * @param driver
 */
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}
}
