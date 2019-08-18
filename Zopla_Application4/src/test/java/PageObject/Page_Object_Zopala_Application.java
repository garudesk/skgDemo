package PageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Object_Zopala_Application {
	
	
      public WebDriver ldriver;
      public List<WebElement>  editicons1;
	  public String fifth_value;
	  
	  
	  public Page_Object_Zopala_Application(WebDriver rdriver) {
		  ldriver=rdriver;
			PageFactory.initElements(rdriver, this);  
	  }
	
	@FindBy(xpath="//input[@id='search-input-location']")
	WebElement search_field;
	
	@FindBy(xpath="//button[@id='search-submit']")
	WebElement search_btn;
	
	@FindBy(xpath="//ul[@class='listing-results clearfix js-gtm-list']//a[@class='listing-results-price text-price']")
	WebElement reitriving_values;
	
	@FindBy(xpath="//div[@class='dp-sidebar-wrapper__contact']//h4[@class='ui-agent__name']")
	WebElement agent_link;
	
	@FindBy(xpath="//a[contains(text(),'See all property for sale from this agent')]")
	WebElement agent_homepage;
	
   
	
//	public void initialisation() throws InterruptedException {
//	
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaio\\Downloads\\chromedriver.exe");
//		
//		WebDriver driver = new ChromeDriver();
//		
//		
//		
//		Thread.sleep(50000);
//		
//		driver.manage().window().maximize();
//		
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//		
//		driver.get("https://www.zoopla.co.uk/");
//	
//	
//	}
	
	public void search() {
	
		search_field.sendKeys("London");
		search_btn.click();
	    
	
}
	public void reitriving_values() {
	
		String temp = null;
	    //Thread.sleep(190000);
	   editicons1 = ldriver.findElements(By.xpath("//ul[@class='listing-results clearfix js-gtm-list']//a[@class='listing-results-price text-price']"));
	   //Thread.sleep(190000);
	    String strArray[] = new String[editicons1.size()];
	    System.out.println(".............. Rent Values as per display..................... "); 
	    //Thread.sleep(190000);
	    for (int i = 0; i < editicons1.size(); i++) {
	        editicons1 = ldriver.findElements(By.xpath("//ul[@class='listing-results clearfix js-gtm-list']//a[@class='listing-results-price text-price']"));
	        System.out.println(editicons1.get(i).getText());
	        strArray[i] = editicons1.get(i).getText();
	    }
	    //Thread.sleep(90000);
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
	
	
	}
	
	
	public void selecting_fifth_element() {
	
		 

	   fifth_value = editicons1.get(4).getText();
	   
	   
	   System.out.println("fifth_value------------>" +fifth_value);

      	   
       
	   for(WebElement eb1:editicons1)
        {
        if(eb1.getText().equals(fifth_value))
        {
      
           eb1.click();
           System.out.println("...........Successfully cliked on Fifth Element................");
           break;
        }
        
        }
       
	}

       public void click_agent_link() {

        agent_link.click();

       }

     public void agent_home_page() {

    	agent_homepage.click(); 
    	
    	System.out.println("................Successfully click the all properties link of agent..................");
    	 
     } 
    	 
    public void validating_search_property_in_the_agents_record() {
    	
    	if(ldriver.getPageSource().contains(fifth_value)) {
     	   
     	   System.out.println("...............Property matched with agent's record.............");
     	   
        }else {
        
        System.out.println(".......Property not matched with agent's record....");
        }	
    	
    }

     public void quit_browser() {

     
          ldriver.quit();    
     }
}
  