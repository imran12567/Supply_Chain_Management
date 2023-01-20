package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	
public class Ad_HomePage {
	
	
	
	@FindBy (linkText = "Products")
	private WebElement productsBtn;
	
//	@FindAll({@FindBy (linkText = "Products"),@FindBy (linkText = "Products")})
	
	@FindBy (partialLinkText = "Orders")
	private WebElement orderBtn;
	
	
	public WebElement getOrderBtn() {
		return orderBtn;
	}


	public Ad_HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getProductsBtn() {
		return productsBtn;
	}

}
