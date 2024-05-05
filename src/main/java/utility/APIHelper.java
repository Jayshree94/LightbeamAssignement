package main.java.utility;

import com.cucumber.listener.Reporter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIHelper {

    public static Response apiGet(String url, Map<String, String> headers, Map<String, String> params) {
        Reporter.addStepLog("URL is --->" + url);
        Reporter.addStepLog("Header is --->" + headers);
        Reporter.addStepLog("Params is --->" + params);
        Response resp = null;
        RequestSpecification rs = given().contentType("application/json").headers(headers).params(params);
        resp = rs.when().get(url).then().extract().response();
        return resp;
    }

    public static Response apiPost(String url, Map<String, String> headers, JSONObject data) {
        Reporter.addStepLog("URL is --->" + url);
        Reporter.addStepLog("Header is --->" + headers);
        Reporter.addStepLog("Data is --->" + data);
        Response resp = null;
        RequestSpecification rs = given().contentType("application/json").headers(headers).body(data.toMap());
        resp = rs.when().post(url).then().extract().response();
        return resp;
    }

    public static Response apiPut(String url, Map<String, String> headers, Map<String, Object> data) {
        Reporter.addStepLog("URL is --->" + url);
        Reporter.addStepLog("Header is --->" + headers);
        Reporter.addStepLog("Data is --->" + data);
        Response resp = null;
        RequestSpecification rs = given().contentType("application/json").headers(headers).body(data);
        resp = rs.when().put(url).then().extract().response();
        return resp;
    }


}
