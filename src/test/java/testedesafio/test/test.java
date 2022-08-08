package testedesafio.test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
			tags = "@test02",
			features = "src/test/resources/features/",
			glue = "steps",
			plugin = {
					"pretty",
					"html:target/Relatorio-html.html"
			})

public class test {

}

