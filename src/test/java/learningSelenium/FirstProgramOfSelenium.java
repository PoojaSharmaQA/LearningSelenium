package learningSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstProgramOfSelenium {

	public static void main(String[] args){

		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");

		WebDriver driv= new ChromeDriver();

		driv.manage().window().maximize();
		driv.manage().deleteAllCookies();
		driv.get("https://www.nykaa.com/");
		String CurrentUrl= driv.getCurrentUrl();
		System.out.println("Current Url is "+ CurrentUrl);
		
		String ActualUrl= "https://www.nykaa.com/";
		System.out.println("Actual Url is" + ActualUrl);
		
		

		if(ActualUrl.equals(CurrentUrl))
		{
			System.out.println("Current Url is as per the Actual Url");
		}
		else
		{
			System.out.println("Current Url is not as per the Actual Url");
		}

		//driv.close();

	}


}


