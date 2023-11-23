package br.rafaelhorochovec.selenium.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",
        features = {"src/test/resources/features/login.feature"},
        glue = {"br.rafaelhorochovec.selenium.steps"},
        plugin= {"pretty", "html:test-output","json:target/cucumber/cucumber.json", "html:target/cucumber-html-report"})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

}