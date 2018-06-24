# three-stps-t2

This test was made on Java8 having as dependency:

     Jackson - serialization/deserialization
     Rest-Assured - http requests
     Spring-Context (to load api.properties for api service).
     Testng - test execution
     Extentreports - to generate a better test log.

## Understanding the project

There is a **model** package including classes that represents the api reponse. Those classes are using Jackson's annotation and should be user to object serialization purposes in the service classes. 

The **service** package contains  ClassService which should just provide http requests and response serialization.

The **log** package contains ExtentReportLog class with static methods to log information during the test execution. A static logger is used by the whole project, extentReport is started by @BeforeSuite and finished by @AfterSuite. Html report will be placed in the root folder in the end.

The **data** package provides data to be used during the test. We have an enum of cities and a class for geographic coordinates.

### Test Class

I've created one @Test method for each api endpoint.
The test method will call the api using the object from reponse body to validate the information returned.

## **Steps to run**

As well as UI test, I did not create a maven profile, you will be able to run the test just using a **mvn clean install** command.
