package myPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
//	@Test
//	public void windowHandleByIterator() {
//		
//		driver.findElement(By.xpath(" //img[@alt='OrangeHRM on Facebook']")).click();
//		//String windowId= driver.getWindowHandle();// Gives the id of single browser Window
//		
//		Set<String> windowIds= driver.getWindowHandles();// get set of IDs of all browser windows
//		Iterator<String> it= windowIds.iterator();
//		
//		String parentWindowId= it.next();
//		String childWindowId= it.next();
//		
//		System.out.println("Parent Window Id is "+ parentWindowId);
//		System.out.println("Child Window Id is "+ childWindowId);
//	
//	
//	}
//	
//	@Test
//	public void windowHandlesByArrayList() {
//		
//		driver.findElement(By.xpath(" //img[@alt='OrangeHRM on Facebook']")).click();
//		Set<String> windowIDs= driver.getWindowHandles();
//		List<String> windowIDsList= new ArrayList(windowIDs); //converting Set of windowIDs into List
//		String parentWindowID= windowIDsList.get(0);
//		String childWindowID= windowIDsList.get(1);
//		System.out.println("Parent Window Id is "+ parentWindowID);
//		System.out.println("Child Window Id is "+ childWindowID);
//		
//	}
//	
	@Test
	// how to use window ID's for switching
	public void windowHandles() {
		driver.findElement(By.xpath(" //img[@alt='OrangeHRM on Facebook']")).click();
		Set<String> windowIDs= driver.getWindowHandles();
		Iterator<String> it=windowIDs.iterator();
		
		String parentWindowID= it.next();
		String childWindowID=it.next();
		
		driver.switchTo().window(parentWindowID);
		System.out.println("Title of Parent Window is " + driver.getTitle());
		
		driver.switchTo().window(childWindowID);
		System.out.println("Title of Child Window is " + driver.getTitle());
		
		
			
		}
	
//	@Test
//	// how to switch windows using for loop
//	public void windowHandlesSwitchByForLoop() {
//		driver.findElement(By.xpath(" //img[@alt='OrangeHRM on Facebook']")).click();
//		Set<String> windowIDs= driver.getWindowHandles();
//		List<String> windowIDList= new ArrayList(windowIDs);
//		
//		for(String windowID: windowIDList)
//		{
//			String title= driver.switchTo().window(windowID).getTitle();
//			System.out.println(title);
//		}
//		
//	}
	
	@After
	public void tearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.quit();// it will close multiple windows
		//driver.close(); // it will close current window only
		
		
	}
	// we can close the windows by choice using window titles
		
		
	}


