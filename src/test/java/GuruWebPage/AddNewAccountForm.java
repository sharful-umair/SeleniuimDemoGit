package GuruWebPage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AccCreateMsgPage;
import pageObjects.AddAccountPage;
import pageObjects.ManagerHomePage;
import resources.base;

public class AddNewAccountForm extends base {
	
	public WebDriver driver;
	
	private static Logger log = LogManager.getLogger(base.class.getName());
	
	public String cusID = "488";
	public String accounTypeSelect = "Savings";
	public String depositMoney = "1000";
	public String expectedSuccessText = "Account Generated Successfully!!!";
	public String actualAccId;
	
	@BeforeTest
	public void invokeBrowser() throws IOException
	{
		driver = initializeBrowser();
		
		driver.get(prop.getProperty("url"));

	}
	
	
	@Test
	public void newAccountForm()
	{
		getLogIn();
		
		ManagerHomePage mp = new ManagerHomePage(driver);
		mp.getNewAccount().click();
		
		AddAccountPage ap = new AddAccountPage(driver);
		ap.getCustomerIdBox().sendKeys(cusID);
		//ap.getaccountType().click();
		Select dropdown = new Select(ap.getaccountType());
		dropdown.selectByVisibleText(accounTypeSelect);
		ap.getInitialDeposit().sendKeys(depositMoney);
		ap.getNewAccountSubmitBtn().click();
		
		AccCreateMsgPage ac = new AccCreateMsgPage(driver);
		String actualSuccessText = ac.getAccGeneratedTxt().getText();
		String actualCusId = ac.getCaptureCusId().getText();
		actualAccId = ac.getAccountId().getText();
		Assert.assertEquals(actualSuccessText, expectedSuccessText);
		Assert.assertEquals(actualCusId, cusID);
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
