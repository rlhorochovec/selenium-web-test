package br.rafaelhorochovec.selenium.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static br.rafaelhorochovec.selenium.core.Driver.createChromeDriver;
import static br.rafaelhorochovec.selenium.core.Driver.shutdownDriver;

@CucumberOptions(
        tags = "",
        features = "src/test/resources/features/login.feature",
        glue = "br.rafaelhorochovec.selenium.steps",
        plugin= {"pretty",
                "json:target/cucumber-report-json/cucumber.json",
                "html:target/cucumber-report-html/cucumber.html"},
        monochrome = false,
        dryRun = false)
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    @BeforeMethod
    public void setUp() {
        createChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        shutdownDriver();
    }
}