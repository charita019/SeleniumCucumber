package runners;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features =  "E:\\Charita\\Study\\GitSelenium\\SeleniumCucumberVSCode\\saucedemo\\src\\test\\java\\features\\Login.feature",
    glue = "stepdefinitions",
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests{
    
}
