package GuruWebPage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AddCustomerPage;
import pageObjects.CustomerRegMsg;
import pageObjects.ManagerHomePage;
import resources.base;



public class NewCustomerTest extends base{
	
	private static Logger log = LogManager.getLogger(base.class.getName());
	
	public static String customerId;
	
	@BeforeTest
	public void invokeBrowser() throws IOException
	{
        driver = initializeBrowser();
        
        log.info("Browser invoked");
		
		driver.get(prop.getProperty("url"));
		
		log.info("Url Opened");
	}
	
	@Test
	public void createNewCustomer() throws IOException
	{
		getLogIn();
		
		ManagerHomePage mp = new ManagerHomePage(driver);
		
		mp.getNewCustomer().click();
		
		log.info("Clicked on New Customer Menu");
		
		AddCustomerPage ap = new AddCustomerPage(driver);
		
		ap.getCustomerName().sendKeys("sharful umair");
		
		log.info("Name field got filled");
		
		ap.getRadioButtonMale().click();
		
		log.info("Clicking on male radio button");
		
		ap.getCalendar().sendKeys("10/05/2021");
		
		log.info("Calendar got filled");
		
		ap.getAddressBox().sendKeys("Broad Street");
		
		log.info("Address field got filled");
		
		ap.getCity().sendKeys("Kolkata");
		
		log.info("City field got filled");
		
		ap.getSate().sendKeys("West Bengal");
		
		log.info("State field got filled");
		
		ap.getPin().sendKeys("700019");
		
		log.info("Pin field got filled");
		
		ap.getMobileNumber().sendKeys("7278090585");
		
		log.info("Phone Number field got filled");
		
		ap.getEmail().sendKeys(generateEmail());
		
		log.info("Email got filled");
		
		ap.getPassword().sendKeys("abcd1234");
		
		log.info("Password field got filled");
		
		ap.getSubmitButton().click();
		
		log.info("Submit button got clicked");
		
		CustomerRegMsg cm = new CustomerRegMsg(driver);
		
		String actualSuccessReg = cm.getRegSuccessText().getText();
		
		Assert.assertEquals(actualSuccessReg, "Customer Registered Successfully!!!");
		
		log.info("Successfully Created New Customer");
		
		customerId = cm.getCustomerId().getText();
		
		System.out.println(customerId);
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
		log.info("Browser closed");
	}
	
	


}
