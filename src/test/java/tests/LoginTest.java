package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.WelcomeScreen;
import utils.SwaggrightBase;

public class LoginTest extends SwaggrightBase {
    LoginScreen login;
    WelcomeScreen welcomeScreen;

    @BeforeTest
    public void initializeScreenObjects() {
         login = new LoginScreen(getAndroidDriver());
         welcomeScreen = new WelcomeScreen(getAndroidDriver());
    }

    @Test
    public void loginToTheApp() {
        login.enterUsername("adimanav");
        login.enterPassword("ne0tericnevi");
        login.clickLogin();
    }

  //  @Test
    public void validateWelcomeScreen(){
        Assert.assertEquals(welcomeScreen.getWelcomeText(),"Welcome to SwaggRights");
     }
}
