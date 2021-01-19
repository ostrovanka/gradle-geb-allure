#!/bin/bash

report_folder "$(date +'%Y_%m_%d_%H-%M-%S')"

## execute tests
./gradlew testParam -DTEST_BROWSER=$1

## copy allure report
mkdir -p /temp/$report_folder && cp -r /home/gradle/build/reports/allure-report /temp/$report_folder
