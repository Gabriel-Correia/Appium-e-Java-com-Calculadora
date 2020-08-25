package core;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    private static AppiumDriver driver;

    public Screenshot (AppiumDriver driver) {
        this.driver = driver;
    }
    public void printarTela(String app, String cenarioTeste, int numeroPrint) throws IOException {
        File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile (file, new File("C:/Users/gabri/Pictures/Appium/" + app + "/" + cenarioTeste + "/" + cenarioTeste + numeroPrint + ".jpg"));

    }



}
