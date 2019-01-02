package Demo_Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Akanksha\\eclipse-workspace\\Demo_Framework\\src\\test\\java\\Feature\\Demo.feature"
	    ,glue = "StepDef_Package"
		,monochrome = true
		)

public class demoRunner {

}


