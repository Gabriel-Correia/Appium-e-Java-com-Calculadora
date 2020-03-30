package programas;

import core.Driver;
import core.Screenshot;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.io.IOException;

public class Calculadora {

    private String nomeApp = "Calculadora";

    public Calculadora (AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    private static AppiumDriver appiumDriver;

    private void tocarTecla(int numero) {

      //  if (numero <= -1 && numero >= -9) {
    //        appiumDriver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
     //       appiumDriver.findElement(By.id("com.google.android.calculator:id/digit_" + numero)).click();
    //    }

      //  else {
            char[] digits = String.valueOf(numero).toCharArray();



            for (int i = 0; i < digits.length; i++) {
                if (digits[0] == '-') {
                    appiumDriver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
                    digits = removeCaractere(digits);
                }
                appiumDriver.findElement(By.id("com.google.android.calculator:id/digit_" + digits[i])).click();
            }
     //   }

    }

    public char[] removeCaractere(char[] original)
    {
        char[] novo = new char[original.length-1];
        for (int i = 0; i < original.length; i++){
            if (i == 0)
                i++;
            novo[i] = original[i];
        }
        return novo;
    }

    private void tocarIgual(){
        appiumDriver.findElement(By.id("com.google.android.calculator:id/eq")).click();
    }

    // Falta tocar na tecla de Igual

    /**
     * Método Operacao retorna o resultado de uma operacao básica na Calculadora
     * @param tipoOperacao String com o tipo da Operacao (SOMA, SUBTRACAO, DIVISAO ou MULTIPLICACAO)
     * @param numero1 Primeiro numero a ser somado
     * @param numero2 Segundo numero a ser somado
     * @return resultado
     */
    public int operacao(String tipoOperacao, String cenarioTeste, int numero1, int numero2) throws IOException {
        Screenshot calculadoraScreenshot = new Screenshot(appiumDriver);
        tocarTecla(numero1);
        if (tipoOperacao.toUpperCase().equals("SOMA") ){
            appiumDriver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
            tocarTecla(numero2);
            tocarIgual();
            Driver.wait(5);
            calculadoraScreenshot.printarTela(nomeApp, cenarioTeste);
            return numero1 + numero2;
        }
        if (tipoOperacao.toUpperCase().equals("SUBTRACAO")){
            appiumDriver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
            tocarTecla(numero2);
            tocarIgual();
            Driver.wait(3);
            calculadoraScreenshot.printarTela(nomeApp, cenarioTeste);
            return numero1 - numero2;
        }
        if (tipoOperacao.toUpperCase() == "DIVISAO"){
            appiumDriver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
            tocarTecla(numero2);
            tocarIgual();
            Driver.wait(3);
            calculadoraScreenshot.printarTela(nomeApp, cenarioTeste);
            return numero1 / numero2;
        }
        if (tipoOperacao.toUpperCase() == "MULTIPLICACAO"){
            appiumDriver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
            tocarTecla(numero2);
            tocarIgual();
            Driver.wait(3);
            calculadoraScreenshot.printarTela(nomeApp, cenarioTeste);
            return numero1 * numero2;
        }
        // Quando vier string fora do padrao, retorna 0
        return 0;
    }



}