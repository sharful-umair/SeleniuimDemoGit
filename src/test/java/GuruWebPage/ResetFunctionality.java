package GuruWebPage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LogInPage;
import resources.base;

public class ResetFunctionality extends base {
	
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
	public void resetFunction()
	{
		LogInPage lp = new LogInPage(driver);
		
		lp.getUserId().sendKeys("testid");
		WebElement idtxt = lp.getEmptyIdText();
		Assert.assertTrue(!idtxt.isDisplayed());
		
		lp.getPassword().sendKeys("testpass");
		WebElement passtxt = lp.getEmptyPassText();
		Assert.assertTrue(!passtxt.isDisplayed());
		
		lp.getResetText().click();
		
		String resetIdtxt = lp.getUserId().getText();
		Assert.assertEquals(resetIdtxt, "");
		
		String resetPassTxt = lp.getPassword().getText();
		Assert.assertEquals(resetPassTxt, "");
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
		log.info("Browser closed");
	}
}
