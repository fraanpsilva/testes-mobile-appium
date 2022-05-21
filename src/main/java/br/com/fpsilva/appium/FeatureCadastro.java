package br.com.fpsilva.appium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import br.com.fpsilva.appium.PageObject.CadastroPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;


public class FeatureCadastro {

    @Test
    public void cadastro_senhas_nao_conferem() throws MalformedURLException {
        AppiumDriver driver = AppiumDriverConfig.Instance().appiumDriver;

        // clicando no borão de cadastrar
        MobileElement botaoCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);
        telaCadastro.bucasElementos();
        telaCadastro.cadastrar("Ana", "123", "456");

        Assert.assertEquals("Senhas não conferem", telaCadastro.mensagemErro());

        driver.navigate().back(); // voltando para a tela anterior da que estava


    }

    @Test
    public void cadastro_senhas_que_conferem() throws MalformedURLException {
        AppiumDriver driver = AppiumDriverConfig.Instance().appiumDriver;

        MobileElement botaoCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);
        telaCadastro.bucasElementos();
        telaCadastro.cadastrar("Ana", "123", "123");

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
