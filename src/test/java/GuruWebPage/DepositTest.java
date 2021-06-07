package GuruWebPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AccCreateMsgPage;
import pageObjects.AddAccountPage;
import pageObjects.DepositInputPage;
import pageObjects.DepositSuccessPage;
import pageObjects.ManagerHomePage;
import resources.base;

public class DepositTest extends base {

	public WebDriver driver;
	String amount = "1000";
	String desp = "Depositing amount";
	
	String cusId = "488";
	String accounTypeSelect = "Savings";
	String depositMoney = "1000";
	String AccId;
	
	
	
	@BeforeTest
	public void invokeBrowser() throws IOException
	{
		driver = initializeBrowser();
		
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void getAccountNum()
	{
		getLogIn();
		ManagerHomePage mp = new ManagerHomePage(driver);
		mp.getNewAccount().click();
		
		AddAccountPage ap = new AddAccountPage(driver);
		ap.getCustomerIdBox().sendKeys(cusId);
		//ap.getaccountType().click();
		Select dropdown = new Select(ap.getaccountType());
		dropdown.selectByVisibleText(accounTypeSelect);
		ap.getInitialDeposit().sendKeys(depositMoney);
		ap.getNewAccountSubmitBtn().click();
		
		AccCreateMsgPage ac = new AccCreateMsgPage(driver);
		AccId = ac.getAccountId().getText();
	}
	
	
	@Test(dependsOnMethods = {"getAccountNum"})
	public void amountDeposit()
	{
		ManagerHomePage mp = new ManagerHomePage(driver);
		mp.getDepositBtn().click();
		
		DepositInputPage dp = new DepositInputPage(driver);
		dp.getAccountNum().sendKeys(AccId);
		dp.getAmount().sendKeys(amount);
		dp.getDescription().sendKeys(desp);
	    dp.getDepositButton().click();
	    
	    DepositSuccessPage  ds = new DepositSuccessPage(driver);
	    String actaulTxt = ds.getDepositSuccessTxt().getText();
	    Assert.assertEquals(actaulTxt.contains("Transaction details of Deposit for Account"), true);
	    
		
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}


	

}
