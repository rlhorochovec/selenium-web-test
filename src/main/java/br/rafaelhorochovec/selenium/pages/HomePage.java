package br.rafaelhorochovec.selenium.pages;

import br.rafaelhorochovec.selenium.core.DriverUtil;
import br.rafaelhorochovec.selenium.locators.HomeLocators;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class HomePage {

    HomeLocators homeLocators ;

    public HomePage() {
        this.homeLocators = new HomeLocators();
        PageFactory.initElements(DriverUtil.getDriver(), homeLocators);
    }

    public void validarHome(String logado) {
        String titulo = homeLocators.titulo.getText();
        assertEquals(titulo, logado);
    }
}