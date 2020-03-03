package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class WelcomeScreen {
    @AndroidFindBy(xpath = "//*[@text='Welcome to SwaggRights']")
    private MobileElement lblWelcomeToSwaggRights;

    @AndroidFindBy(xpath = "//*[@class='android.view.ViewGroup' and ./*[@text='Invite Friends to Join SwaggRights']]")
    private MobileElement btnInviteFriends;

    @AndroidFindBy(xpath = "//*[@text=concat('Skip,I'll Add Friends Later')]")
    private MobileElement lnkSkipAddingFriends;

    private AndroidDriver androidDriver;

    public WelcomeScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public String getWelcomeText() {
        return lblWelcomeToSwaggRights.getText();
    }

    public String getBtnInviteFriends() {
      //  androidDriver.manage()..
        return btnInviteFriends.getText();
    }

    public String getLnkSkipAddingFriends() {
        return lnkSkipAddingFriends.getText();
    }
}
