package org.example.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
        features = "src/test/java/org/example/features",
        glue = {"org.example.steps",
                "org.example.hooks"})
public class TestRunner {
}
