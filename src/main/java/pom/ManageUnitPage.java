package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utility.PropertyFileUtitlity;

public class ManageUnitPage {

	
	
	@FindBy (xpath = "//input[@value='+ Add Unit']")
	private WebElement addUnitBtn;
	
	@FindBy (xpath = "//input[@value='Delete']")
	private WebElement deleteBtn;
	
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getAddUnitBtn() {
		return addUnitBtn;
	}

	public WebElement getUnitNameTxtfld() {
		return unitNameTxtfld;
	}

	public WebElement getAddUnitBtn2() {
		return addUnitBtn2;
	}
	
	



	@FindBy (xpath = "//input[@name='txtUnitName']")
	private WebElement unitNameTxtfld;
	
	@FindBy (xpath = "//input[@value='Add Unit']")
	private WebElement addUnitBtn2;
	
	@FindBy (xpath = "//input[@value='Log out']")
	private WebElement logoutBtn;
	
	public ManageUnitPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}


	
	public List<WebElement> getAllUnitNameFromUnitList(WebDriver driver) {
		List<WebElement> allUnitNameFromUnitList = driver.findElements(By.xpath("//tr/td[3]"));
		return allUnitNameFromUnitList;
	}
	
	public WebElement getUnitSelectionCheckbox(WebDriver driver) throws Throwable {
		PropertyFileUtitlity p = new PropertyFileUtitlity();
		WebElement checkbox = driver.findElement(By.xpath("//td[.=' "+p.getPropertyValue("unit")+" ']/..//input[@name='chkId[]']"));
		return checkbox;
	}
	
}
