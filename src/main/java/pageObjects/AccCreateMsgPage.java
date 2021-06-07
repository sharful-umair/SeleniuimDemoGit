package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccCreateMsgPage {

public WebDriver driver;
	
	public AccCreateMsgPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	private By AccGeneratedTxt = By.xpath("//p[contains(text(),'Account Generated Successfully!!!')]");
	
	private By captureCusId = By.xpath("//tbody/tr[5] //td[2]");
	
	private By AccId = By.xpath("//tbody/tr[4] //td[2]");
	
	
	public WebElement getAccGeneratedTxt()
	{
		return driver.findElement(AccGeneratedTxt);
	}
	
	public WebElement getCaptureCusId()
	{
		return driver.findElement(captureCusId);
	}
	
	public WebElement getAccountId()
	{
		return driver.findElement(AccId);
	}
}
