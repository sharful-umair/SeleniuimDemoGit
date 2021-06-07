package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DepositSuccessPage {

public WebDriver driver;
	
	
	public DepositSuccessPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	private By successMsgTxt = By.xpath("//*[@id=\"deposit\"]/tbody/tr[1]/td/p");
	
	
	public WebElement getDepositSuccessTxt()
	{
		return driver.findElement(successMsgTxt);
	}
}
