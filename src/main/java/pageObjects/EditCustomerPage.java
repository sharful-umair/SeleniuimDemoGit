package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditCustomerPage {
	
	public WebDriver driver;
	
	public EditCustomerPage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By cusIdText = By.xpath("//input[@name='cusid']");
	
	private By editBtn = By.xpath("//input[@name='AccSubmit']"); 
	
	private By editNumber = By.xpath("//input[@name='telephoneno']"); 
	
	private By editButton = By.xpath("//input[@type='submit']"); 
	
	
	public WebElement getCustomerIdText()
	{
		return driver.findElement(cusIdText);
	}
	
	public WebElement getEditSubmitBtn()
	{
		return driver.findElement(editBtn);
	}
	
	public WebElement getEditNumber()
	{
		return driver.findElement(editNumber);
	}
	
	public WebElement getSubmitButton()
	{
		return driver.findElement(editButton);
	}
}
