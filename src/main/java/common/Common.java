/*
This code defines a package main.java.common with two nested static classes TestCount and ApiExecutorClass.
The TestCount class contains static variables to hold counts for pass, fail, and skip scenarios.
The ApiExecutorClass class contains static variables for storing a bearer token and response data in JSON format.
 */

package main.java.common;

import org.json.JSONArray;

import io.restassured.response.Response;


public class Common {

    public static class TestCount {
        public static int PASSCOUNT;
        public static int FAILCOUNT;
        public static int SKIPCOUNT;
    }

    public static class ApiExecutorClass {
        public static String BEARERTOKEN;
        public static JSONArray RESPONSEDATA;
        public static Response RESPONSE;
    }


}
