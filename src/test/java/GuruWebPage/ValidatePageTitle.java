package GuruWebPage;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ManagerHomePage;
import resources.base;

public class ValidatePageTitle extends base {
	
	private static Logger log = LogManager.getLogger(base.class.getName());
	
	public WebDriver driver;
	
	int totalLinks = 55;
	
	int navBarLinks = 15;
	
	String expectedTitle = "Guru99 Bank Manager HomePage\r\n"

	+ "Guru99 Bank Statement Page\r\n"

	+ "Guru99 Bank Mini Statement Page\r\n"

	+ "Guru99 Bank Balance Enquiry Page\r\n"

	+ "Guru99 Bank New Customer Entry Page\r\n"

	+ "Guru99 Bank Fund Transfer Entry Page\r\n"

	+ "Guru99 Bank Amount Withdrawal Page\r\n"

	+ "Guru99 Bank Amount Deposit Page\r\n"

	+ "Guru99 Bank Delete Account Page\r\n"

	+ "Guru99 Edit Account Page\r\n"

	+ "Guru99 bank add new account\r\n"

	+ "Guru99 Bank Delete Customer Page\r\n"

	+ "Guru99 Bank Edit Customer Page\r\n"

	+ "Guru99 Bank New Customer Entry Page\r\n"

	+ "Guru99 Bank Manager HomePage\r\n"

	+ "PASSED: validateTitle";

	
	@BeforeTest
	public void invokeBrowser() throws IOException
	{
        driver = initializeBrowser();
        
        log.info("Browser invoked");
		
		driver.get(prop.getProperty("url"));
		
		log.info("Url Opened");
	}
	
	String[] a;

	@Test
	public void validateTitle()
	{
		getLogIn();
		ManagerHomePage mp = new ManagerHomePage(driver);
		
		int s = driver.findElements(By.tagName("a")).size();
		Assert.assertEquals(s, totalLinks);
		
	    WebElement newdriver = mp.getNavBar();
	    int ns = newdriver.findElements(By.tagName("a")).size();
	    Assert.assertEquals(ns, navBarLinks);
	     
	    for(int i=0; i<ns-1; i++)
	    {
	    	String clickLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
	    	newdriver.findElements(By.tagName("a")).get(i).sendKeys(clickLinks);
	    }

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
		}
	}
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}


}
