package br.rafaelhorochovec.selenium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverUtil {

    private static DriverUtil driverUtil;
    private static WebDriver driver;
    public final static int TIMEOUT = 10;

    public WebDriver initializeDrivers(String browser) {

        final String gridURL = "http://localhost:4444";

        if (browser.equalsIgnoreCase("firefox")) {
            System.out.println("Testing on firefox");
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            //driver = new FirefoxDriver();
            try {
                driver = new RemoteWebDriver(new URL(gridURL), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.out.println("Testing on chrome");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            //driver = new ChromeDriver();
            try {
                driver = new RemoteWebDriver(new URL(gridURL), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else if (browser.equalsIgnoreCase("edge")) {
            System.out.println("Testing on Edge");
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");
            //driver = new EdgeDriver();
            try {
                driver = new RemoteWebDriver(new URL(gridURL), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        // Set Page load timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
        driver.get("https://rlhorochovec.github.io/qa/");
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void tearDown() {
        if(driver!=null) {
            driver.quit();
        }
        driverUtil = null;
    }
}