package myPractice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TakeScreenshot {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		wait= new WebDriverWait(driver, 20);
		
	}
	
	@Test
	public void mobileSearch() throws IOException {
		WebElement SearchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		SearchBox.sendKeys("Mobile");
		
		WebElement Submit= driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		Submit.click();
		
		//wait.until(ExpectedConditions.titleContains("Mobile"));
		screenshotPic(driver,"mobile");
		
	}
	
	@After
	
	public void teardown() throws InterruptedException {
		//Thread.sleep(3000);
		driver.quit();
		
	}
	
	public static void screenshotPic(WebDriver driver, String fileName) throws IOException
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    //FileUtils.copyFile(file, new File(System.getProperty("user.dir")+ "\\learningSelenium\\src\\test\\java\\screenshot"+ fileName +System.currentTimeMillis()+".jpg"));
		FileUtils.copyFile(file, new File( "C:\\Users\\sanju\\eclipse-workspace\\learningSelenium\\src\\test\\java\\screenshot"+ fileName +System.currentTimeMillis()+".jpg"));
	}
	
	
		
}
		
		
		
		
		
	

	
	
	


