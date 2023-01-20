package testcase.manufacturer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import generic.utility.IPathConstants;
import generic.utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ST_UpdatingQuantityOfProductsTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		WebDriverUtility w=new WebDriverUtility();
		w.implicitWait(driver, 10);
		
		// Login as Manufacturer
		FileInputStream fis=new FileInputStream(IPathConstants.propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		driver.get(p.getProperty("url"));
		driver.findElement(By.id("login:username")).sendKeys(p.getProperty("un"));
		driver.findElement(By.id("login:password")).sendKeys(p.getProperty("pwd"));
		WebElement loginType = driver.findElement(By.id("login:type"));
		Select s = new Select(loginType);
		s.selectByValue("manufacturer");
		driver.findElement(By.className("submit_button")).click();
		Thread.sleep(1000);
		
//		driver.findElement(By.partialLinkText("Home")).click();
//		String welcomeText = driver.findElement(By.tagName("section")).getText();
//		System.out.println(welcomeText);
		
		driver.findElement(By.partialLinkText("Manage Stock")).click();
		driver.findElement(By.xpath("//td[contains(text(),'"+p.getProperty("nameForStock")+"')]/following-sibling::td/input")).sendKeys(Keys.CONTROL+"a");
		driver.findElement(By.xpath("//td[contains(text(),'"+p.getProperty("nameForStock")+"')]/following-sibling::td/input")).sendKeys(p.getProperty("quantity"));
		driver.findElement(By.xpath("//input[contains(@value,'Update Stock')]")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("login:username")).sendKeys(p.getProperty("un"));
		driver.findElement(By.id("login:password")).sendKeys(p.getProperty("pwd"));
		WebElement loginType2 = driver.findElement(By.id("login:type"));
		Select s2 = new Select(loginType2);
		s2.selectByValue("admin");
		driver.findElement(By.className("submit_button")).click();
		Thread.sleep(1000);

		driver.findElement(By.partialLinkText("Products")).click();
		String updatedNumber = driver.findElement(By.xpath("//td[text()=' Choco ']/following-sibling::td[text()=' 123 ']")).getText();
		if(updatedNumber.contains(p.getProperty("quantity"))) {
			System.out.println("Quantity of the product has been updated");
		}
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		Thread.sleep(1000);
		driver.close();
		System.out.println("Test Pass");
		
	}
}
