#!/bin/bash

report_dir=$(date +'%Y_%m_%d_%H-%m')

## execute tests
./gradlew testParam -DTEST_BROWSER=$1

## copy allure report
mkdir -p /temp/"$report_dir" && cp -r /home/gradle/build/reports/allure-report /temp/"$report_dir"
