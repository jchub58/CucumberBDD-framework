# SauceDemo Cucumber BDD Automation Framework

A comprehensive Behavior-Driven Development automation framework using Cucumber, Selenium WebDriver, and Java.

## 🚀 Features

- **Cucumber BDD** - Gherkin syntax for readable test scenarios
- **Page Object Model** - Maintainable page abstractions
- **Selenium WebDriver** - Cross-browser automation
- **Parallel Execution** - Faster test runs with ThreadLocal
- **ExtentReports** - Beautiful HTML reports
- **SLF4J Logging** - Comprehensive logging
- **Jenkins Pipeline** - CI/CD integration
- **Data-Driven Testing** - Scenario Outline with Examples

## 📁 Project Structure

```
├── src/main/java
│   ├── factory/          # WebDriver factory
│   ├── pages/            # Page Objects
│   └── utils/            # Utilities
├── src/test/java
│   ├── runner/           # Test runners
│   └── stepdefinitions/  # Step definitions
├── src/test/resources
│   ├── features/         # Gherkin feature files
│   ├── config.properties
│   └── extent.properties
├── Jenkinsfile
└── pom.xml
```

## ⚙️ Setup

1. Clone the repository
2. Install JDK 11+
3. Install Maven 3.6+

## 🏃 Running Tests

```bash
# Run all tests
mvn test

# Run smoke tests
mvn test -Dtest=SmokeTestRunner

# Run regression tests
mvn test -Dtest=RegressionTestRunner

# Run specific tags
mvn test -Dcucumber.filter.tags="@login"

# Run with different browser
mvn test -Dbrowser=firefox

# Run headless
mvn test -Dbrowser=chrome-headless
```

## 🔧 Jenkins Setup

1. Install required plugins:
    - Maven Integration
    - HTML Publisher
    - Cucumber Reports
    - Email Extension

2. Configure Jenkins:
    - Add Maven installation (Maven-3.9)
    - Add JDK installation (JDK-11)

3. Create Pipeline job pointing to this repository

## 📊 Reports

After execution:
- `reports/SparkReport.html` - ExtentReports
- `target/cucumber-reports/` - Cucumber reports
- `logs/automation.log` - Execution logs