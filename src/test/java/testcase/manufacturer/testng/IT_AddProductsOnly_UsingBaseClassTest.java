package testcase.manufacturer.testng;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.utility.BaseClass;
import generic.utility.PropertyFileUtitlity;
import generic.utility.WebDriverUtility;
import pom.HomePage;
import pom.ManagerAddProductPage;
import pom.ProductEditPage;

public class IT_AddProductsOnly_UsingBaseClassTest extends BaseClass {

	@Test
	public void addProductsOnly() throws IOException, InterruptedException {
		WebDriverUtility w=new WebDriverUtility();
		PropertyFileUtitlity p = new PropertyFileUtitlity();
		HomePage hp = new HomePage(driver);
		ManagerAddProductPage map = new ManagerAddProductPage(driver);

		hp.getAddProductBtn().click();
		
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
		
		
		hp.getProductsBtn().click();
		
		ProductEditPage pe = new ProductEditPage(driver);
		List<WebElement> allProductName = pe.getAllProductNameFromProductList(driver);
		for(WebElement i: allProductName) {
			String productName = i.getText();
			if(productName.equals(p.getPropertyValue("pName3"))) {
				System.out.println("Product is available in the list");
				break;
			}
		}		
	}
}
