package br.rafaelhorochovec.selenium.hooks;

import br.rafaelhorochovec.selenium.core.ConfigReader;
import br.rafaelhorochovec.selenium.core.DriverUtil;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public static void before() throws Throwable {
        //Get browser Type from config file
        System.out.println("Loading Config file");
        //ConfigReader.loadConfig();
        String browser = ConfigReader.getBrowserType();

        //Initialize driver from driver factory
        DriverUtil driverUtil = new DriverUtil();
        WebDriver driver = driverUtil.initializeDrivers(browser);
        System.out.println("Initializing driver for: "+browser);
    }

    @After
    public static void tearDown(Scenario scenario) {
        //validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverUtil.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        DriverUtil.tearDown();
    }
}