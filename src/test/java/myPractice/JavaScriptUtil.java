package myPractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	WebDriver driver;
	
	public void javaScriptUtil(WebDriver driver)
	{
		this.driver= driver;
		
	}
	
	public void scrollIntoView(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("argument[0].scrollIntView(true);", element);
	}
	
	public void clickElementByJs(WebElement element)
	{
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("argument[0].click();", element);
	}
	
	public void alertGenerate(String message)
	
	{
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"');");
		
			
	}
	
	public void scrollPageDown() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

}
