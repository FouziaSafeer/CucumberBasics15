package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//we are importing
@CucumberOptions(features = "src\\test\\resources\\Features",
        glue = "StepDefinitions",
        dryRun = false,//when its true it will generate code without running
        tags=" @database",
        plugin = {"pretty","html:target/Cucumber.html","json:target/Cucumber.json","rerun:target/failed.txt"}
        //plugin = {"pretty", "html:target/Cucumber.html"}

)
//for multiple test cases we can use tags="@testcase1" or "testcase2")
//@testcase1@smoke@regression multiple tags

public class SmokeRunner {

}
//target folder is mostly used for storing the test case execution reports generated using Cucumber
