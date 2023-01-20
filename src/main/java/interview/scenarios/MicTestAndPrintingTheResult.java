package interview.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MicTestAndPrintingTheResult {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
//		WebDriverUtility w = new WebDriverUtility();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("mic test");
		driver.findElement(By.xpath("//center/following-sibling::style/input/[@class= 'gNO89b' and @value='Google Search']")).sendKeys("mic test");
	}
}
