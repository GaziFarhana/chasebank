package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature/FindCreditCard.feature", glue = {"Steps"},
format = { "pretty", "html:target/cucumber" })

public class DefaultRunner extends AbstractTestNGCucumberTests {

}
