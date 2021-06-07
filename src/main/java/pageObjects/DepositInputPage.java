package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DepositInputPage {

public WebDriver driver;
	
	
	public DepositInputPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By accNum = By.xpath("//input[@name='accountno']");
	private By amount = By.xpath("//input[@name='ammount']");
	private By description = By.xpath("//input[@name='desc']");
	private By depositBtn = By.xpath("//input[@name='AccSubmit']");
	
	
	public WebElement getAccountNum()
	{
		return driver.findElement(accNum);
	}
	
	public WebElement getAmount()
	{
		return driver.findElement(amount);
	}
	
	public WebElement getDescription()
	{
		return driver.findElement(description);
	}
	
	public WebElement getDepositButton()
	{
		return driver.findElement(depositBtn);
	}
}
