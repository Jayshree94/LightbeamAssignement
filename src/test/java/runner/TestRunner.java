/*
This code defines a test runner class TestRunner in the package runner.
It configures Cucumber options for feature files location, step definitions package, and plugins.
It also sets up Extent report properties before the test execution and loads XML configuration
for the Extent report after the test execution.
 */
package test.java.runner;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import main.java.constants.Constant;
import main.java.utility.TestSuiteHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;


@CucumberOptions(features = {"src/test/java/features/"},
        glue = {"test/java/steps"}, plugin = {"com.cucumber.listener.ExtentCucumberFormatter:", "html:Report"})
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath(TestSuiteHelper.getReportPath());
    }

    @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File(Constant.PROJECTPATH + File.separatorChar + "ReportsConfig.xml"));

    }
}
