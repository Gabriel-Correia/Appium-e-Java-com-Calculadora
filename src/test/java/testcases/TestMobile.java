package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestMobile {

        public static AppiumDriver driver;

        public static void main(String[] args) throws MalformedURLException {

            AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
                    new AppiumServiceBuilder().usingDriverExecutable(new File("C://Program Files//nodejs//node.exe"))
                            .withAppiumJS(new File("C://Users//gabri//AppData//Local//Programs//Appium//resources//app//node_modules//appium//build//lib//main.js"))
            );

            service.start();

            DesiredCapabilities deviceCapabilities = new DesiredCapabilities();

            deviceCapabilities.setCapability("platformName", "Android");
            deviceCapabilities.setCapability("deviceName", "Redmi5");
            deviceCapabilities.setCapability("deviceID", "192.168.0.20:5555");
            deviceCapabilities.setCapability("automationName", "uiautomator2");
            deviceCapabilities.setCapability("appPackage", "com.miui.calculator");
            deviceCapabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");

            DesiredCapabilities appCapabilities = new DesiredCapabilities();

            driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub/"), deviceCapabilities);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.id("com.miui.calculator:id/btn_7_s")).click();
            driver.findElement(By.id("com.miui.calculator:id/btn_plus_s")).click();
            driver.findElement(By.id("com.miui.calculator:id/btn_3_s")).click();

            driver.quit();

            service.stop();
        }

    }

