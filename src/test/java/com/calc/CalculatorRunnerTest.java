package com.calc;


import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by cubanguy on 5/24/14.
 */

@RunWith(Cucumber.class)
@Cucumber.Options(format={"pretty", "html:target/cucumber","json:target/integration_cucumber.json"},
// tags={"@run"})//what tags to include(@)/exclude(@~)
features ="src/test/stories/com/calc") //change here to
public class CalculatorRunnerTest {
}
