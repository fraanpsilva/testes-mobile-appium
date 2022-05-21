package br.com.fpsilva.appium.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;

// classe de busca de elementos
public class CadastroPageObject {
    private AppiumDriver driver;

    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoConfirmarCadastro;
    private MobileElement mensagemErro;

    public CadastroPageObject( AppiumDriver driver ) {
        this.driver = driver;
    }

    public void bucasElementos(){
        campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmarSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoConfirmarCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");

    }

    private void preencherFormulario(String usuario, String senha, String confirmarSenha){
        campoNome.setValue(usuario);
        campoSenha.setValue(senha);
        campoConfirmarSenha.setValue(confirmarSenha);

    }

    public void cadastrar(String usuario, String senha, String confirmarSenha){
        preencherFormulario(usuario, senha, confirmarSenha);
        botaoConfirmarCadastro.click();

    }

    public String mensagemErro(){
        mensagemErro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");
        return mensagemErro.getText();
    }


}
