package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen {

    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    private AndroidElement txtUsername;
    @AndroidFindBy(xpath = "//android.widget.EditText[2]")
    private MobileElement txtPassword;
    @AndroidFindBy(xpath = "//*[@class='android.view.ViewGroup' and ./*[@text='Start Swagging']]")
    private MobileElement btnLogin;

    private AndroidDriver androidDriver;

    public LoginScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void enterUsername(String username) {
        txtUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        androidDriver.hideKeyboard();
        btnLogin.click();
    }
}
