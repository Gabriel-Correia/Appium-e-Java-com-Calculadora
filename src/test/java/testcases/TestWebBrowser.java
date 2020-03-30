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

        Driver.iniciarAppium();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Redmi9");
        capabilities.setCapability("deviceID", "023c69fc0005");
        capabilities.setCapability("automationName", "uiautomator2");

        androidDriver = (AndroidDriver) driver.inicializarDriver("http://0.0.0.0:4723/wd/hub/", capabilities);
        androidDriver.get("http://google.com");
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        androidDriver.findElement(By.name("q")).sendKeys("Hello Appium!");

        androidDriver.quit();

        Driver.encerrarAppium();
    }

}
