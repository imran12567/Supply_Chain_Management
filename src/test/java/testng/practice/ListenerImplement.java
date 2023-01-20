package testng.practice;



import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplement implements ITestListener/* , IRetryAnalyzer */ { 
	ExtentReports report;
	ExtentTest test;

	/*
	 * int count = 0; int retryLimit = 2; public boolean retry(ITestResult result) {
	 * if(count<retryLimit) { count++; return true; } return false; }
	 */
	public void onTestStart(ITestResult result) {

//		test = report.createTest(result.getName()).info("Test Started");
		test = report.createTest(result.getName());
		Reporter.log("Test Started", true);
	}


	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, result.getName()+"--> Passed");

	}

	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		Random random = new Random();
		int r = random.nextInt(100);
		LocalDate da = LocalDate.now();

		EventFiringWebDriver t = new EventFiringWebDriver(GroupExecutionEx1.driver);
		//		TakesScreenshot t=(TakesScreenshot) GroupExecutionEx1.driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+name+""+da+""+r+".png");
		//		Files.copy(src, dest);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		test.addScreenCaptureFromPath(dest.getAbsolutePath());
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("Test Failed");
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getName()+" --Skipped--");
	}


	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/report.html");//1
		htmlReport.config().setDocumentTitle("SDET-45 Test Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("SCM Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);//2
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-URL", "https://localhost:8888/");
		report.setSystemInfo("Reporter Name", "Imran");

	}

	public void onFinish(ITestContext context) {
				report.flush();
	}	
}
