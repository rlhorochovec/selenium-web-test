package br.rafaelhorochovec.selenium.pages;

import br.rafaelhorochovec.selenium.locators.LoginLocators;
import org.openqa.selenium.support.PageFactory;

import static br.rafaelhorochovec.selenium.core.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {

    LoginLocators loginLocators;
    public LoginPage() {
        this.loginLocators = new LoginLocators();
        PageFactory.initElements(getDriver(), loginLocators);
    }
    public void efetuarLogin(String usuario, String senha) {
        loginLocators.login.sendKeys(usuario);
        loginLocators.senha.sendKeys(senha);
    }

    public void clicaEntrar() {
        loginLocators.entrar.click();
    }

    public void validaMensagem(String mensagem) {
        String erro = loginLocators.erro.getText();
        assertEquals(mensagem, erro);
    }
}
