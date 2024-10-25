package cucumberTest;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		//format = {"pretty", "json:target/cucumber.json","pretty","html:target/cucumber"},
		plugin = {"pretty",
						"html:target/cucumber/report.html",
						"json:results/cucumber.json",
						"junit:results/cucumber.xml"
						},
		features = {"src/test/resources/MyFeaturesFilesDemo/GoogleBDD.feature"},
		glue = { "packBDDSteps"},
		tags = "@Google"
)

public class MyCucumberRun extends AbstractTestNGCucumberTests

{
//@BeforeTest
//public void first()
//{
//	driver=new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	wait=new WebDriverWait(driver,Duration.ofSeconds(20));
//	
//}
//
//@AfterTest
//public void last()
//{
//	System.out.println("last");
//}
	
@Test
public void test()
{
	System.out.println("TEST");
}
}
