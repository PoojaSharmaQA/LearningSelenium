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
import org.openqa.selenium.support.ui.Select;

public class DropDownWithoutSelect {
	
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
	//Select from dropDown without Select Class
	public void dropDownWithoutSelect() {
		
	WebElement countryName= driver.findElement(By.xpath("//select[@id='input-country']"));
	
	Select ctryName = new Select(countryName);
	
	List<WebElement> allOptions= ctryName.getOptions();
	
	
	for(WebElement CN: allOptions)
	{
		if(CN.getText().equalsIgnoreCase("Australia"))
		{
			CN.click();
		}
	}
	
	}
	
	
	@After
	public void tearDown() {
		
		driver.quit();
		
	}
	}

}
