package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	
public class EditProfilePage {

	@FindBy (id = "manufacturer:name")
	private WebElement mNameTxtfld;
	
	@FindBy (id = "manufacturer:email")
	private WebElement mEmailTxtfld;
	
	@FindBy (id = "manufacturer:phone")
	private WebElement mPhoneTxtfld;
	
	@FindBy (xpath = "//input[@value='Change Password']")
	private WebElement chngPwdBtn;
	
	@FindBy (xpath = "//input[@value='Update Profile']")
	private WebElement updateProfileBtn;
	
	@FindBy (partialLinkText = "Home")
	private WebElement homeBtn;
	
	public WebElement getmNameTxtfld() {
		return mNameTxtfld;
	}

	public WebElement getmEmailTxtfld() {
		return mEmailTxtfld;
	}

	public WebElement getmPhoneTxtfld() {
		return mPhoneTxtfld;
	}

	public WebElement getChngPwdBtn() {
		return chngPwdBtn;
	}

	public WebElement getUpdateProfileBtn() {
		return updateProfileBtn;
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public EditProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
