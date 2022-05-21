package br.com.fpsilva.appium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Test;

import java.net.MalformedURLException;


public class FeatureCadastro {

    @Test
    public void cadastro_senhas_nao_conferem() throws MalformedURLException {
        AppiumDriver driver = AppiumDriverConfig.Instance().appiumDriver;

        // clicando no borão de cadastrar
        MobileElement botaoCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();
        MobileElement campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        campoNome.setValue("Francilene");

        MobileElement campoSenha = (MobileElement) driver
                .findElementById("br.com.alura.aluraesporte:id/input_senha");
        campoSenha.setValue("123");

        MobileElement campoConfirmarSenha = (MobileElement) driver
                .findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        campoConfirmarSenha.setValue("456");

        MobileElement botaoConfirmarCadastro = (MobileElement) driver
                .findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        botaoConfirmarCadastro.click();

        MobileElement erro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");
        assertEquals("Senhas não conferem", erro.getText());

        driver.navigate().back(); // voltando para a tela anterior da que estava


    }

    @Test
    public void cadastro_senhas_que_conferem() throws MalformedURLException {
        AppiumDriver driver = AppiumDriverConfig.Instance().appiumDriver;

        // clicando no borão de cadastrar
        MobileElement botaoCadastro = (MobileElement) driver
                .findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        MobileElement campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        campoNome.setValue("Francilene");

        MobileElement campoSenha = (MobileElement) driver
                .findElementById("br.com.alura.aluraesporte:id/input_senha");
        campoSenha.setValue("123");

        MobileElement campoConfirmarSenha = (MobileElement) driver
                .findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        campoConfirmarSenha.setValue("123");

        MobileElement botaoConfirmarCadastro = (MobileElement) driver
                .findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        botaoConfirmarCadastro.click();
//
        MobileElement botaoLogar = (MobileElement) driver
                .findElementById("br.com.alura.aluraesporte:id/login_botao_logar");


    }




        /* para encontrar os elementos no app, utiliza-se o UiAutomatorViewer, que se encontra na pasta
         sdk/tools/bin

         Um MobileElement representa os elementos da tela e podemos fazer qualquer interação que uma pessoa mexendo no
         aplicativo também seria capaz
         */

}
