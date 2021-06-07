package GuruWebPage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ManagerHomePage;
import resources.base;

public class LogOutTest extends base {
	
	private static Logger log = LogManager.getLogger(base.class.getName());
	
	public WebDriver driver;
	
	@BeforeTest
	public void invokeBrowser() throws IOException
	{
        driver = initializeBrowser();
        
        log.info("Browser invoked");
		
		driver.get(prop.getProperty("url"));
		
		log.info("Url Opened");
	}
	
	
	@Test
	public void LogOut()
	{
		getLogIn();
		
		ManagerHomePage mp = new ManagerHomePage(driver);
		
		mp.getLogOut().click();
		
		Alert alert = driver.switchTo().alert();
		
		String logoutAlert = alert.getText();
		
		Assert.assertEquals(logoutAlert, "You Have Succesfully Logged Out!!");
		
		alert.accept();
		
		String currentURL = driver.getCurrentUrl();
		
		Assert.assertEquals(currentURL, "http://www.demo.guru99.com/V4/index.php");
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
		log.info("Browser closed");
	}

}
