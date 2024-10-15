package br.rafaelhorochovec.selenium.runner;

import br.rafaelhorochovec.selenium.core.ConfigReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


@CucumberOptions(tags = "",
        features = {"src/test/resources/features/"},
        glue = {"br.rafaelhorochovec.selenium.steps", "br.rafaelhorochovec.selenium.hooks"},
        plugin= {"pretty", "html:target/test-output.html","json:target/cucumber/cucumber.json", "html:target/cucumber-html-report", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters({ "browser" })
    public void defineBrowser(String browser) throws Throwable {
        ConfigReader.setBrowserType(browser);
    }

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}