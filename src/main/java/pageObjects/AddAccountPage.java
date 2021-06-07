package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddAccountPage {
	
	public WebDriver driver;
	
	public AddAccountPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	private By customerIdBox = By.xpath("//input[@name='cusid']");
	
	private By accountType = By.xpath("//select[@name='selaccount']");
	
	private By initialDeposit = By.xpath("//input[@name='inideposit']");
	
	private By newAccountSubmitBtn = By.xpath("//input[@name='button2']");
	
	
	
	public WebElement getCustomerIdBox()
	{
		return driver.findElement(customerIdBox);
	}
	
	public WebElement getaccountType()
	{
		return driver.findElement(accountType);
	}
	
	public WebElement getInitialDeposit()
	{
		return driver.findElement(initialDeposit);
	}
	
	public WebElement getNewAccountSubmitBtn()
	{
		return driver.findElement(newAccountSubmitBtn);
	}
}
