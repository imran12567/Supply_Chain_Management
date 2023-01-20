package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerAddProductPage {
	@FindBy (name = "txtProductName")
	private WebElement proNameTxtfld;
	
	@FindBy (name = "txtProductPrice")
	private WebElement proPriceTxtfld;
	
	@FindBy (name = "cmbProductUnit")
	private WebElement unitTypeSelectPart;
	
	@FindBy (name = "cmbProductCategory")
	private WebElement categorySelectPart;
	
	@FindBy (xpath = "//input[@name='rdbStock' and @value='1']")
	private WebElement stockEnableChkbx;
	
	@FindBy (xpath = "//input[@name='rdbStock' and @value='2']")
	private WebElement stockDisableChkbx;
	
	@FindBy (name = "txtProductDescription")
	private WebElement descriptionTxtfld;
	
	@FindBy (xpath = "//input[@value='Add Product']")
	private WebElement addProductBtn;
	
	public ManagerAddProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getProNameTxtfld() {
		return proNameTxtfld;
	}
	public WebElement getProPriceTxtfld() {
		return proPriceTxtfld;
	}
	
	public WebElement getUnitTypeSelectPart() {
		return unitTypeSelectPart;
	}

	public WebElement getCategorySelectPart() {
		return categorySelectPart;
	}

	public WebElement getStockEnableChkbx() {
		return stockEnableChkbx;
	}

	public WebElement getStockDisableChkbx() {
		return stockDisableChkbx;
	}

	public WebElement getDescriptionTxtfld() {
		return descriptionTxtfld;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	
}
