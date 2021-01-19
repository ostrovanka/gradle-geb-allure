#!/bin/bash

## execute tests
./gradlew testParam -DTEST_BROWSER=$1

## copy allure report
exec cp /home/gradle/build/reports/allure-report /temp/"$(date +'%m/%d/%Y/%H-%m-%S')"
