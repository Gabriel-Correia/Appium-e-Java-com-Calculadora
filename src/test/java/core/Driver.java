package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static AppiumDriver appiumDriver;

    private static final AppiumDriverLocalService appiumService = AppiumDriverLocalService.buildService(
            new AppiumServiceBuilder().usingDriverExecutable(new File("C://Program Files//nodejs//node.exe"))
                    .withAppiumJS(new File("C://Users//gabri//AppData//Local//Programs//Appium//resources//app//node_modules//appium//build//lib//main.js"))
    );

    public static void iniciarAppium(){
        appiumService.start();
    }

    public static void encerrarAppium(){
        appiumService.stop();
    }

    public static void wait(int segundos) {
        appiumDriver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
    }

    public static AppiumDriver inicializarDriver(String enderecoURL, DesiredCapabilities desiredCapabilities) throws MalformedURLException {
        appiumDriver = new AppiumDriver(new URL(enderecoURL), desiredCapabilities);
        return appiumDriver;
    }
}
