package br.rafaelhorochovec.selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;
    private static int DEFAULT_WAIT_TIME = 5;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://rlhorochovec.github.io/qa/");
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
    }

    public static void shutdownDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}