package br.rafaelhorochovec.selenium.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLocators {

    @FindBy(id = "login")
    public WebElement login;

    @FindBy(id = "senha")
    public WebElement senha;

    @FindBy(id = "erro")
    public WebElement erro;

    @FindBy(xpath = "/html/body/main/form/button")
    public WebElement entrar;
}