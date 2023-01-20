package com.scm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tyss_RMGTestingServer {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block text-uppercase']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Projects')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Create Project')]/..")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//h4[contains(text(),'Create Project')]/../../div/div//input[@name='projectName']")).sendKeys("scm12568");
		driver.findElement(By.xpath("//h4[contains(text(),'Create Project')]/../../div/div//input[@name='createdBy']")).sendKeys("scm12570");
		WebElement status = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s=new Select(status);
		s.selectByIndex(1);
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.close();
		System.out.println("Test Pass");
	}
}
