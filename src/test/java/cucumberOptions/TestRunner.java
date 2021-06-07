package cucumberOptions;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class) 

@CucumberOptions(
		tags={"@LogOutTest"},
		features = "src/test/java/features",
		glue = "stepDefinations"
		)

public class TestRunner{ 



}