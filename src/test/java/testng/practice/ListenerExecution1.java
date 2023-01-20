package testng.practice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListenerExecution1 {
	public static WebDriver driver;
//	@Parameters ("browser")
	@Test( /* retryAnalyzer = testng.practice.ListenerImplement.class */)
	public void a() throws Throwable {
//		String browser = "firefox";
//		if(browser.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//		else if(browser.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		driver.get(IPathConstants.url);
//		driver.get("https://www.google.com/");
		Thread.sleep(500);

//		Assert.fail();

		Reporter.log("a", true);
	}

	@Test (groups = {"smoke"})
	public void b() {
		Reporter.log("b", true);
	}

	@Test (groups = {"regression"})
	public void c() {
		Reporter.log("c", true);
		driver.quit();
	}


}
