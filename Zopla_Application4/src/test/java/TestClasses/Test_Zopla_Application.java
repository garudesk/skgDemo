package TestClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.Page_Object_Zopala_Application;



public class Test_Zopla_Application {
	
	public WebDriver driver;
	
	public Page_Object_Zopala_Application page_zopla ;//= new Page_Object_Zopala_Application(driver);

	
	@BeforeMethod
	public void SetUp() throws InterruptedException { 
	
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaio\\Downloads\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		page_zopla = new Page_Object_Zopala_Application(driver);

		
		Thread.sleep(50000);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		
		driver.get("https://www.zoopla.co.uk/");	
		
	
	
	}
//	@Test
//	public void search() throws InterruptedException {
//	
//	//Page_Object_Zopala_Application page_zopla = new Page_Object_Zopala_Application(driver);
//	Thread.sleep(5000);
//	page_zopla.search();
//	Thread.sleep(9000);
//	
//	}
//	
//	@Test
//	public void reitriving_values_of_property() throws InterruptedException {
//	Thread.sleep(9000);
//	Page_Object_Zopala_Application page_zopla = new Page_Object_Zopala_Application(driver);	
//	page_zopla.search();	
//	Thread.sleep(9000);
//	page_zopla.reitriving_values();
//	Thread.sleep(9000);
//	}
	
//	@Test
//	public void selecting_the_fifth_value() throws InterruptedException {
//	Thread.sleep(9000);	
//	Page_Object_Zopala_Application page_zopla = new Page_Object_Zopala_Application(driver);	
//	page_zopla.search();
//	Thread.sleep(9000);
//	page_zopla.reitriving_values();
//	Thread.sleep(9000);
//	page_zopla.selecting_fifth_element();
//	Thread.sleep(9000);
//
//	}
//	
//	@Test
//	public void agent_home_page() {
//		Page_Object_Zopala_Application page_zopla = new Page_Object_Zopala_Application(driver);
//		page_zopla.search();
//		page_zopla.reitriving_values();
//		page_zopla.selecting_fifth_element();
//	    page_zopla.click_agent_link();
//	   
//	}
//	
	@Test
	public void validate_property_in_the_agent_record() throws InterruptedException {
		Thread.sleep(9000);
		Page_Object_Zopala_Application page_zopla = new Page_Object_Zopala_Application(driver);
		page_zopla.search();
		Thread.sleep(9000);
		page_zopla.reitriving_values();
		Thread.sleep(9000);
		page_zopla.selecting_fifth_element();
		Thread.sleep(9000);
	    page_zopla.click_agent_link();
	    Thread.sleep(9000);
	    page_zopla.agent_home_page();
	    Thread.sleep(9000);
		page_zopla.validating_search_property_in_the_agents_record();	
		Thread.sleep(9000);
		
		
	}
//	
	@AfterMethod
	public void quit_browser() {
	
	//Page_Object_Zopala_Application page_zopla = new Page_Object_Zopala_Application(driver);
      driver.quit();
	}
	
	}
