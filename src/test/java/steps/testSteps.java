package test.java.steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.jayway.jsonpath.JsonPath;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.JSONParser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.java.common.Common;
import main.java.constants.Constant;
import main.java.utility.APIHelper;
import main.java.utility.TestSuiteHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static main.java.utility.TestSuiteHelper.getValueFromFile;

public class testSteps {

    @Given("^I set Post login api endpoint$")
    public String setPostEndpoint() throws IOException {
        String base_uri = getValueFromFile("Base_URL");
        String endPoint = getValueFromFile("Login_End_Point");
        String URL = base_uri + endPoint;
        return URL;
    }

    @When("^I set the request header for login$")
    public Map<String, String> setHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put(Constant.ApiTestConstants.CONTENTTYPEKEY, Constant.ApiTestConstants.CONTENTTYPEVALUE);
        return headers;
    }

    @And("^I set the request body$")
    public JSONObject setRequestBody() throws IOException {
        JSONObject json = new JSONObject();
        json.put(Constant.ApiTestConstants.USERIDKEY, getValueFromFile("userName"));
        json.put(Constant.ApiTestConstants.PASSWORDKEY, getValueFromFile("password"));
        return json;
    }

    @And("^Sends post HTTP request for login$")
    public Response setLoginAPI() throws IOException {
        Response resp = APIHelper.apiPost(setPostEndpoint(), setHeaders(), setRequestBody());
        Common.ApiExecutorClass.BAREARTOKEN = JsonPath.read(resp.asString(), "$.responseData.Bearer_token");
        return resp;
    }

    @Then("^I received valid HTTP response code 200$")
    public void verifyStatusCode() throws IOException {
        TestSuiteHelper.verifyApiResponse(setLoginAPI());
    }

    @When("^I set the request header for get request$")
    public Map<String, String> iSetTheRequestHeaderForGetRequest() {
        Map<String, String> headers = new HashMap<>();
        headers.put(Constant.ApiTestConstants.CONTENTTYPEKEY, Constant.ApiTestConstants.CONTENTTYPEVALUE);
        return headers;
    }
    @Given("^I set the url for search API$")
    public String setUrlForSearchAPI() throws IOException {
        String base_uri = getValueFromFile("Base_URL");
        String endPoint = getValueFromFile("Search_End_Point");
        String URL = base_uri + endPoint;
        return URL;
    }

    @And("^I set the params for search API$")
    public Map<String, String> iSetTheParamsForSearchAPI() throws IOException {
        Map<String, String> json = new HashMap<>();
        json.put("type", getValueFromFile("Document_Type"));
        json.put("offset", String.valueOf(0));
        json.put("limit", String.valueOf(10));
        return json;
    }

    @When("^I set the headers for search api$")
    public Map<String, String> setTheHeadersForSearchAPI() {
        Map<String, String> headers = new HashMap<>();
        headers.put(Constant.ApiTestConstants.CONTENTTYPEKEY, Constant.ApiTestConstants.CONTENTTYPEVALUE);
        headers.put(Constant.ApiTestConstants.BAREARTOKEN, Common.ApiExecutorClass.BAREARTOKEN);
        return headers;
    }


    @Then("^the API should return the correct results count$")
    public void theAPIShouldReturnTheCorrectResultsCount() {
        JSONArray responseData = Common.ApiExecutorClass.RESPONSEDATA;
        int expectedCount = 12;
        int resultCount = responseData.length();
        Assert.assertEquals(resultCount, expectedCount);
    }
    @And("^the user fires a search query for <searchQuery>$")
    public void theUserFiresASearchQueryForSearchQuery() throws IOException {
        RequestSpecification rs = null;
        try {
            rs = given().contentType("application/json").headers(setTheHeadersForSearchAPI()).
                    params(iSetTheParamsForSearchAPI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Response resp = rs.when().get(setUrlForSearchAPI()).then().extract().response();
        JSONArray responseData = JsonPath.read(resp.asString(), "$.responseData");
        Common.ApiExecutorClass.RESPONSEDATA = responseData;
        throw new PendingException();
    }

    @Then("^the API should return search results with all values with same name \"([^\"]*)\"$")
    public void theAPIShouldReturnSearchResultsWithAllValuesWithSameName(String documentName) {
        JSONArray responseData = Common.ApiExecutorClass.RESPONSEDATA;
        for (int i = 0; i < responseData.length(); i++) {
            JSONArray jsonArray = new JSONArray(responseData.getJSONArray(i).toString(i));
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("nameKey");
            Assert.assertEquals(name, documentName);
        }
    }

}
