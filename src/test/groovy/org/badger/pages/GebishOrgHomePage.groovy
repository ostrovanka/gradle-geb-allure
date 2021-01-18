package org.badger.pages

import geb.Page
import org.badger.annotation.AllureStepLogger

@AllureStepLogger
class GebishOrgHomePage extends Page {
    
    static at = { title == "Geb - Very Groovy Browser Automation" }
    
    static content = {
        manualsMenu { module(ManualsMenuModule) }
    }
    
    void openManualsMenuItem(int index) {
        manualsMenu.links[index].click()
    }
    
    void verifyManualsMenuItem(int index, String expectedName) {
        assert manualsMenu.links[index].text().startsWith(expectedName)
    }
}
