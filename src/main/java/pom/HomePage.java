package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	
public class HomePage {
	
	@FindBy (xpath = "//a[contains(text(), 'Home')]")
	private WebElement homePageBtn;
	
	public WebElement getHomePageBtn() {
		return homePageBtn;
	}

	@FindBy (xpath = "//a[contains(text(), 'Add Products')]")
	private WebElement addProductBtn;
	
	@FindBy (xpath = "//a[contains(text(), 'Manage Unit')]")
	private WebElement manageUnitBtn;
	
	public WebElement getManageUnitBtn() {
		return manageUnitBtn;
	}

	@FindBy (xpath = "//input[@value='Log out']")
	private WebElement logoutBtn;
	
	@FindBy (partialLinkText = "Products")
	private WebElement productsBtn;
	
	@FindBy (partialLinkText = "Manage Stock")
	private WebElement mngStockBtn;
	
	@FindBy (partialLinkText = "Edit Profile")
	private WebElement editProfileBtn;
	
	public WebElement getEditProfileBtn() {
		return editProfileBtn;
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getMngStockBtn() {
		return mngStockBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getProductsBtn() {
		return productsBtn;
	}
	
	public WebElement getAddProductBtn() {
		return addProductBtn;
	}
	
	public WebElement getProfileName(WebDriver driver) {
		WebElement profileName = driver.findElement(By.xpath("//h2[contains(.,'My Profile')]/../table/tbody/tr[2]/td[1]"));
		return profileName;
	}
	
}
