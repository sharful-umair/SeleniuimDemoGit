package GuruWebPage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import pageObjects.ManagerHomePage;
import resources.base;

public class LogInTest extends base{
	
	private static Logger log = LogManager.getLogger(base.class.getName());

	public WebDriver driver;
	
	LogInPage lp;
	
	@BeforeTest
	public void invokeBrowser() throws IOException
	{
        driver = initializeBrowser();
        
        log.info("Browser invoked");
        		
		driver.get(prop.getProperty("url"));
		
		log.info("Url Opened");
	}
	
	@Test 	
	public void  validateLoginPageText()
	{
		lp = new LogInPage(driver);
		
		String userIdTxt = lp.getUserIdText().getText();
		Assert.assertEquals(userIdTxt, "UserID");
		
		String passtxt = lp.getPasswordText().getText();
		Assert.assertEquals(passtxt, "Password");
		
		String logInTxt = lp.getLogInButton().getAttribute("value");
		Assert.assertEquals(logInTxt, "LOGIN");
		
		String resetTxt = lp.getResetText().getAttribute("value");
		Assert.assertEquals(resetTxt, "RESET");
	}
	
	
	@Test(dataProvider = "getData", priority=1)
	public void logIn(String username, String password) throws IOException
	{
		lp = new LogInPage(driver);
		
		lp.getUserId().sendKeys(username);
		
		log.info("UserId got entered");
		
		lp.getPassword().sendKeys(password);
		
		log.info("Password got entered");
		
		lp.getLogInButton().click();
		
		log.info("Submit got clicked");
		
		ManagerHomePage mp = new ManagerHomePage(driver);
		
		String id = mp.getManagerId().getText().split(":")[1].trim().split(" ")[0];
		
		Assert.assertEquals(id, username);
		
		//Assert.assertEquals(id, 1234);
		
		log.info("LogIn Successfully");
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
		log.info("Browser closed");
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		
		data[0][0] = "mngr325182";
		data[0][1] = "#abcd1";
		
		return data;
		
		
	}
	
	

}
