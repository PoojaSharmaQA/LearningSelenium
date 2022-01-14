package myPractice;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.snapdeal.com/");
		
	}

	@Test
	//Navigate to, navigate back, navigate forward, navigate refresh
	public void navigation() {
		driver.navigate().to("https://www.snapdeal.com/products/mens-footwear-sports-shoes?sort=plrty");
	    driver.navigate().back();
	    driver.navigate().forward();
	    driver.navigate().refresh();
	    
	}
	
	@After
	public void tearDown() {
		driver.quit();
		
	}
	}
	

