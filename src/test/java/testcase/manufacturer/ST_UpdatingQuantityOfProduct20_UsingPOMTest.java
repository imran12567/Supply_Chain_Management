package testcase.manufacturer;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.utility.PropertyFileUtitlity;
import generic.utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Ad_ProductsPage;
import pom.HomePage;
import pom.LoginPage;
import pom.ManageStockPage;

public class ST_UpdatingQuantityOfProduct20_UsingPOMTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		WebDriverUtility w=new WebDriverUtility();
		w.implicitWait(driver, 10);
		
		PropertyFileUtitlity p=new PropertyFileUtitlity();
		
		// Login as Manufacturer
		LoginPage l=new LoginPage(driver);
		l.loginAsManufacturer(driver);

		
		
		HomePage hp = new HomePage(driver);
		hp.getMngStockBtn().click();
		
		ManageStockPage m = new ManageStockPage(driver);
		m.getEditTxtfld(driver, p.getPropertyValue("nameForStock")).sendKeys(Keys.CONTROL+"a");
		m.getEditTxtfld(driver, p.getPropertyValue("nameForStock")).sendKeys(p.getPropertyValue("quantity"));
		m.getUpdateStockBtn().click();
		driver.switchTo().alert().accept();
		m.getLogoutBtn();
		Thread.sleep(2000);
		
		l.loginAsAdmin(driver);

		hp.getProductsBtn().click();
		Ad_ProductsPage ap = new Ad_ProductsPage(driver);
		String updatedNumber = ap.getProductText(driver, p.getPropertyValue("nameForStock")).getText();
		
		if(updatedNumber.contains(p.getPropertyValue("quantity"))) {
			System.out.println("Quantity of the product has been updated");
		}
		Thread.sleep(1000);
		
		ap.getLogoutBtn().click();
		Thread.sleep(1000);
		driver.close();
		System.out.println("Test Pass");
		
	}
}
