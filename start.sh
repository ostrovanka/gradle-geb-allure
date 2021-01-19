#!/bin/bash

echo "$(date +'%Y_%m_%d_%H-%m')"

### execute tests
#./gradlew testParam -DTEST_BROWSER=$1
#
### copy allure report
#mkdir -p /temp/"$(date +'%Y_%m_%d_%H-%m')" && cp -r /home/gradle/build/reports/allure-report /temp/"$(date +'%Y_%m_%d_%H-%m')"
