package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoFlipkart {
	WebDriver driver;
	WebDriverWait mywait;
	@BeforeTest
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
	}
	@Test
	void tesScript() {
		try {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='✕']")));
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		}
		catch(Exception e) {
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='✕']")));
			driver.findElement(By.xpath("//button[text()='✕']")).click();
		}
		driver.findElement(By.name("q")).sendKeys("iphone14");
		List<WebElement> allOption= driver.findElements(By.xpath("//form[@class='_2M8cLY header-form-search']/child::ul//li"));
		for(WebElement opt:allOption) {
			String text= opt.getText();
			System.out.println(text);
//			if(text.equalsIgnoreCase("iphone 14"))
//				opt.click();
		
		}
	}
	@AfterTest
	void tearDown() {
		//driver.close();
	}

}
