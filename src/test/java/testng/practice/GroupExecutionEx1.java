package testng.practice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.utility.IPathConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners (testng.practice.ListenerImplement.class)
public class GroupExecutionEx1 {
	public static WebDriver driver;
//	@Parameters ("browser")
	@Test ( groups = {"smoke", "regression", "both"})
	public void a() throws Throwable {
		String browser = "firefox";
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

		Assert.fail();
		Thread.sleep(2000);

		Reporter.log("a", true);
	}

	@Test (groups = {"smoke"})
	public void b() {
		Reporter.log("b", true);
	}

	@Test (groups = {"regression"})
	public void c() {
		Reporter.log("c", true);
		driver.close();
	}


}
