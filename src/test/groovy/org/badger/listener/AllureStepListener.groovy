package org.badger.listener

import io.qameta.allure.Allure
import io.qameta.allure.AllureLifecycle
import io.qameta.allure.listener.StepLifecycleListener
import io.qameta.allure.model.Status
import io.qameta.allure.model.StepResult
import org.badger.drivers.BrowserSingleton
import org.openqa.selenium.OutputType

class AllureStepListener implements StepLifecycleListener {
    @Override
    void afterStepStop(StepResult result) {
        if((result.status == Status.FAILED || result.status == Status.BROKEN) && BrowserSingleton.instance != null) {
            AllureLifecycle lifecycle = Allure.getLifecycle()
            lifecycle.addAttachment("Screenshot", "image/png", "png", BrowserSingleton.instance.browser.getScreenshotAs(
                OutputType.BYTES))
        }
    }
}

