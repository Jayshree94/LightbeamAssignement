package main.java.utility;

import com.cucumber.listener.Reporter;
import io.restassured.response.Response;
import main.java.common.Common;
import main.java.constants.Constant;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class TestSuiteHelper {

    public static String fileName = "";

    public static void verifyApiResponse(Response resp) {
        Reporter.addStepLog("Response -----------------------> " + resp.getBody().asString());
        Assert.assertEquals(resp.getStatusCode(), 200);
    }

    public static void updateCount(String status) {
        if (status.equalsIgnoreCase(Constant.ExtentTestResult.PASSTEST)) {
            Common.TestCount.PASSCOUNT++;
        } else if (status.equalsIgnoreCase(Constant.ExtentTestResult.FAILTEST)) {
            Common.TestCount.FAILCOUNT++;
        } else if (status.equalsIgnoreCase(Constant.ExtentTestResult.SKIPTEST)) {
            Common.TestCount.SKIPCOUNT++;
        }
    }

    public static String getReportPath() {
        String testName = Constant.ExtentManagerConstant.TESTCASENAME;
        Date date = new Date();
        fileName = date.toString().replace(":", "_").replace(" ", "_") + "_" +
                testName + "_" + ".html";
        String reportPath = Constant.ExtentManagerConstant.REPORTSPATH + fileName;
        return reportPath;
    }

    public static String getValueFromFile(String key) throws IOException {
        FileReader reader = new FileReader(Constant.CONFIGFILECONSTANT.FILEPATH);
        Properties properties = new Properties();
        properties.load(reader);
        String val = properties.getProperty(key);
        return val;

    }

    public static String getFileName() {
        return fileName;
    }


}
