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

public class HandleCheckBoxes {

	WebDriver driver;
	
	@Before
	public void setup() {
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		
	}
	
	@Test
	//Select All Check Boxes
	public void selectALLCheckBox() {		
		List <WebElement> checkBoxes= driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		for(WebElement check:checkBoxes)
		{
			System.out.println("Check Boxes are :" +check.getText());
			check.click();
			
		}
	}
	
	@Test
	//Select multiple check boxes by choice
	//Select Tuesday & Friday
	public void checkBoxesByChoice() {
		List <WebElement> checkBoxes= driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		
		for(WebElement chkBox: checkBoxes)
		{
			String chkBoxName=chkBox.getAttribute("id");
			if(chkBoxName.equalsIgnoreCase("Tuesday")|| chkBoxName.equalsIgnoreCase("Friday"))
			{
				chkBox.click();
				
			}
			
		}
		
	}
	
	@Test
	//Select Last two check Boxes
	public void lastTwoCheckBoxes() {
		List <WebElement> checkBoxes= driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		
		int TotalCheckBoxes=checkBoxes.size();
		
		for(int i=TotalCheckBoxes-2; i<checkBoxes.size(); i++)
		{
			checkBoxes.get(i).click();
		}
	}

	@Test
	//Select first two check boxes
	public void firstTwoCheckBoxes() {
		List <WebElement> checkBoxes= driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		
		int TotalCheckBoxes=checkBoxes.size();
		for(int i=0;i<TotalCheckBoxes; i++)
		{
			if(i<2)
			{
				checkBoxes.get(i).click();
			}
		}
		
	}
	
	@After
	public void teardown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
		
	}
			
			
	}

