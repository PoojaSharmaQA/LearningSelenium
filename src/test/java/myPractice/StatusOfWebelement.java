package myPractice;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class StatusOfWebelement {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
	}
	
	@Test
	//Checking Login Button is Enabled 
    public void webelementStatus() {
		WebElement loginButton=driver.findElement(By.xpath("//a[text()='Login']"));
		if(loginButton.isEnabled())
		{
			Assert.assertTrue(true);
			System.out.println("Login Button is enabled");
		}
		else
		{
			Assert.assertFalse(false);
			System.out.println("Login Button is disabled");
			
		}
	}
		
	@ Test
	//Checking Grocery Button is displayed or not
	public void buttonDisplay() {
		WebElement groceryButton = driver.findElement(By.xpath("//div[text()= 'Grocery']"));
		
		if(groceryButton.isDisplayed());
		{
			Assert.assertTrue(true);
			System.out.println("Grocery Button is displayed");
		}
				
		
	}
	
	
   @After
   
   public void tearDown() throws InterruptedException {
	   Thread.sleep(3000);
	   driver.quit();
	   
   }
	   
}
		
		
	


