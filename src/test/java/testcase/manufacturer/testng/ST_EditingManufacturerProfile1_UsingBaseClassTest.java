package testcase.manufacturer.testng;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import generic.utility.BaseClass;
import generic.utility.PropertyFileUtitlity;
import generic.utility.WebDriverUtility;
import pom.EditProfilePage;
import pom.HomePage;

public class ST_EditingManufacturerProfile1_UsingBaseClassTest extends BaseClass {

	@Test (groups = "regression")
	public void editingManufacturerProfile() throws IOException, InterruptedException {
		WebDriverUtility w=new WebDriverUtility();
		PropertyFileUtitlity p=new PropertyFileUtitlity();

		HomePage hp = new HomePage(driver);
		hp.getEditProfileBtn().click();
		
		EditProfilePage e = new EditProfilePage(driver);
		e.getmNameTxtfld().sendKeys(Keys.CONTROL+"a");
		e.getmNameTxtfld().sendKeys(p.getPropertyValue("mName"));
		e.getmEmailTxtfld().sendKeys(Keys.CONTROL+"a");
		e.getmEmailTxtfld().sendKeys(p.getPropertyValue("mEmail"));
		e.getmPhoneTxtfld().sendKeys(Keys.CONTROL+"a");
		e.getmPhoneTxtfld().sendKeys(p.getPropertyValue("mPhone"));
		e.getUpdateProfileBtn().click();
		w.acceptingAlert(driver);
		
		e.getHomeBtn().click();
		
		HomePage h = new HomePage(driver);
		String updatedMName = h.getProfileName(driver).getText();
		
		if(updatedMName.equals(p.getPropertyValue("mName"))) {
			System.out.println("Manufacturer Name has been updated successfully");
		}
		
		h.getLogoutBtn().click();
		
	}
}
