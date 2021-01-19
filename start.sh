#!/bin/bash

## backup dir format ##
report_folder=$(date +'%m/%d/%Y/%H-%m-%S')

## execute tests
./gradlew testParam -DTEST_BROWSER=$1

## copy allure report
exec cp /home/gradle/build/reports/allure-report /report_folder
