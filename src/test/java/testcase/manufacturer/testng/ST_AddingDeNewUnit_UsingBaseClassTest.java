package testcase.manufacturer.testng;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.utility.BaseClass;
import generic.utility.PropertyFileUtitlity;
import generic.utility.WebDriverUtility;
import pom.HomePage;
import pom.ManageUnitPage;

public class ST_AddingDeNewUnit_UsingBaseClassTest extends BaseClass {
	
	@Test(groups = "smoke")
	public void addingNewUnit() throws Throwable {
		
		WebDriverUtility w = new WebDriverUtility();
		PropertyFileUtitlity p = new PropertyFileUtitlity();
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
		u.getUnitSelectionCheckbox(driver).click();
		u.getDeleteBtn().click();
		w.acceptingAlert(driver);
	}
}
