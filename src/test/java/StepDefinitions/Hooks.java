package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

    @Before
    public void preCondition()
    {
        openBrowserAndLaunchApplication();
    }

    @After

    public void postCondition(Scenario scenario) {

        byte[] pic;
        if (scenario.isFailed()) {
            pic = takeScreenshot("failed/" + scenario.getName());
        } else pic = takeScreenshot("passed/" + scenario.getName());
        //Scenario class hold the complete information of your tests exe in cucumber framework
//attached screenshot in my folder
        scenario.attach(pic,"image/png",scenario.getName());
        closeBrowser();

    }
}
