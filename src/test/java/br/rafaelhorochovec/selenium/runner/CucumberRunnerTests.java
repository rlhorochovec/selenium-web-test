package br.rafaelhorochovec.selenium.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",
        features = {"src/test/resources/features/login.feature"},
        glue = {"br.rafaelhorochovec.selenium.steps"},
        plugin = {})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

}