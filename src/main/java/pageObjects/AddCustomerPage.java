package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddCustomerPage {

	public WebDriver driver;
	
	public AddCustomerPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	private By customerName = By.xpath("//input[@name='name']");
	
	private By radioBtnMale = By.xpath("//input[@name='rad1']");
	
	private By addressBox = By.xpath("//textarea[@name='addr']");
	
	private By city = By.xpath("//input[@name='city']");
	
	private By state = By.xpath("//input[@name='state']");
	
	private By pin = By.xpath("//input[@name='pinno']");
	
	private By mobileNumber = By.xpath("//input[@name='telephoneno']");
	
	private By email = By.xpath("//input[@name='emailid']");
	
	private By password = By.xpath("//input[@name='password']");
	
	private By submit = By.xpath("//input[@name='sub']");
	
	private By calendar = By.xpath("//input[@type='date']");
	
	
	
	public WebElement getCustomerName()
	{
		return driver.findElement(customerName);
	}
	
	public WebElement getRadioButtonMale()
	{
		return driver.findElement(radioBtnMale);
	}
	
	public WebElement getAddressBox()
	{
		return driver.findElement(addressBox);
	}
	
	public WebElement getCity()
	{
		return driver.findElement(city);
	}
	
	public WebElement getSate()
	{
		return driver.findElement(state);
	}
	
	public WebElement getPin()
	{
		return driver.findElement(pin);
	}
	
	public WebElement getMobileNumber()
	{
		return driver.findElement(mobileNumber);
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getCalendar()
	{
		return driver.findElement(calendar);
	}
	
	public WebElement getSubmitButton()
	{
		return driver.findElement(submit);
	}
	
}
