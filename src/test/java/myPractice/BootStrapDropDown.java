package myPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class BootStrapDropDown {

	WebDriver driver;
	
	@Before
	public void setup() {
		
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.hdfcbank.com/");
		
	}
	
	@Test
	public void bootStrapDropDown1() {
	// For Select Product Type	
		
	//Alert alert=driver.switchTo().alert();
	//alert.accept();
	driver.findElement(By.xpath("//div[@class='drp1']//div[@class ='dropdown']")).click();
	List <WebElement> productType= driver.findElements(By.xpath("//div[@class='dropdown']//ul[@class='dropdown1 dropdown-menu']/li"));
	selectDropDown(productType,"Cards");
	//For Select Product
	driver.findElement(By.xpath("//div[@class= 'drp2']//div[@class='dropdown']")).click();
	List <WebElement> product=driver.findElements(By.xpath("//div[@class='dropdown']//ul[@class='dropdown2 dropdown-menu']//li"));
	selectDropDown(product, "Debit Cards");
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		
	}
	
	public static void selectDropDown(List <WebElement> options, String value) {
		
		for(WebElement option: options)
			
		{
			if(option.getText().equalsIgnoreCase(value))
			{
				option.click();
				break;
			}
		}
	}
			
		
		
	
	}
	

