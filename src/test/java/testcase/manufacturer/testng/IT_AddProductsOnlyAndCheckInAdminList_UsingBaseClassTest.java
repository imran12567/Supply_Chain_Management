package testcase.manufacturer.testng;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.utility.BaseClass;
import generic.utility.PropertyFileUtitlity;
import generic.utility.WebDriverUtility;
import pom.Ad_HomePage;
import pom.Ad_ProductsPage;
import pom.HomePage;
import pom.LoginPage;
import pom.ManagerAddProductPage;

public class IT_AddProductsOnlyAndCheckInAdminList_UsingBaseClassTest extends BaseClass {

	@Test
	public void addProductAndCheckInAdmin() throws IOException, InterruptedException {
		WebDriverUtility w=new WebDriverUtility();
		LoginPage l = new LoginPage(driver);
		PropertyFileUtitlity p = new PropertyFileUtitlity();
		HomePage hp = new HomePage(driver);
		
		hp.getAddProductBtn().click();
		
		ManagerAddProductPage map = new ManagerAddProductPage(driver);
		map.getProNameTxtfld().sendKeys(p.getPropertyValue("pName3"));
		map.getProPriceTxtfld().sendKeys(p.getPropertyValue("price3"));
		
		WebElement unit = map.getUnitTypeSelectPart();
		w.selectByValue(unit, "2");
		WebElement category = map.getCategorySelectPart();
		w.selectByValue(category, "10");
		map.getStockEnableChkbx().click();
		
		map.getDescriptionTxtfld().sendKeys(p.getPropertyValue("desc3"));
		map.getAddProductBtn().click();
		
		
		String addText = driver.switchTo().alert().getText();
		if(addText.contains("Product Added Successfully")) {
			System.out.println("Product Added Successfully");
		}
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		l.logout(driver);
		Thread.sleep(2000);

		l.loginAsAdmin(driver);
		
		Ad_HomePage ah = new Ad_HomePage(driver);
		ah.getProductsBtn().click();
		Thread.sleep(3000);
		
		Ad_ProductsPage adp = new Ad_ProductsPage(driver);
		List<WebElement> allProductName = adp.getAllProductNameFromProductList(driver);
		for(WebElement i: allProductName) {
			String productName = i.getText();
			if(productName.contains(p.getPropertyValue("pName3"))) {
				System.out.println("Product is available in the list");
				break;
			}
		}
		Thread.sleep(1000);
		l.loginAsManufacturer(driver);
		Thread.sleep(1000);
		
	}
}
