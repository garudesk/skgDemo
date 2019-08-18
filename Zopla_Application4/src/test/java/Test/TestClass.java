package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class TestClass {
	
	
	public WebDriver driver;
	
	@Test
	public void SetUp() throws InterruptedException
	{
				
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaio\\Downloads\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		Thread.sleep(10000);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		driver.get("https://www.zoopla.co.uk/");
		
	    Thread.sleep(10000);
		
		driver.findElement(By.xpath("//input[@id='search-input-location']")).sendKeys("London");
		
		driver.findElement(By.xpath("//button[@id='search-submit']")).click();
	  
		Thread.sleep(90000);
		
   
      //Retrieving the values ....//  		
		    String temp = null;
		    Thread.sleep(190000);
		    List<WebElement> editicons1 = driver.findElements(By.xpath("//ul[@class='listing-results clearfix js-gtm-list']//a[@class='listing-results-price text-price']"));
		   Thread.sleep(190000);
		    String strArray[] = new String[editicons1.size()];
		    System.out.println(".............. Rent Values as per display..................... "); 
		    Thread.sleep(190000);
		    for (int i = 0; i < editicons1.size(); i++) {
		        editicons1 = driver.findElements(By.xpath("//ul[@class='listing-results clearfix js-gtm-list']//a[@class='listing-results-price text-price']"));
		        System.out.println(editicons1.get(i).getText());
		        strArray[i] = editicons1.get(i).getText();
		    }
		    Thread.sleep(90000);
		    // Sort the Array by Swapping the Elements
		    for (int i = 0; i < strArray.length; i++) {
		        for (int j = i + 1; j < strArray.length; j++) {
		            if (strArray[i].compareTo(strArray[j]) > 0) {
		                temp = strArray[i];
		                strArray[i] = strArray[j];
		                strArray[j] = temp;
		            }
		        }
		    }
		    // Printing the Values after sorting in ascending order
		    System.out.println("##################  Sorted values ####################");
		    for (int i = 0; i < strArray.length; i++) {
		         System.out.println(strArray[i]);
		    }

		   String fifth_value = editicons1.get(4).getText();
		   
		   
		   System.out.println("fifth_value------------>" +fifth_value);
	
           Thread.sleep(90000);		   
           
		   for(WebElement eb1:editicons1)
	        {
	        if(eb1.getText().equals(fifth_value))
	        {
	           Thread.sleep(9000);
	           eb1.click();
	           System.out.println("...........Successfully cliked on Fifth Element................");
	           break;
	        }
	        
	        }
	        Thread.sleep(90000);
	
 	       driver.findElement(By.xpath("//div[@class='dp-sidebar-wrapper__contact']//h4[@class='ui-agent__name']")).click();
	       
	       System.out.println("...........Successfully cliked on Agents Link.........");
	        
	       Thread.sleep(9000);
	       
           driver.findElement(By.xpath("//a[contains(text(),'See all property for sale from this agent')]")).click();
           
           if(driver.getPageSource().contains(fifth_value)) {
        	   
        	   System.out.println("...............Property matched with agent's record.............");
        	   
           }else {
           
           System.out.println(".......Property not matched with agent's record....");
           }
	
           	
	}
}
