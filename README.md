# paylinks-webapp-automation
Test project with automated tests for the paylinks Web Automation  application

#Test project repository :


#Software Stacks to automate application for both Windows and Mac:

- System under testing: stable version
- Intellij
- Jdk - 1.8+
- Maven-2.3+
- Git

# One-time configuration for Windows
1. Clone the project using above git url provided.
2. Set the jdk for the application .
3. Build the project using Maven locally for dependency management


# Report Generation InteliJ
Run main class RunCukesTest.
- After test run completion, the report can be found under the `target\cucumber-reports` folder.
- Application level logging can be found under the `resources\logs` folder.
- Detailed cucumber report can be generated via cluecumber report plugin.
  -After test run complete, run 'mvn cluecumber-report:reporting' from maven goal.
  Report can be found under 'target/generated-report'.

## Run tests via Command Line with Maven
mvn test