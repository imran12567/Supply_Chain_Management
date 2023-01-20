package pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import generic.utility.PropertyFileUtitlity;
	
public class LoginPage {
	
	@FindBy (id = "login:username")
	private WebElement userNameTxtfld;
	
	@FindBy (id = "login:password")
	private WebElement pwdTxtfld;
	
	@FindBy (id = "login:type")
	private WebElement selectType;
	
	@FindBy (className = "submit_button")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUserNameTxtfld() {
		return userNameTxtfld;
	}
	public WebElement getPwdTxtfld() {
		return pwdTxtfld;
	}
	public WebElement getSelectType() {
		return selectType;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginAsManufacturer(WebDriver driver) throws IOException, InterruptedException {
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
	}
	
	public void loginAsAdmin(WebDriver driver) throws IOException, InterruptedException {
		PropertyFileUtitlity p = new PropertyFileUtitlity();
		driver.get(p.getPropertyValue("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getUserNameTxtfld().sendKeys(p.getPropertyValue("un"));

		lp.getPwdTxtfld().sendKeys(p.getPropertyValue("pwd"));

		WebElement selectType = lp.getSelectType();
		Select s = new Select(selectType);
		s.selectByValue("admin");
		Thread.sleep(1000);
		lp.getLoginBtn().click();
		Thread.sleep(2000);
	}
	
	public void loginAsRetailer(WebDriver driver) throws IOException, InterruptedException {
		PropertyFileUtitlity p = new PropertyFileUtitlity();
		driver.get(p.getPropertyValue("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getUserNameTxtfld().sendKeys(p.getPropertyValue("un"));

		lp.getPwdTxtfld().sendKeys(p.getPropertyValue("pwd"));

		WebElement selectType = lp.getSelectType();
		Select s = new Select(selectType);
		s.selectByValue("retailer");
		Thread.sleep(1000);
		lp.getLoginBtn().click();
		Thread.sleep(2000);
	}
	public void logout(WebDriver driver) throws IOException, InterruptedException {
		HomePage h=new HomePage(driver);
		h.getHomePageBtn().click();
		h.getLogoutBtn().click();
//		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		Thread.sleep(2000);
}
}
