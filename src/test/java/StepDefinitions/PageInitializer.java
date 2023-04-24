package StepDefinitions;

import Pages.AddEmployeePage;
import Pages.LoginPage;

public class PageInitializer {
    //this class will manage the objects creation of diffrent page objects
    //in our framework , instead of calling page object again and again
    //this class will take care of that step
    // This class will manage the object creation of different page Objects in our Framework.
// Instead of calling the age objects again and again, this class will take good care of that step

public static LoginPage login;
public static AddEmployeePage addEmployeePage;
    public static void initializePageObjects(){
         login =new LoginPage();
         addEmployeePage=new AddEmployeePage();
    }

}
