package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Emulador {

    public static void novoEmulador(String nomeEmulador) {
        try
        {
            Runtime.getRuntime().exec("cmd /c start cmd.exe /C \"cd C:\\AndroidSDK\\emulator\\ && emulator -avd "+ nomeEmulador + "\"");

        }
        catch (Exception e)
        {
            System.out.println("Ops, algo deu errado ao instanciar o Emulador");
            e.printStackTrace();
        }
    }
    public static boolean verificaEmulador() {
          try {
              ProcessBuilder processBuilder = new ProcessBuilder();
              processBuilder.command("cmd.exe", "/c", "emulator -avd ping");
              //String command = "cmd /c start cmd.exe /K \"cd C:\\AndroidSDK\\emulator\\ && emulator -avd ping \"";
              Process p = processBuilder.directory(new File("C:/AndroidSDK/emulator/")).start();

              BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

              String line;
              while ((line = reader.readLine()) != null) {
                  if (line.contains("ERROR: Unknown AVD name [pin], use -list-avds to see valid list.")) {
                      System.out.println("Nenhum emulador disponível, instanciando um novo...");
                      return false;
                  }
                  System.out.println(line);
              }
          }
            catch (Exception err) {
                err.printStackTrace();
            }

        return true;
    }

    public static void encerrarEmulador(String deviceId) {
        try
        {
            Runtime.getRuntime().exec("cmd /c start cmd.exe /C \"cd C:\\AndroidSDK\\platform-tools\\ && adb -s " + deviceId + " emu kill \"");

        }
        catch (Exception e)
        {
            System.out.println("Ops, algo deu errado ao desligar o Emulador");
            e.printStackTrace();
        }
    }


}
