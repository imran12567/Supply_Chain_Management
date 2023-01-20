package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageStockPage {

	
	
	@FindBy (xpath = "//input[@value='Update Stock']")
	private WebElement updateStockBtn;
	
	@FindBy (xpath = "//input[@value='Log out']")
	private WebElement logoutBtn;
	
	public ManageStockPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getUpdateStockBtn() {
		return updateStockBtn;
	}

	
	public WebElement getEditTxtfld(WebDriver driver, String nameForStock) {
		WebElement editTxtfld = driver.findElement(By.xpath("//td[.='"+nameForStock+"']/following-sibling::td/input"));
		return editTxtfld;
	}
}
