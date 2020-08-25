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

        if (numero < 0) {
            numero = numero * -1; // converte para positivo
            appiumDriver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
            converteEmDigito(numero);
        } else {
            appiumDriver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
            if (numero <= 9 && numero > 1) {
                appiumDriver.findElement(By.id("com.google.android.calculator:id/digit_" + numero)).click();
            }
            else {
                converteEmDigito(numero);
            }
        }

    }
    private void converteEmDigito(int numero) {
            String numeroConvertido = String.valueOf(numero);
            for(int i = 0; i < numeroConvertido.length(); i++) {
                int digitoExtraido = Character.digit(numeroConvertido.charAt(i), 10);
                appiumDriver.findElement(By.id("com.google.android.calculator:id/digit_" + digitoExtraido)).click();
            }
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
        calculadoraScreenshot.printarTela(nomeApp, cenarioTeste, 1);
        if (tipoOperacao.toUpperCase().equals("SOMA") ){
            calculadoraScreenshot.printarTela(nomeApp, cenarioTeste, 2);
            tocarTecla(numero2);
            tocarIgual();
            Driver.wait(appiumDriver, 5);
            calculadoraScreenshot.printarTela(nomeApp, cenarioTeste, 3);
            return numero1 + numero2;
        }
        if (tipoOperacao.toUpperCase().equals("SUBTRACAO")){
            tocarTecla(numero2);
            tocarIgual();
        //    Driver.wait(3);
        //    calculadoraScreenshot.printarTela(nomeApp, cenarioTeste);
            return numero1 - numero2;
        }
        if (tipoOperacao.toUpperCase().equals("DIVISAO") ){
            appiumDriver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
            tocarTecla(numero2);
            tocarIgual();
         //   Driver.wait(3);
         //   calculadoraScreenshot.printarTela(nomeApp, cenarioTeste);
            return numero1 / numero2;
        }
        if (tipoOperacao.toUpperCase().equals("MULTIPLICACAO")){
            appiumDriver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
            tocarTecla(numero2);
            tocarIgual();
       //     Driver.wait(3);
       //     calculadoraScreenshot.printarTela(nomeApp, cenarioTeste);
            return numero1 * numero2;
        }
        // Quando vier string fora do padrao, retorna 0
        return 0;
    }



}