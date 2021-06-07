package GuruWebPage;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import pageObjects.ManagerHomePage;
import resources.base;

public class ValidatingMenuBar extends base{
	
	private static Logger log = LogManager.getLogger(base.class.getName());
	
	public WebDriver driver;
	
	ManagerHomePage mp;
	
	@BeforeTest
	public void invokeBrowser() throws IOException
	{
        driver = initializeBrowser();
        
        log.info("Browser invoked");
        		
		driver.get(prop.getProperty("url"));
		
		log.info("Url Opened");
	}
	
	
	
	@Test
	public void navBarValidation()
	{
		getLogIn();
		
		mp = new ManagerHomePage(driver);
		
		List<WebElement> name = mp.getMenu();
		
		int s = name.size();
		
		int expectedSize = 15;
		
		Assert.assertEquals(s, expectedSize);
		
		
	}
	
	@Test
	public void validateMenuLink() throws MalformedURLException, IOException
	{	
		List<WebElement> allLinks = mp.getMenuLink();
		SoftAssert a =new SoftAssert();
		for(WebElement link : allLinks)
		{
			String url = link.getAttribute("href");
			HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int respCode = connection.getResponseCode();
			a.assertTrue(respCode<400, "The link with Text " + link.getText() + " is broken with code " + respCode);
			
		}
		
		a.assertAll();
	}
	
	@Test
	public void validateMenuName()
	{
		String managerText = mp.getManagerMenu().getText();
		Assert.assertEquals(managerText, "Manager");
		
		String newCusText = mp.getNewCusMenu().getText();
		Assert.assertEquals(newCusText, "New Customer");
		
		String logOutText = mp.getLogOut().getText();
		Assert.assertEquals(logOutText, "Log out");
		
		String editCusText = mp.getEditCustomer().getText();
		Assert.assertEquals(editCusText, "Edit Customer");
		
		String changePassText = mp.getPasswordChange().getText();
		Assert.assertEquals(changePassText, "Change Password");
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
