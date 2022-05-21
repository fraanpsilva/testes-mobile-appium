package br.com.fpsilva.appium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.appium.java_client.MobileElement;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;


public class FeatureCadastro {

    @Test
    public void cadastro_senhas_nao_conferem() throws MalformedURLException {
        DriverConfig driver = new DriverConfig();

        // clicando no borão de cadastrar
        MobileElement botaoCadastro = (MobileElement) driver.appiumDriver
                .findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();
        MobileElement campoNome = (MobileElement) driver.appiumDriver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        campoNome.setValue("Francilene");

        MobileElement campoSenha = (MobileElement) driver.appiumDriver
                .findElementById("br.com.alura.aluraesporte:id/input_senha");
        campoSenha.setValue("123");

        MobileElement campoConfirmarSenha = (MobileElement) driver.appiumDriver
                .findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        campoConfirmarSenha.setValue("456");

        MobileElement botaoConfirmarCadastro = (MobileElement) driver.appiumDriver
                .findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        botaoConfirmarCadastro.click();

        MobileElement erro = (MobileElement) driver.appiumDriver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");
        assertEquals("Senhas não conferem", erro.getText());




        /* para encontrar os elementos no app, utiliza-se o UiAutomatorViewer, que se encontra na pasta
         sdk/tools/bin

         Um MobileElement representa os elementos da tela e podemos fazer qualquer interação que uma pessoa mexendo no
         aplicativo também seria capaz
         */

    }
}
