package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductEditPage {
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
	
	@FindBy (xpath = "//input[@value='Update Product']")
	private WebElement updateProductBtn;
	
	public ProductEditPage(WebDriver driver) {
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

	public WebElement getUpdateProductBtn() {
		return updateProductBtn;
	}
	
	public List<WebElement> getAllProductNameFromProductList(WebDriver driver) {
		List<WebElement> allProductNameFromProductList = driver.findElements(By.xpath("//tr/td[3]"));
		return allProductNameFromProductList;
	}
	
}
