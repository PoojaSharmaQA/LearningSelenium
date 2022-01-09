package myPractice;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JsUtilUses {

	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil javaScriptUtil;
	String Url= "https://www.amazon.in/";
	
	@Before
	public void setup() {
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		wait= new WebDriverWait(driver, 20);
		javaScriptUtil = new JavaScriptUtil();
		
	}
	
	@Test
	public void checkJsUtils()
	{
		WebElement linkTobeClicked= driver.findElement(By.linkText("https://images-eu.ssl-images-amazon.com/images/G/31/img19/2020/PC/Mobile._SY116_CB431401553_.jpg"));
		javaScriptUtil.scrollPageDown();
		javaScriptUtil.clickElementByJs(linkTobeClicked);
		
	}
}
