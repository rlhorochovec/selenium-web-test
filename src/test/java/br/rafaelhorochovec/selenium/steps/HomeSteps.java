package br.rafaelhorochovec.selenium.steps;

import br.rafaelhorochovec.selenium.pages.HomePage;
import io.cucumber.java.pt.Então;

public class HomeSteps {

    HomePage homePage = new HomePage();
    @Então("apresentará a home do {string}")
    public void apresentará_a_home_do(String logado) {
        homePage.validaHome(logado);
    }
}
