package myPractice;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	
	WebDriver driver;
	
	@Before
	
	public void setup() {
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.opencart.com/index.php?route=account/register");
	}
	
	
	@Test
	//Select value by Visible Text
	public void dropDownByVisibleText() {
		
		WebElement countryName = driver.findElement(By.xpath("//select[@id='input-country']"));
		
		Select cnName= new Select (countryName);
		cnName.selectByVisibleText("Antarctica");
		
	}
	
	@Test
	//Select by SelectByValue() method
	public void dropDownSelectByValue() {
		WebElement cName = driver.findElement(By.xpath("//select[@id='input-country']"));
		
		Select countryName= new Select(cName);
		countryName.selectByValue("54");//cuba
	}
	
	@Test
	//Select by selectByIndex() method
	public void dropDownSelectByIndex() {
		
		WebElement cName = driver.findElement(By.xpath("//select[@id='input-country']"));
		Select countryName = new Select (cName);
		countryName.selectByIndex(12);// Aruba
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		
	}
		
	}
	
	
	


