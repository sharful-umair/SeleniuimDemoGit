package stepDefinations;

import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

import pageObjects.ManagerHomePage;
import resources.base;



@RunWith(Cucumber.class)
public class WebLogout extends base {
	
	//WebDriver driver;
	ManagerHomePage mp = new ManagerHomePage(driver);
	
	
    @When("^user Logout from the application$")
    public void user_logout_from_the_application() throws Throwable {
        
		mp.getLogOut().click();
    }

    @Then("^verify user got successfully logout$")
    public void verify_user_got_successfully_logout() throws Throwable {
        
        Alert alert = driver.switchTo().alert();
		String logoutAlert = alert.getText();
		Assert.assertEquals(logoutAlert, "You Have Succesfully Logged Out!!");
		alert.accept();
    }
    
}
