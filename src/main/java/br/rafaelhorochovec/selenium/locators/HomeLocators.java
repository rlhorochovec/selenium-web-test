package br.rafaelhorochovec.selenium.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeLocators {

    @FindBy(xpath = "//*/div/div/div/h1")
    public WebElement titulo;
}
