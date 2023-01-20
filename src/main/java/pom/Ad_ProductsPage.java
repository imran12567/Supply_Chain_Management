package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	
public class Ad_ProductsPage {
	
//	@FindBy (xpath = "//input[@value='Delete']")
//	private WebElement deleteBtn;
//	
//	@FindBy (xpath = "//input[@value='Delete']")
//	private WebElement productListChkbox;
	
	@FindBy (xpath = "//input[@value='Log out']")
	private WebElement logoutBtn;
	
	public Ad_ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public WebElement getProductText(WebDriver driver, String stkName) {
		WebElement productText = driver.findElement(By.xpath("//td[.=' "+stkName+" ']/following-sibling::td[4]"));
		return productText;
	}
	
	public List<WebElement> getAllProductNameFromProductList(WebDriver driver) {
		List<WebElement> allProductNameFromProductList = driver.findElements(By.xpath("//tr/td[3]"));
		return allProductNameFromProductList;
	}
	
//	public WebElement getEditBtn(WebDriver driver, String pName) {
//		WebElement editBtn = driver.findElement(By.xpath("//td[text() = ' "+pName+" ']/../td/a/img[@alt='edit']/.."));
//		return editBtn;
//	}
//	
//	public WebElement getProductListChkbox(WebDriver driver, String pName) {
//		WebElement productListChkbox = driver.findElement(By.xpath("//td[text() = ' "+pName+" ']/../td/input[@name='chkId[]']"));
//		return productListChkbox;
//	}

//	public WebElement getDeleteBtn() {
//		return deleteBtn;
//	}
	
}
