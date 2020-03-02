package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SwaggrightBase {
    static AndroidDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeSuite
    public void setUpAppium() throws MalformedURLException {

        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

        URL url = new URL(URL_STRING);

        //Use a empty DesiredCapabilities object
        capabilities = new DesiredCapabilities();

        driver = new AndroidDriver<AndroidElement>(url, capabilities);

        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
    }

    //Use the below method while runing locally
   // @BeforeSuite(alwaysRun = true)
    public void setUpAppiumServer() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Galaxy A50");
        caps.setCapability("udid", "RZ8M51G23GP"); //Give Device ID of your mobile phone
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("appPackage", "com.swaggrights.swagg");
        caps.setCapability("appActivity", "host.exp.exponent.MainActivity");
        caps.setCapability("noReset", "true");

        //Instantiate Appium Driver
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public AndroidDriver getAndroidDriver() {
        return this.driver;
    }

    @AfterSuite
    public void teardown() {
        getAndroidDriver().quit();
    }
}
