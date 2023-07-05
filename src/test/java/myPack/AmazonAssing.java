package myPack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonAssing {
	WebDriver driver;
	@BeforeTest
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
	}
	@Test
	void testScript() {
		 WebElement element = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
		 element.sendKeys("Wrist Watches");
		 element.submit();
		 int y = driver.findElement(By.xpath("//span[.='Watch Display Type']")).getLocation().getY();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,"+y+")");
		 driver.findElement(By.xpath("//span[.='Analogue']")).click();
		 int y1 = driver.findElement(By.xpath("//span[.='Band Material']")).getLocation().getY();
		 js.executeScript("window.scrollBy(0,"+y1+")");
		 driver.findElement(By.xpath("//span[.='Leather']")).click();
		 driver.findElement(By.xpath("//ul//span[.='Titan']")).click();
		 int y2= driver.findElement(By.xpath("//span[.='Discount']")).getLocation().getY();
		 js.executeScript("window.scrollBy(0,"+y2+")");
		 driver.findElement(By.xpath("//span[.='25% Off or more']")).click();
		 driver.findElement(By.xpath("//span[contains(text(),\"Analog Men's Watch (Dial Colored Strap)\")]")).click();
		 System.out.println("Person y comment");
		 
	}
	void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
	}

}
