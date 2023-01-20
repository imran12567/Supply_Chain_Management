package testcase.manufacturer;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import generic.utility.PropertyFileUtitlity;
import generic.utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Ad_HomePage;
import pom.Ad_ProductsPage;
import pom.HomePage;
import pom.LoginPage;
import pom.ManagerAddProductPage;

public class ST_AddProductsOnlyAndCheckInAdminList_UsingPOMTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		WebDriverUtility w=new WebDriverUtility();
		driver.manage().window().maximize();
		w.implicitWait(driver, 10);
		
		PropertyFileUtitlity p = new PropertyFileUtitlity();
		driver.get(p.getPropertyValue("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getUserNameTxtfld().sendKeys(p.getPropertyValue("un"));

		lp.getPwdTxtfld().sendKeys(p.getPropertyValue("pwd"));

		WebElement selectType = lp.getSelectType();
		Select s = new Select(selectType);
		s.selectByValue("manufacturer");
		Thread.sleep(1000);

		lp.getLoginBtn().click();
		Thread.sleep(2000);
		
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
		
		lp.logout(driver);
		Thread.sleep(2000);

		lp.loginAsAdmin(driver);
		
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

		hp.getLogoutBtn().click();
		
		Thread.sleep(1000);
		driver.close();
		System.out.println("Test Pass");
		
	}
}
