package GuruWebPage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ManagerHomePage;
import pageObjects.PasswordInputPage;
import resources.base;

public class PasswordChangeTest extends base {
	
	private static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void invokeBrowser() throws IOException
	{
        driver = initializeBrowser();
        
        log.info("Browser invoked");
		
		driver.get(prop.getProperty("url"));
		
		log.info("Url Opened");
	}
	
	
	@Test(enabled = false)
	public void ChangePassword() throws InterruptedException
	{
		getLogIn();
		
		ManagerHomePage mp = new ManagerHomePage(driver);
		
		mp.getPasswordChange().click();
		
		PasswordInputPage pi = new PasswordInputPage(driver);
		
		pi.getOldPassword().sendKeys("#abcd1");
		
		pi.getNewPassword().sendKeys("#abcd1234");
		
		pi.getConfirmPassword().sendKeys("#abcd1234");
		
		pi.getChangePassButton().click();
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		
		String alertMsg = alert.getText();
		
		Assert.assertEquals(alertMsg, "Password is Changed");
		
		alert.accept();
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
		log.info("Browser closed");
	}

}
