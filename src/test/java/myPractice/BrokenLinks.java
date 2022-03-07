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

public class BrokenLinks {

	WebDriver driver;
	String Url= "http://automationpractice.com/index.php";

	@Before
	public void setup() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get(Url);
	}

	@Test
	public void handleBrokenLinks() {

		List<WebElement> listOfaLinks= driver.findElements(By.tagName("a"));

		System.out.println("Total no of links are:" +listOfaLinks.size());
		for(int i=0; i<listOfaLinks.size(); i++)
		{
			String aTagSourceLink = listOfaLinks.get(i).getAttribute("href");

			try {
				URL url= new URL(aTagSourceLink);
				URLConnection urlConnection= url.openConnection();
				HttpURLConnection httpURLConnection = (HttpURLConnection)urlConnection;
				httpURLConnection.setConnectTimeout(20000);
				if (httpURLConnection.getResponseCode()==200)
				{
					System.out.println("The Link is :" +aTagSourceLink + httpURLConnection.getResponseCode() );

				}
				else
				{
					System.out.println("The Link is :" +aTagSourceLink + httpURLConnection.getResponseCode() );
				}
				
				httpURLConnection.disconnect();// disconnect the URL Connection
			}
			catch(Exception e)
			{
				System.out.println("There is some issue with the Link");
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


