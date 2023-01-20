package testcase.manufacturer.testng;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import generic.utility.BaseClass;
import generic.utility.PropertyFileUtitlity;
import pom.Ad_ProductsPage;
import pom.HomePage;
import pom.LoginPage;
import pom.ManageStockPage;

public class IT_UpdatingQuantityOfProduct20_UsingBaseClassTest extends BaseClass {

	@Test
	public void updatingQuantityOfProduct(String[] args) throws IOException, InterruptedException {
		PropertyFileUtitlity p=new PropertyFileUtitlity();
		HomePage hp = new HomePage(driver);
		LoginPage l = new LoginPage(driver);
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
		l.loginAsManufacturer(driver);
		
	}
}
