# BDD Cucumber Framework

This repository provides some working boilerplate code for building automated test suites for API-based testing with Rest Assured and Behavior driven development (BDD). 

# Below are some of the features of this test framework:

* Maven based framework
* Rest Assured
* API Helper class to handle API method(get, post, put, patch)
* Extent Report for reporting
* Report Generation (cucumber-reporting)
* Java 8 (lambda expression)
* Added tag for each scenario to differentiate between sanity test and regression test 

# Prerequisite
* Install Java 1.8
* install Maven

# Documentation

* [Prerequisite_Details](https://github.com/selenium-cucumber/selenium-cucumber-java/blob/master/doc/installation.md)
* [Install IntelliJ](https://www.jetbrains.com/idea/download/#section=linux) for easy use of lambda expression
* Configure and Install Following Intellij Plugins
	* File -> Setting -> Plugins ->
	* Cucumber for Java 
	* Gherkin 
	* Maven Integration 

# Setting up and running tests

* Go to Project >src >test >java >runner>TestRunner
	* Right click on it and run project
	

* Run from command line
  * mvn clean compile test

# Note
* Project will not run before putting actual base uri and endpoints from config file
* In this scenario, we assume the existence of two APIs: one for user login and another for 
performing search queries. The data required for these APIs is being passed from the 'config.properties' file."

**Assumptions :**

1. Call Login API
*  Endpoint = /login
*  Method =`POST`
*   Sample Request Payload= JSON object containing username and password

*   JSON :
   {
   "username": "your_username",
   "password": "your_password"
   }
*  Expected Response= HTTP status 200 (OK) if login successful, along with authentication token.

2. Navigate to Search Page
   Once authenticated, navigate to the search page.
3. Fire Search Query for "adhaar jayashree"
*  Endpoint =`/search`
*   Method = `GET`
*  Query Parameter =`query` with value `"adhaar jayashree"`
*  Expected Response = JSON array containing search results.

4. Assert Results
i) Verify that all values in the search results meet the expected criteria.
ii) Verify result count

Test Execution
1. Run the test suite.
2. Verify that all test cases pass without errors.
3. Review the test reports for detailed information on test execution.

	