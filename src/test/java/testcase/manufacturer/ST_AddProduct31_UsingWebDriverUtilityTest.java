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

public class ST_AddProduct31_UsingWebDriverUtilityTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		WebDriverUtility w=new WebDriverUtility();
		driver.manage().window().maximize();
		w.implicitWait(driver, 10);

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
		
		driver.findElement(By.partialLinkText("Add Products")).click();
		driver.findElement(By.id("product:name")).sendKeys(p.getProperty("pName"));
		driver.findElement(By.id("product:price")).sendKeys(p.getProperty("price"));
		
		WebElement unit = driver.findElement(By.id("product:unit"));
		w.selectByValue(unit, "2");
		WebElement category = driver.findElement(By.id("product:category"));
		w.selectByValue(category, "10");
		
		driver.findElement(By.name("rdbStock")).click();
		
		driver.findElement(By.id("product:description")).sendKeys(p.getProperty("desc"));
		driver.findElement(By.xpath("//input[@value='Add Product']")).click();
		
		String addText = driver.switchTo().alert().getText();
		if(addText.contains("Product Added Successfully")) {
			System.out.println("Product Added Successfully");
		}
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		
		driver.findElement(By.partialLinkText("Products")).click();
		driver.findElement(By.xpath("//td[text() = ' "+p.getProperty("pName")+" ']/../td/a/img[@alt='edit']/..")).click();
		driver.findElement(By.id("product:price")).sendKeys(Keys.CONTROL+"a");
		driver.findElement(By.id("product:price")).sendKeys(p.getProperty("price2"));
		Thread.sleep(2000);
		driver.findElement(By.name("rdbStock")).click();
		driver.findElement(By.xpath("//input[@value='Update Product']")).click();
		String updateText = driver.switchTo().alert().getText();
		if(updateText.contains("Product Updated Successfully")) {
			System.out.println("Product Updated Successfully");
		}
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		driver.findElement(By.partialLinkText("Products")).click();
		driver.findElement(By.xpath("//td[text() = ' "+p.getProperty("pName")+" ']/../td/input[@name='chkId[]']")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		String deleteText = driver.switchTo().alert().getText();
		if(deleteText.contains("Products Deleted Successfully")) {
			System.out.println("Products Deleted Successfully");
		}
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//td[text() = ' "+p.getProperty("pName")+" ']")).isDisplayed();

		} catch (Exception e) {
			System.out.println("Addition, Edition and Deletion of Product has been successful.");
		}
		
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		
		Thread.sleep(1000);
		driver.close();
		System.out.println("Test Pass");
		
	}
}
