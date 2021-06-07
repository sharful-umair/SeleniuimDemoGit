package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ManagerHomePage {
	
	public WebDriver driver;
	
	
	public ManagerHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	private By managerId = By.xpath("//tr[@class='heading3']/td");
	
	private By newCustomer = By.xpath("//ul[@class='menusubnav'] //a[contains(text(), \"New Customer\")]");
	
	private By editCustomer = By.xpath("//a[contains(text(),'Edit Customer')]");
	
	private By passchange = By.xpath("//a[contains(text(),'Change Password')]");
	
	private By logout = By.cssSelector("a[href='Logout.php']");
	
	private By navMenu = By.xpath("//ul[@class='menusubnav']//li");
	
	private By navBar = By.className("menusubnav");
	
	private By menuLink = By.xpath("//ul[@class='menusubnav'] //a");
	
	private By managerMenu = By.xpath("//a[contains(text(),'Manager')]");
	
	private By newCusMenu = By.xpath("//a[contains(text(),'New Customer')]");
	
	private By newAccount = By.xpath("//a[contains(text(),'New Account')]");
	
	private By deposit = By.xpath("//a[contains(text(),'Deposit')]");
	
	
	
	
	public WebElement getManagerId()
	{
		return driver.findElement(managerId);
	}
	
	public WebElement getNewCustomer()
	{
		return driver.findElement(newCustomer);
	}

	public WebElement getEditCustomer()
	{
		return driver.findElement(editCustomer);
	}
	
	public WebElement getPasswordChange()
	{
		return driver.findElement(passchange);
	}
	
	public WebElement getLogOut()
	{
		return driver.findElement(logout);
	}
	
	public List<WebElement> getMenu()
	{
		return driver.findElements(navMenu);
	}
	
	public WebElement getNavBar()
	{
		return driver.findElement(navBar);
	}
	
	public List<WebElement> getMenuLink()
	{
		return driver.findElements(menuLink);
	}
	
	public WebElement getManagerMenu()
	{
		return driver.findElement(managerMenu);
	}
	
	public WebElement getNewCusMenu()
	{
		return driver.findElement(newCusMenu);
	}
	
	public WebElement getNewAccount()
	{
		return driver.findElement(newAccount);
	}
	
	public WebElement getDepositBtn()
	{
		return driver.findElement(deposit);
	}
	
	
}
