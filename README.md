Pension-Delay-Calculator
========================

Initial Automation work.

In order to execute the current Automation- the following System Requirement must be present:

Git client,
Java 1.6 or later,
Firefox 24,
Maven (Apache Maven 3.0.4)

Then follow the following commands from the terminal or windows cmd console:

- git clone https://github.com/Havanero/Pension-Delay-Calculator.git
- cd Pension-Delay-Calculator/
- mvn test

..........
-Git Client is optional, one can also download the zip file (the project folder) unzip and execute the command 
mvn test

If there is mvn build failure due to dependancy and provided you have JDK 1.6 and over in your machine, you can re-build the project with the following command:
mvn clean install
then
mvn test

