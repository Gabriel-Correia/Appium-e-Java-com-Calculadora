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
    public static String[] emuladoresDisponiveis = {"Nexus_5X_API_29_x86"};

    private static final AppiumDriverLocalService appiumService = AppiumDriverLocalService.buildService(
            new AppiumServiceBuilder().usingDriverExecutable(new File("C://Program Files//nodejs//node.exe"))
                    .withAppiumJS(new File("C://Users//gabri//AppData//Local//Programs//Appium//resources//app//node_modules//appium//build//lib//main.js"))
    );

    public static void wait(AppiumDriver appiumDriver, int segundos) {
        appiumDriver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
    }

    public static AppiumDriver inicializarDriver(String enderecoURL, DesiredCapabilities desiredCapabilities) throws MalformedURLException {
        try {
            if (!Emulador.verificaEmulador()) {
                Emulador.novoEmulador(emuladoresDisponiveis[0]);
            }
            return appiumDriver = new AppiumDriver(new URL(enderecoURL), desiredCapabilities);
        } catch (Exception ex) {
            System.out.println("Servidor do Appium está desligado, tentando inicializar...");
            appiumService.start();
            return appiumDriver = new AppiumDriver(new URL(enderecoURL), desiredCapabilities);
        }
    }

    public static void finalizarDriver(AppiumDriver appiumDriver) {
        String idAparelho = appiumDriver.getCapabilities().getCapability("deviceID").toString();
        appiumDriver.quit();
        appiumService.stop();
        //Emulador.encerrarEmulador(idAparelho);
    }
}
