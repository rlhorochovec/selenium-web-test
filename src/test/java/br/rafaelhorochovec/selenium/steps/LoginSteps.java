package br.rafaelhorochovec.selenium.steps;

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
    public static WebDriver driver;
    public final static int TIMEOUT = 5;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.get("https://rlhorochovec.github.io/qa/");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Dado("que inseri usuário {string} e senha {string}")
    public void que_inseri_usuário_e_senha(String usuario, String senha) {
        driver.findElement(By.id("login")).sendKeys(usuario);
        driver.findElement(By.id("senha")).sendKeys(senha);
    }
    @Quando("clicar no botão Entrar")
    public void clicar_no_botão_entrar() {
        driver.findElement(By.xpath("/html/body/main/form/button")).click();
    }
    @Então("apresentará uma mensagem de {string}")
    public void apresentará_uma_mensagem_de(String mensagem) {
        String erro = driver.findElement(By.id("erro")).getText();
        Assert.assertEquals(erro, mensagem);
    }
}
