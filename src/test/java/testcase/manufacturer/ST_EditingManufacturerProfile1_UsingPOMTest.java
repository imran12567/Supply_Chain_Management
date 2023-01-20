package testcase.manufacturer;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.utility.PropertyFileUtitlity;
import generic.utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.EditProfilePage;
import pom.HomePage;
import pom.LoginPage;

public class ST_EditingManufacturerProfile1_UsingPOMTest {

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
		Thread.sleep(1000);
		driver.close();
		System.out.println("Test Pass");
		
	}
}
