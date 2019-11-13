# Test All The Things
##### A testing framework using Cucumber and JUnit, executed by Maven, and written in Kotlin.

## Installation
 
 - Java 1.8 sdk [download](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
 - Maven 3.6.1+ [download](https://maven.apache.org/download.cgi#)
 
Run: `mvn install`
 
## Execute Tests

- By default, 6 features run in parallel.  

Run all tests: `mvn test`

Run a subset of tests: `mvn test -Dcucumber.options="-t '@tag'"`

## Notes

- Site under test: http://the-internet.herokuapp.com/
- Attempting Page Object Model
