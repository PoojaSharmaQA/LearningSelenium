package readPropertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadProperties {
	
	public Properties prop;
	WebDriver driver;
	
	@Test
	public void readPropFile() {
		
		prop= new Properties();
		
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/learningSelenium/src/test/java/readPropertiesFile/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
		    System.out.println("Property File is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception occur while loading properties file");
			e.printStackTrace();	
		}
		
		System.out.println(prop.getProperty("URL"));
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("headless"));
		System.out.println(prop.getProperty("maximize"));
		System.out.println(prop.getProperty("UserFirstName"));
		System.out.println(prop.getProperty("UserLastName"));
		
		
		driver= new ChromeDriver();
	
		if(prop.getProperty("maximize").equalsIgnoreCase("yes"))
		{
			driver.manage().window().maximize();
		}
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@name = 'q']"));
		searchBox.sendKeys("Hello");
		
		WebElement searchButton= driver.findElement(By.xpath("//input[@name = 'btnK']"));
		searchButton.click();
		
		driver.quit();
		
				
		
		
	
		}
		
		
	}
	


