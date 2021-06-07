package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import pageObjects.LogInPage;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeBrowser() throws IOException
	{
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\sharf\\eclipse-workspace\\GuruWebPage\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");
	    System.out.println(browserName);
		
	    
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sharf\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver");
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	
	
	public LogInPage getLogIn()
	{
        LogInPage lp = new LogInPage(driver);
		lp.getUserId().sendKeys(prop.getProperty("logId"));
		lp.getPassword().sendKeys("dAvUrup");
		lp.getLogInButton().click();
		return lp;
	}
	
	
	public String generateEmail()
	{
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);  
		String randomEmail = "username" + randomInt + "@yopmail.com";
		return randomEmail;
	}
	
	
	public String generatePassword()
	{
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String lower = "abcdefghijklmnopqrstuvwxyz";
	    String p = RandomStringUtils.random( 5, upper+lower);
	    int i = 1;
	    String c = "#";
	    String pwd = p+i+c;
	    return pwd;
	}
	
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
