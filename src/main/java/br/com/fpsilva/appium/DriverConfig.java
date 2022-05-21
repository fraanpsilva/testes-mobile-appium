package br.com.fpsilva.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverConfig {
    public final AppiumDriver appiumDriver;

    public DriverConfig() throws MalformedURLException {
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

        URL urlConexao = new URL("http://127.0.0.1:4723/wd/hub"); // endereço do servidor appium
        appiumDriver = new AppiumDriver(urlConexao, config);
    }

}
