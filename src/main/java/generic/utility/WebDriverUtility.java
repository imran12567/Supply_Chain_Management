package generic.utility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void implicitWait(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void waitForPageToLoadForJSElement(WebDriver driver, int time) {
		driver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
	}
	
	public void waitForElementToBeClickable(WebDriver driver, int timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void switchToSpecifiedTitledWindow(WebDriver driver, String specifiedTitle) {
		Set<String> allWH = driver.getWindowHandles();
		Iterator<String> i = allWH.iterator();
		while(i.hasNext()) {
			i.next();
			String wh = driver.getWindowHandle();
			if(wh.contains(specifiedTitle)) {
				driver.switchTo().window(wh);
				break;
			}

		}
	}
	
	public void switchToAlertToGetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	public void acceptingAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void rejectingAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void waitAndClick(WebDriver driver, WebElement element) throws InterruptedException {
		int count = 1;
		while(count<=20) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	public void selectByVisibleText(WebElement element , String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void selectByIndex(WebElement element , int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void selectByValue(  WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void takeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/main/resources/screenshot/ss.png");
		Files.copy(src, dest);
	}
}
