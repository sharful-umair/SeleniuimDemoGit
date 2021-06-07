package GuruWebPage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CustomerUpdateMsgPage;
import pageObjects.EditCustomerPage;
import pageObjects.ManagerHomePage;
import resources.base;

public class EditCustomerTest extends base {
	
	private static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void invokeBrowser() throws IOException
	{
        driver = initializeBrowser();
        
        log.info("Browser invoked");
		
		driver.get(prop.getProperty("url"));
		
		log.info("Url Opened");
	}
	
	
	@Test
	public void editCustomer()
	{
		getLogIn();
		
		ManagerHomePage mp = new ManagerHomePage(driver);
		
		mp.getEditCustomer().click();
		
		EditCustomerPage ep = new EditCustomerPage(driver);
		
		System.out.println(NewCustomerTest.customerId);
		
		ep.getCustomerIdText().sendKeys(NewCustomerTest.customerId);
		
		ep.getEditSubmitBtn().click();
		
		ep.getEditNumber().clear();
		
		ep.getEditNumber().sendKeys("7278090111");
		
		ep.getSubmitButton().click();
		
		CustomerUpdateMsgPage cu = new CustomerUpdateMsgPage(driver);
		
		String textUpdateMsg = cu.getEditSuccessMsg().getText();
		
		System.out.println(textUpdateMsg);
		
		Assert.assertEquals(textUpdateMsg, "Customer details updated Successfully!!!");
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
		log.info("Browser closed");
	}

}
