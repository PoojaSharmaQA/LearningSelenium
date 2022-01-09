package myPractice;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class TextBox {
	
	WebDriver driver;
	
	@Before
	public void setup()
	{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://demoqa.com/text-box");
				
	}
	
	@Test
	public void textboxcheck()
	{
		WebElement fullName= driver.findElement(By.xpath("//input[@id='userName']"));
		fullName.sendKeys("Pooja Sharma");
		
		WebElement email= driver.findElement(By.xpath("//input[@id='userEmail']"));
		email.sendKeys("poojasharma7990@gmail.com");
		
		WebElement currAdd= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		currAdd.sendKeys("XYZ");	
		
		WebElement parmAdd= driver.findElement(By.id("permanentAddress"));
		parmAdd.sendKeys("PQRS");
		
		WebElement submit= driver.findElement(By.xpath("//button[text()='Submit']"));
		submit.submit();
		
		
	
	}
//	@Test
//	public void checkDetails()
//	{
//		String actualName="Pooja Sharma";
//		String expectedName="driver.getName()";
//		Assert.assertEquals(actualName, expectedName);
//		
//	}

	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		
		
	}
	}
	

