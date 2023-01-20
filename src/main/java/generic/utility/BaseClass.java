package generic.utility;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.LoginPage;

public class BaseClass  {
	DatabaseUtility d=new DatabaseUtility();
	ExcelUtility e = new ExcelUtility();
	PropertyFileUtitlity p = new PropertyFileUtitlity();
	JavaUtility j=new JavaUtility();
	WebDriverUtility w=new WebDriverUtility();
	
	public static WebDriver driver;
	
	@BeforeSuite (alwaysRun = true)
	public void connectToDatabase() throws Throwable {
//		d.connectToDB(IPathConstants.dbUrl);
		Reporter.log("connectToDatabase", true);
	}
	@Parameters("browser")
	@BeforeClass (alwaysRun = true)
	public void openTheBrowser() throws Throwable {
		
		if(p.getPropertyValue("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(p.getPropertyValue("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver =  new FirefoxDriver();
		}
		else if(p.getPropertyValue("browser").equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		Reporter.log("openTheBrowser", true);

	}
	@BeforeMethod (alwaysRun = true)
	public void login() throws Throwable {
		w.maximizeWindow(driver);
		w.implicitWait(driver, 10);
		LoginPage l=new LoginPage(driver);
		l.loginAsManufacturer(driver);
		Reporter.log("login", true);

	}
	
	@AfterMethod (alwaysRun = true)
	public void logout() throws IOException, InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.logout(driver);
		Reporter.log("logout", true);
	}
	@AfterClass (alwaysRun = true)
	public void closingBrowser() {
		driver.close();
		Reporter.log("closingBrowser", true);

	}
	@AfterSuite (alwaysRun = true)
	public void closingDB() throws Throwable {
//		d.closingTheDB();
		Reporter.log("closingDB", true);

	}
	
}
