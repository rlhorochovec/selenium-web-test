package br.rafaelhorochovec.selenium.steps;

import br.rafaelhorochovec.selenium.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Dado("que inseri usuário {string} e senha {string}")
    public void que_inseri_usuário_e_senha(String usuario, String senha) {
        loginPage.efetuarLogin(usuario, senha);
    }
    @Quando("clicar no botão Entrar")
    public void clicar_no_botão_entrar() {
        loginPage.clicarEntrar();
    }
    @Então("apresentará uma mensagem de {string}")
    public void apresentará_uma_mensagem_de(String mensagem) {
        loginPage.validarMensagem(mensagem);
    }
}
