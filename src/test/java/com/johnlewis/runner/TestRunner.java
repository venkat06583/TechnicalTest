package com.johnlewis.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = {"com.johnlewis.stepdefinitions"},
        tags = "@Product"
)
public class TestRunner {
}

