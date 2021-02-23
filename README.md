## Introduction:
API Automation Assignment ( Java, TestNg, Maven, Restassured, Log4j, Gherkin, CircleCI )<br />

## Usage:
-No additional effort needed, Just import as existing maven project. Libs will be automatically downloaded.<br />
-Go to the UserTests.java and click on Run All or right click Run as TestNG Test<br />

## Automated Test Cases can be found under 
-https://github.com/mlsgu/by-api/tree/main/src/test/java/testcases<br />

## Test Cases in Gherkin format can be found under
-https://github.com/mlsgu/by-api/tree/main/src/test/resources/Features<br />

## Technologies Used
-Java<br />
-Maven<br />
-Rest Assured framework is used - to perform service requests<br />
-TestNG is used - for test execution<br />
-config.properties is used - to clean test and code<br />
-CircleCI for Orchestration and Docker Based execution<br />
-Used Docker image : Maven<br />


## CircleCI flow:
- Pipeline config.yml is attached to repo : https://github.com/mlsgu/by-api/blob/main/.circleci/config.yml <br />
- test results are exported as an artifact.<br />
- testng xml file can be used to analyze the results<br />

