package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerUpdateMsgPage {
	
public WebDriver driver;
	
	public CustomerUpdateMsgPage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By editSuccessMsg = By.xpath("//p[contains(text(), 'Customer details updated Successfully!!!')]");
	
	
	public WebElement getEditSuccessMsg()
	{
		return driver.findElement(editSuccessMsg);
	}

}
