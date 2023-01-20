package testcase.manufacturer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ST1_AddProduct1_Test {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\commondata.property");
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
		Select s2 = new Select(unit);
		s2.selectByValue("2");
		WebElement category = driver.findElement(By.id("product:category"));
		Select s3 = new Select(category);
		s3.selectByValue("10");
//		s3.selectByVisibleText(" Cakes ");
		
		driver.findElement(By.name("rdbStock")).click();
		
		driver.findElement(By.id("product:description")).sendKeys(p.getProperty("desc"));
		driver.findElement(By.xpath("//input[@value='Add Product']")).click();
		
		String addText = driver.switchTo().alert().getText();
		if(addText.contains("Product Added Successfully")) {
			System.out.println("Product Added Successfully");
		}
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		
		driver.findElement(By.partialLinkText("Products")).click();
		driver.findElement(By.xpath("//td[text() = ' "+p.getProperty("pName")+" ']/../td/a/img[@alt='edit']/..")).click();
//		driver.findElement(By.id("product:price")).sendKeys(Keys.CONTROL+"a"+p.getProperty("price2"));
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
		Thread.sleep(3000);

		driver.findElement(By.partialLinkText("Products")).click();
		driver.findElement(By.xpath("//td[text() = ' "+p.getProperty("pName")+" ']/../td/input[@name='chkId[]']")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		String deleteText = driver.switchTo().alert().getText();
		if(deleteText.contains("Products Deleted Successfully")) {
			System.out.println("Products Deleted Successfully");
		}
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
//		boolean displayed = driver.findElement(By.xpath("//td[text() = ' "+p.getProperty("pName")+" ']")).isDisplayed();
//		if(displayed==false) {
//			System.out.println("Addition, Edition and Deletion of Product has been successful.");
//		}
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		
		Thread.sleep(2000);
		driver.close();
		System.out.println("Test Pass");
		
	}
}
