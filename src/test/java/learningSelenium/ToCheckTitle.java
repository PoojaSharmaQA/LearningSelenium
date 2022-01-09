package learningSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToCheckTitle {
	
	public static void main(String[] args) {
		
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"geckodriver.exe");
		
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
		
		String ExpectedTitle= "Facebook – log in or sign up";
		String ActualTitle=driver.getTitle();
		{
			System.out.println("Title after invoking facebook.com is: " +ActualTitle);
		}
		
		if(ActualTitle.equals(ExpectedTitle))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		}	

	}


