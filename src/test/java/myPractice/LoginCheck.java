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

public class LoginCheck {

	WebDriver driver;
	
	@Before 
	public void setup()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	
	@Test 
	public void login()
	{ 
		WebElement emailAddress=driver.findElement(By.id("email"));
		emailAddress.sendKeys("poojasharma7990@gmail.com");
		
		WebElement pass=driver.findElement(By.xpath("//input[@id='pass']"));
		pass.sendKeys("PPooja@5");
		
		WebElement logIn= driver.findElement(By.xpath("//button[@name='login']"));
		logIn.click();
		

			
	}

	@Test
	
	public void testUrl()
	{
		String actualUrl="https://www.facebook.com/";
		Assert.assertEquals(actualUrl,driver.getCurrentUrl());
	}
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		
		
		
	}


}
