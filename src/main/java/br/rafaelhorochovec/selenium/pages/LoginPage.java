package br.rafaelhorochovec.selenium.pages;

import br.rafaelhorochovec.selenium.core.DriverUtil;
import br.rafaelhorochovec.selenium.locators.LoginLocators;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class LoginPage {

    LoginLocators loginLocators;

    public LoginPage() {
        this.loginLocators = new LoginLocators();
        PageFactory.initElements(DriverUtil.getDriver(), loginLocators);
    }

    public void validarMensagem(String mensagem) {
        String erro = loginLocators.erro.getText();
        assertEquals(erro, mensagem);
    }

    public void efetuarLogin(String usuario, String senha) {
        loginLocators.login.sendKeys(usuario);
        loginLocators.senha.sendKeys(senha);
    }

    public void clicarEntrar() {
        loginLocators.entrar.click();
    }
}