package br.rafaelhorochovec.selenium.steps;

import br.rafaelhorochovec.selenium.pages.HomePage;
import io.cucumber.java.pt.Então;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Então("valido que estou logado como {string}")
    public void validoQueEstouLogadoComo(String logado) {
        homePage.validarHome(logado);
    }
}
