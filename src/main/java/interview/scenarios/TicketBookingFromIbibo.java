package interview.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TicketBookingFromIbibo {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[.='Round-trip']/../span[@class='sc-jUosCB cKauxs']")).click();
		driver.findElement(By.xpath("(//p[@class='sc-bBHxTw hqJqrJ fswWidgetPlaceholder'])[1]")).sendKeys("ben");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[.='Bengaluru International Airport']")).click();
		driver.findElement(By.xpath("//p[@class='sc-bBHxTw hqJqrJ fswWidgetPlaceholder']")).sendKeys("del");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[.='New Delhi, India']")).click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='Wed Feb 15 2023']")).click();
		driver.findElement(By.xpath("//span[.='Done']")).click();
		driver.findElement(By.xpath("//h2[.='Domestic and International Flights']")).click();
		driver.findElement(By.xpath("//p[.='Click to add a return flight for better discounts']")).click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='Tue Feb 28 2023']")).click();
		driver.findElement(By.xpath("//span[.='Done']")).click();
		driver.findElement(By.xpath("//a[.='Done']")).click();
		driver.findElement(By.xpath("//span[.='SEARCH FLIGHTS']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[.='IndiGo'])[3]/../../../../div[2]/div/div/label")).click();
		driver.findElement(By.xpath("//input[@value='BOOK']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Next']")).click();
		driver.findElement(By.xpath("//button[.='Proceed']")).click();
		Thread.sleep(5000);
		driver.close();
	}

}
