/*
This code defines a class Hooks with an @After method that runs after each scenario
to update the count using TestSuiteHelper.updateCount(). It also adds a shutdown hook to
perform cleanup actions when the JVM is shutting down.
*/

package test.java.steps;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import main.java.utility.TestSuiteHelper;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        TestSuiteHelper.updateCount(scenario.getStatus());
    }

    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }


}
