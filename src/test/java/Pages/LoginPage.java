package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    public LoginPage()//constructor
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="txtUsername")
   public WebElement usernameTextBox;





@FindBy(id ="txtPassword" )
   public WebElement passwordTextBox;

@FindBy(id="btnLogin")
public WebElement loginbtn;
    //page factory model (in selenium)
    @FindBy(id="welcome")
   public WebElement welcomeIcon;
@FindBy(xpath ="//a[text()='Logout']" )
   public WebElement logoutLink;




}
