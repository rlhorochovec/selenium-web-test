package br.rafaelhorochovec.selenium.steps;

import br.rafaelhorochovec.selenium.core.DriverUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public static void setUp() {
        DriverUtil.setUpDriver();
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