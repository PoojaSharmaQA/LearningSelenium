package myPractice;

import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragDropWithiFrame {
	
	WebDriver driver;
	WebDriverWait wait;

	
	@Before
	public void setup() {
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		wait= new WebDriverWait(driver,15);
	}

	@Test
	public void checkdragDrop()
	
	{
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		WebElement dropHere= driver.findElement(By.xpath("//div[@id='droppable']"));
		wait= new WebDriverWait(driver, 20);
		Actions act= new Actions(driver);
		act.dragAndDrop(dragMe, dropHere).build().perform();

	}
	
	@After
	
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	}

