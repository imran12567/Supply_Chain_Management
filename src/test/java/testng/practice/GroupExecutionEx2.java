package testng.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generic.utility.IPathConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GroupExecutionEx2 {

	WebDriver driver = null;
	@Parameters ("browser")
	@Test (groups = {"smoke", "regression"})
	public void d(String browser) throws Throwable {
		if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.get(IPathConstants.url);
		Thread.sleep(2000);
		Reporter.log("d", true);

	}

	@Test (groups = {"smoke"})
	public void e() {
		Reporter.log("e", true);
	}

	@Test (groups = {"regression"})
	public void f() {
		Reporter.log("f", true);
		driver.close();
	}


}
