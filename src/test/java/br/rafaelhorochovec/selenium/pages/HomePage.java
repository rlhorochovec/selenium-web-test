package br.rafaelhorochovec.selenium.pages;

import br.rafaelhorochovec.selenium.locators.HomeLocators;
import org.openqa.selenium.support.PageFactory;

import static br.rafaelhorochovec.selenium.core.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {

    HomeLocators homeLocators;
    public HomePage() {
        this.homeLocators = new HomeLocators();
        PageFactory.initElements(getDriver(), homeLocators);
    }
    public void validaHome(String logado) {
        String titulo = homeLocators.titulo.getText();
        assertEquals(logado, titulo);
    }
}
