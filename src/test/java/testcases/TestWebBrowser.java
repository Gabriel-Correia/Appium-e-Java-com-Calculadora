package testcases;

import core.Driver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class TestWebBrowser {

    public static AndroidDriver androidDriver;
    public static Driver driver;



    public static void main(String[] args) throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Redmi5");
        capabilities.setCapability("deviceID", "emulator-5554");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        androidDriver = (AndroidDriver) Driver.inicializarDriver("http://0.0.0.0:4723/wd/hub/", capabilities);
        androidDriver.get("http://google.com");
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        androidDriver.findElement(By.name("q")).sendKeys("Hello Appium!");

        androidDriver.quit();

    }

}
