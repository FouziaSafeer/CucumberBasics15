package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//we are importing
@CucumberOptions(features = "@target/failed.txt",
        glue = "StepDefinitions",
        //dryRun = false,//when its true it will generate code without running
      //  tags=" @testcase2",
        plugin = {"pretty",}
        //plugin = {"pretty", "html:target/Cucumber.html"}

)
public class FailedRunner {
    // this will run only
}
