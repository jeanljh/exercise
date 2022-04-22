# selenium-gui-api-test

[![Java CI with Maven](https://github.com/jeanljh/exercise/actions/workflows/maven.yml/badge.svg)](https://github.com/jeanljh/exercise/actions/workflows/maven.yml)

Example of a test automation framework for GUI and API tests and consists of these stacks: Selenium, Selenium Grid, Java, Maven, TestNG, RestAssured, TestNG report, Allure report, GitHub Actions (CI pipeline)

1. Clone this repository: 
Run command: git clone git@github.com:jeanljh/exercise.git

2. Running the tests:

Method 1: Run locally
1. Open in IDE (e.g. IntelliJ IDEA)
2. Go to /src/test/java and run APITest and UITest

Method 2: Run locally via xml file
1. Open in IDE
2. Go to /src/test/suite and run local.xml in your local environment

Method 3: Run with Github actions
1. Go to https://github.com/jeanljh/exercise/actions/workflows/maven.yml
2. Click 'Run workflow' to trigger tests in Github Actions

Method 4: Run in Selenium Grid (optional)
1. To setup Selenum Grid in local machine, download server jar file from https://www.selenium.dev/downloads/
2. Open one command prompt for each of the following commands below in exact order. Run command: cd [jar file directory] before execute these commands:

java -jar [jar file name] event-bus
  
java -jar [jar file name] sessions
  
java -jar [jar file name] sessionqueue
  
java -jar [jar file name] distributor --sessions http://localhost:5556 --sessionqueue http://localhost:5559 --bind-bus false
  
java -jar [jar file name] router --sessions http://localhost:5556 --distributor http://localhost:5553 --sessionqueue http://localhost:5559
  
java -jar [jar file name] node --detect-drivers true

Refer to complete guide: https://www.selenium.dev/documentation/grid/getting_started/

3. Open this repository in IDE
4. Go to /src/test/suite and run grid.xml to trigger tests in Selenium Grid in your local machine

There are 2 types of html reports generated:
1. Allure report: go to allure-report/index.html
2. TestNG report: go to test-output/emailable-report.html


