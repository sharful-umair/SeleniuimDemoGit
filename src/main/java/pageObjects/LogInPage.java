package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	
	
	public WebDriver driver;
	
	public LogInPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	private By userId = By.xpath("//input[@name='uid']");
	
	private By password = By.xpath("//input[@name='password']");
	
	private By loginBtn = By.xpath("//input[@name='btnLogin']");
	
	private By userIdtxt = By.xpath("//td[contains(text(), 'UserID')]");
	
	private By passText = By.xpath("//td[contains(text(), 'Password')]");
	
	private By resetText = By.xpath("//input[@name='btnReset']");
	
	private By emptyIdTxt = By.xpath("//label[@id='message23']");
	
	private By emptyPassTxt = By.xpath("//label[@id='message18']");
	
	
	
	public WebElement getUserId()
	{
		return driver.findElement(userId);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogInButton()
	{
		return driver.findElement(loginBtn);
	}
	
	public WebElement getUserIdText()
	{
		return driver.findElement(userIdtxt);
	}
	
	public WebElement getPasswordText()
	{
		return driver.findElement(passText);
	}
	
	public WebElement getResetText()
	{
		return driver.findElement(resetText);
	}

	public WebElement getEmptyIdText()
	{
		return driver.findElement(emptyIdTxt);
	}
	
	public WebElement getEmptyPassText()
	{
		return driver.findElement(emptyPassTxt);
	}


}
