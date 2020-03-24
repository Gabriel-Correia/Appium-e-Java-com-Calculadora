package testcases;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestWebBrowser {

    public static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Redmi9");
        capabilities.setCapability("deviceID", "023c69fc0005");
        capabilities.setCapability("automationName", "uiautomator2");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);

        driver.get("http://google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.name("q")).sendKeys("Hello Appium!");

        driver.quit();
    }

}
