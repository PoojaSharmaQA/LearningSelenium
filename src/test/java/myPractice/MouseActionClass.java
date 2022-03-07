package myPractice;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActionClass {
	
	WebDriver driver;
	WebDriver wait;
	
	@Before
	public void setup() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
	}
	
	@Test
	// Click on a WebElement using Action Class
	public void mouseClick() {
		
		driver.get("https://www.amazon.in/");
		WebElement babyButton= driver.findElement(By.xpath("//a[normalize-space()='Baby']"));
		Actions act= new Actions(driver);
		act.click(babyButton).build().perform();
	}
	
	@Test
	// double click on WebElement using Action Class
	public void doubleClick() {
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.switchTo().frame("iframeResult");
		WebElement frame1=driver.findElement(By.xpath("//input[@id='field1']"));
		frame1.clear();
		frame1.sendKeys("I Will Win");
		WebElement copyTextButton= driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
		Actions act=new Actions(driver);
		act.doubleClick(copyTextButton).build().perform();
		
			
	}
	
	@Test
	//Right Click using Action Class
	public void rightClick() {
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightClickMeButton= driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions act=new Actions(driver);
		act.contextClick(rightClickMeButton).build().perform();
	}
	
	@Test
	//Drag and drop using Action Class
	public void dragAndDropAction() {
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");	
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		WebElement img1= driver.findElement(By.xpath("//li[1]"));
		WebElement trash= driver.findElement(By.xpath("//div[@id='trash']"));
		Actions act= new Actions(driver);
		act.clickAndHold(img1).moveToElement(trash).build().perform();
		//act.dragAndDrop(img1,trash).build().perform();
		
		
	}
	
	@Test
	public void mouseHoverAction() {
		driver.get("https://demo.opencart.com/");
		WebElement mp3Players = driver.findElement(By.xpath("//a[normalize-space()='MP3 Players']"));
		WebElement test20=driver.findElement(By.xpath("//div[@class='dropdown-inner']//ul[@class='list-unstyled']//li//a[text()='test 20 (0)']"));
		Actions act=new Actions(driver);
		act.moveToElement(mp3Players).moveToElement(test20).click().build().perform();
		
		
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}
	

}
