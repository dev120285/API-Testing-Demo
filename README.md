# API-Testing-Demo
A demo Spring Boot App for API Automation Testing

# Purpose
* API Testing automation performed programmatically.
* For Testing REST API I am using  a sample REST API from https://openweathermap.org/api
* For testing SOAP API I am using a sample SOAP wsdl from http://currencyconverter.kowabunga.net/converter.asmx?wsdl
* The test cases demonstrates the capability of Rest Assured to programmatically generate response for SOAP and REST API.
* The response time can be a deciding factor to benchmark SOAP to REST migration.

# Running in your local
* Clone or download the project.
* Import the maven project in your favorite IDE and execute maven goal test.
* Project can be launched via command line 
- ## Run all the unit test classes.
- $ mvn test

-  ## Run a single test class.
- $ mvn -Dtest=RestAPITest test

- ## Run multiple test classes.
- $ mvn -Dtest=RestAPITest,SOAPAPITest test


