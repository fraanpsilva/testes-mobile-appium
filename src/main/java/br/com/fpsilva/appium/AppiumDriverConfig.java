package br.com.fpsilva.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverConfig {


    public final AppiumDriver appiumDriver;
    private static AppiumDriverConfig _instance;

    // garantindo que o a instanciação do appium driver seja chamado duas vezes
    public static AppiumDriverConfig Instance(){
        if (AppiumDriverConfig._instance == null){
            AppiumDriverConfig._instance = new AppiumDriverConfig();

        }
        return AppiumDriverConfig._instance;
    }

    private AppiumDriverConfig() {
        BasicConfigurator.configure(); // configuração do log4j

        // configurando o driver do appium
        // informando onde está o arquivo apk
        File apk = new File("/Users/francilenesilva/Documents/Java/android/testes-mobile/alura-appium/src/main/resources/alura_esporte.apk");

        // configurando as capabilities
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath()); // informando o rippo de capability
        // informando a plataforma que será usada
        config.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        // informando o driver de automação
        config.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        URL urlConexao = null; // endereço do servidor appium
        try {
            urlConexao = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        appiumDriver = new AppiumDriver(urlConexao, config);
    }

    /*
    * Singleton: garante que tenha uma única instancia de um objeto
    * e que eu tenha acesso global para essa instância: */

}
