package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class idlocator {
	
	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		
		WebElement inputTextValue= driver.findElement(By.id("twotabsearchtextbox"));
		inputTextValue.sendKeys("laptop");
	}

}
