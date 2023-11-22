package br.rafaelhorochovec.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestRunner {
        WebDriver driver;
        @BeforeAll
        static void setupAll() {
                WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void setup() {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--start-maximized");
                options.addArguments("--incognito");
                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(options);
                driver.get("https://rlhorochovec.github.io/qa/");
        }

        @AfterEach
        void teardown() {
                driver.quit();
        }

        @Test
        void valida_login_admin() {
                driver.findElement(By.id("login")).sendKeys("admin");
                driver.findElement(By.id("senha")).sendKeys("admin");
                driver.findElement(By.xpath("/html/body/main/form/button")).click();
                String logado = driver.findElement(By.id("h2")).getText();
                Assertions.assertEquals("Administrador", logado);
        }

        @Test
        void valida_login_user() {
                driver.findElement(By.id("login")).sendKeys("user");
                driver.findElement(By.id("senha")).sendKeys("user");
                driver.findElement(By.xpath("/html/body/main/form/button")).click();
                String logado = driver.findElement(By.id("h2")).getText();
                Assertions.assertEquals("Usuário", logado);
        }

        @Test
        void valida_login_sem_senha() {
                driver.findElement(By.id("login")).sendKeys("user");
                driver.findElement(By.id("senha")).sendKeys("");
                driver.findElement(By.xpath("/html/body/main/form/button")).click();
                String erro = driver.findElement(By.id("erro")).getText();
                Assertions.assertEquals("Informe a senha!", erro);
        }

        @Test
        void valida_login_sem_usuario() {
                driver.findElement(By.id("login")).sendKeys("");
                driver.findElement(By.id("senha")).sendKeys("user");
                driver.findElement(By.xpath("/html/body/main/form/button")).click();
                String erro = driver.findElement(By.id("erro")).getText();
                Assertions.assertEquals("Informe o usuário!", erro);
        }

        @Test
        void valida_login_incorreto() {
                driver.findElement(By.id("login")).sendKeys("admin");
                driver.findElement(By.id("senha")).sendKeys("user");
                driver.findElement(By.xpath("/html/body/main/form/button")).click();
                String erro = driver.findElement(By.id("erro")).getText();
                Assertions.assertEquals("Usuário e/ou senha incorretos!", erro);
        }

        @Test
        void valida_login_em_branco() {
                driver.findElement(By.id("login")).sendKeys("");
                driver.findElement(By.id("senha")).sendKeys("");
                driver.findElement(By.xpath("/html/body/main/form/button")).click();
                String erro = driver.findElement(By.id("erro")).getText();
                Assertions.assertEquals("Informe usuário e senha!", erro);
        }
}