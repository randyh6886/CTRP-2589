package com.example;
// As an abstractor, I shall be able to search for Active trials in CTRP
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
// As an Abstractor I shall be able to search for Active trials in CTRP
@CucumberOptions(
        plugin= {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        features={"src/test/resources/features/browseToURL.feature", "src/test/resources/features/activeTrials.feature"},
        glue={"com.example.Steps"}
)
public class TestRunner extends AbstractTestNGCucumberTests{
}
