package myPractice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImages {
	
	WebDriver driver;
	String Url= "https://the-internet.herokuapp.com/broken_images";
	@Before
	public void setup() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get(Url);
				
	}
	
	@Test
	public void checkBrokenImages() {
		
		List<WebElement> listOfImageTag=driver.findElements(By.tagName("img"));
		System.out.println("Total no of images :" + listOfImageTag.size());
		
		for(int i=0; i<listOfImageTag.size(); i++)
		{
			String imageSourceLink= listOfImageTag.get(i).getAttribute("src");
			
		try {
			URL url= new URL(imageSourceLink); //Creating a URL
			URLConnection urlConnection= url.openConnection();// Setting up the connection protocol as Http or Https
			HttpURLConnection httpURLConnection= (HttpURLConnection) urlConnection;
			httpURLConnection.setConnectTimeout(4000);// Setting up the connection Timeout
			httpURLConnection.connect();
			// Connecting with the url with Http Protocol
			if (httpURLConnection.getResponseCode()==200)
			{
				System.out.println(" The image source link " +imageSourceLink +httpURLConnection.getResponseCode());
			}
			
			else
			{
				System.out.println(" The image source link " +imageSourceLink +httpURLConnection.getResponseCode());
			}
			
			httpURLConnection.disconnect();// disconnect the URL Connection
			}
		 catch (Exception e){
			 System.out.println("Some issue with the source link -->" +imageSourceLink);
			 e.printStackTrace();
			 			
			
		}
		
		}
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	}

