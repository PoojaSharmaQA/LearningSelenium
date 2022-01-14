package myPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementVsFindElements {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}

	@Test
	public void checkingElements() {
		List <WebElement> links= driver.findElements(By.xpath("//div[@role='presentation']//div[3]//a"));
		
		for(WebElement X : links)
		{
			System.out.println(X.getText());
		}
	}
	
		@After
		public void tearDown() {
			driver.quit();
			
		}
	
	}

