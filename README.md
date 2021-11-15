# provecrealogix
This repo contains Android automation

## Contents

- [Configuration](#configuration)
    - [General requirements](#general-requirements)
    - [Specific requirements](#specific-requirements)
        - [Android](#android)
    - [Requirements help](#requirements-help)
- [Resources](#resources)
- [Running Cucumber Tests](#running-cucumber-tests)
- [Status](#status)
- [More](#more)
- [Links](#links)

## Configuration
### General requirements

* Kotlin
* Appium
* Gradle
* Plugin Cucumber for Kotlin on Android Studio
* Download the project: git clone git@github.com:Badiapp/badi-android.git

### Specific requirements

#### Android

* Android Studio + emulators
* Updated Java (Version 15.0.2 Max)
* Configure JAVA\_HOME and ANDROID\_HOME ([_more information_](https://stackoverflow.com/questions/58467392/to-set-android-home-and-java-home-variable-every-time-need-to-run-source-pro))
### Running a single feature or single scenario
1. Using the gradle cucumber command

   To run a single feature you have to use the feature tag specified at the beginning of the file: `gradle cucumber -P tags=@prove0`

   To execute a single scenario, mark your test with your own tag for developing purposes and use: `gradle cucumber -P tags=@prove1`

## Resources

The feature file (`apiScenario.feature` - `scenarioTest.feature` ) contains the test scenarios for Login feature.

The step definitions (`AlahliSteps.kt` - `ApiSteps.kt` ). This contains the implementation of the steps specified on features.

The pages (`AlahliSteps.kt` - `ApiSteps.kt` ). This contains the implementation of the pages specified on steps.

The pages (`ProjectCapabilities.kt` ). This contains the core configuration of appium.

## Running Cucumber Tests

Using executable jar file:
```
gradle cucumber
```   

## Links
* [Cucumber] (https://cucumber.io)
* [Cucumber JVM] (http://github.com/cucumber/cucumber-jvm)
* [Google Guice] (https://github.com/google/guice)