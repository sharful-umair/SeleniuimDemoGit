package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordInputPage {
	
	public WebDriver driver;
	
	
	public PasswordInputPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	private By oldPass = By.xpath("//input[@name='oldpassword']");
	
	private By newPass = By.xpath("//input[@name='newpassword']");
	
	private By confirmPass = By.xpath("//input[@name='confirmpassword']");
	
	private By changePassBtn = By.xpath("//input[@type='submit']");
	
	
	public WebElement getOldPassword()
	{
		return driver.findElement(oldPass);
	}
	
	public WebElement getNewPassword()
	{
		return driver.findElement(newPass);
	}
	
	public WebElement getConfirmPassword()
	{
		return driver.findElement(confirmPass);
	}
	
	public WebElement getChangePassButton()
	{
		return driver.findElement(changePassBtn);
	}
	
}
