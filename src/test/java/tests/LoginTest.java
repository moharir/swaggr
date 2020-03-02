package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class LoginTest extends SwaggrightBase{
    LoginScreen login;

    @BeforeTest
    public void initializeScreenObjects() {
         login = new LoginScreen(getAndroidDriver());
    }

    @Test
    public void loginToTheApp() {
        login.enterUsername("adimanav");
        login.enterPassword("ne0tericnevi");
        login.clickLogin();
    }
}
