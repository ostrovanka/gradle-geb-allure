#!/bin/bash
./gradlew testParam -DTEST_BROWSER=$1
exec rm /temp/* && cp /home/gradle/build/reports/allure-report /temp
