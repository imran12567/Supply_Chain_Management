package testcase.manufacturer.testng;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.utility.BaseClass;
import generic.utility.PropertyFileUtitlity;
import generic.utility.WebDriverUtility;
import pom.HomePage;
import pom.ManagerAddProductPage;
import pom.ProductEditPage;
import pom.ProductsPage;


public class ST_AddEdDeProduct5_UsingBaseClassTest extends BaseClass {

	@Test(groups = {"regression","smoke"})
	public void addProduct() throws Throwable {
		PropertyFileUtitlity p=new PropertyFileUtitlity();
		WebDriverUtility w=new WebDriverUtility();
		
		HomePage hp = new HomePage(driver);
		hp.getAddProductBtn().click();
		
		ManagerAddProductPage map = new ManagerAddProductPage(driver);
		map.getProNameTxtfld().sendKeys(p.getPropertyValue("pName"));
		map.getProPriceTxtfld().sendKeys(p.getPropertyValue("price"));
		
		WebElement unit = map.getUnitTypeSelectPart();
		w.selectByValue(unit, "2");
		WebElement category = map.getCategorySelectPart();
		w.selectByValue(category, "10");
		map.getStockEnableChkbx().click();
		
		map.getDescriptionTxtfld().sendKeys(p.getPropertyValue("desc"));
		map.getAddProductBtn().click();
		
		
		String addText = driver.switchTo().alert().getText();
		if(addText.contains("Product Added Successfully")) {
			System.out.println("Product Added Successfully");
		}
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		hp.getProductsBtn().click();
		
		ProductsPage pp = new ProductsPage(driver);
		pp.getEditBtn(driver, p.getPropertyValue("pName")).click();
		
		ProductEditPage pep = new ProductEditPage(driver);
		pep.getProPriceTxtfld().sendKeys(Keys.CONTROL+"a");
		pep.getProPriceTxtfld().sendKeys(p.getPropertyValue("price2"));
		Thread.sleep(2000);
		pep.getStockEnableChkbx().click();
		pep.getUpdateProductBtn().click();
		
		String updateText = driver.switchTo().alert().getText();
		if(updateText.contains("Product Updated Successfully")) {
			System.out.println("Product Updated Successfully");
		}
		
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		hp.getProductsBtn().click();
		pp.getProductListChkbox(driver, p.getPropertyValue("pName")).click();
		pp.getDeleteBtn().click();
		String deleteText = driver.switchTo().alert().getText();
		if(deleteText.contains("Products Deleted Successfully")) {
			System.out.println("Products Deleted Successfully");
		}
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		try {
			pp.getEditBtn(driver, p.getPropertyValue("pName")).isDisplayed();

		} catch (Exception e) {
			System.out.println("Addition, Edition and Deletion of Product has been successful.");
		}
		Thread.sleep(1000);
	}
}
