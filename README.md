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

# Documentation

* [Installation](https://github.com/selenium-cucumber/selenium-cucumber-java/blob/master/doc/installation.md)
* [Install IntelliJ](https://www.jetbrains.com/idea/download/#section=linux) for easy use of lambda expression
* Configure and Install Following Intellij Plugins
	* File -> Setting -> Plugins ->
	* Cucumber for Java 
	* Gherkin 
	* Maven Integration 

# Setting up and running tests

* Go to Project >src >test >java >runner>TestRunner
	* Right click on it and run project
	
* Run project on window mode with tags
	* mvn clean compile test -DCucumber.options="--tags @sanity"


	