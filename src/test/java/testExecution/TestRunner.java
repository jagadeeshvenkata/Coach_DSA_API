package testExecution;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions( 		
		features = "src\\test\\java\\features",
		glue= "stepDefinitions",
		tags= "@registration or @rlogin or @UpdateProfile",
		plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome=true
		)

public class TestRunner {
	
}
