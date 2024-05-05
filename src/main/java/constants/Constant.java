package main.java.constants;


import java.io.File;

public class Constant {

    public static final String PROJECTPATH = System.getProperty("user.dir");

    // Give the report Name and Path
    public static class ExtentManagerConstant {
        public static final String TESTCASENAME = "API Script";
        public static final String REPORTSPATH = PROJECTPATH + File.separatorChar + "Reports" + File.separatorChar;
    }

    public static class CONFIGFILECONSTANT {
        public static final String FILEPATH = PROJECTPATH + File.separatorChar + "config.properties";
    }

    /* Here your getting the no of passed and failed test cases count .. Which you can send into your slack channel
     * So that non tech user will also get the status of report without opening it*/
    public static class ExtentTestResult {
        public static final String PASSTEST = "passed";
        public static final String FAILTEST = "failed";
        public static final String SKIPTEST = "skiped";
    }

    public static class ApiTestConstants {
        public static final String USERIDKEY = "userNameKey";
        public static final String PASSWORDKEY = "passwordKey";
        public static final String CONTENTTYPEKEY = "Content-Type";
        public static final String CONTENTTYPEVALUE = "application/json";

        public static final String BAREARTOKEN="Authorization";
    }


}


