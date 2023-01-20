package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	
public class ProductsPage {
	
	@FindBy (xpath = "//input[@value='Delete']")
	private WebElement deleteBtn;
	
	@FindBy (xpath = "//input[@value='Delete']")
	private WebElement productListChkbox;
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getEditBtn(WebDriver driver, String pName) {
		WebElement editBtn = driver.findElement(By.xpath("//td[text() = ' "+pName+" ']/../td/a/img[@alt='edit']/.."));
		return editBtn;
	}
	
	public WebElement getProductListChkbox(WebDriver driver, String pName) {
		WebElement productListChkbox = driver.findElement(By.xpath("//td[text() = ' "+pName+" ']/../td/input[@name='chkId[]']"));
		return productListChkbox;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
}
