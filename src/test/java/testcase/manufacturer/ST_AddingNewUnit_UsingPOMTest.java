package testcase.manufacturer;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.utility.PropertyFileUtitlity;
import generic.utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.HomePage;
import pom.LoginPage;
import pom.ManageUnitPage;

public class ST_AddingNewUnit_UsingPOMTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
		WebDriverUtility w=new WebDriverUtility();
		w.maximizeWindow(driver);
		w.implicitWait(driver, 10);
		
		PropertyFileUtitlity p=new PropertyFileUtitlity();
		
		LoginPage l=new LoginPage(driver);
		l.loginAsManufacturer(driver);

		HomePage hp = new HomePage(driver);
		hp.getManageUnitBtn().click();
		
		ManageUnitPage u = new ManageUnitPage(driver);
		
		u.getAddUnitBtn().click();
		u.getUnitNameTxtfld().sendKeys(p.getPropertyValue("unit"));
		u.getAddUnitBtn2().click();
		w.acceptingAlert(driver);
		
		hp.getManageUnitBtn().click();
		List<WebElement> allUnitName = u.getAllUnitNameFromUnitList(driver);
		for(WebElement i: allUnitName) {
			String unitName = i.getText();
			if(unitName.contains(p.getPropertyValue("unit"))) {
				System.out.println("Unit is available in the list");
				break;
			}
		}
		
		hp.getLogoutBtn().click();
		Thread.sleep(1000);
		driver.close();
		System.out.println("Test Pass");
		
	}
}
