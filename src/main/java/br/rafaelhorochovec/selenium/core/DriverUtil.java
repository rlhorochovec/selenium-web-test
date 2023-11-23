package br.rafaelhorochovec.selenium.core;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtil {

    private static DriverUtil driverUtil;
    private static WebDriver driver;
    public final static int TIMEOUT = 5;

    private DriverUtil() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        openPage("https://rlhorochovec.github.io/qa/");
    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
        if (driverUtil==null) {
            driverUtil = new DriverUtil();
        }
    }

    public static void tearDown() {
        if(driver!=null) {
            driver.close();
            driver.quit();
        }
        driverUtil = null;
    }
}