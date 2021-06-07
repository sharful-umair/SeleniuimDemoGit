package stepDefinations;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.LogInPage;
import pageObjects.ManagerHomePage;
import resources.base;

@RunWith(Cucumber.class)
public class WebLogIn extends base{
	
	//WebDriver driver;
	ManagerHomePage mp = new ManagerHomePage(driver);
	LogInPage lp = new LogInPage(driver);
	
	
	@Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
        
		driver = initializeBrowser();
		mp = new ManagerHomePage(driver);
		lp = new LogInPage(driver);
    }

	@When("^user enters userid (.+) and password (.+) and logs in$")
    public void user_enters_userid_and_password_and_logs_in(String username, String password) throws Throwable {
       
    	lp.getUserId().sendKeys(username);
    	lp.getPassword().sendKeys(password);
    	lp.getLogInButton().click();
    }

    @Then("^verify user got successfully login$")
    public void verify_user_got_successfully_login() throws Throwable {
    	
    	String id = mp.getManagerId().getText().split(":")[1].trim().split(" ")[0];
    	System.out.println(id);
		Assert.assertEquals(id, "mngr332003");
        
    }

    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
        
    	driver.get(prop.getProperty("url"));
    }

    @And("^browser close$")
    public void browser_close() throws Throwable {
    	
    	driver.close();
    }


}
