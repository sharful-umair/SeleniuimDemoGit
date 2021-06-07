package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerRegMsg {
	
	public WebDriver driver;
	
	public CustomerRegMsg(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	private By textCusReg = By.xpath("//p[contains(text(),'Customer Registered Successfully!!!')]");
	
	private By custId = By.xpath("//table[@id='customer']//tr[4]//td[2]");
	
	
	public WebElement getRegSuccessText()
	{
		return driver.findElement(textCusReg);
	}
	
	public WebElement getCustomerId()
	{
		return driver.findElement(custId);
	}

}
