package org.badger.pages

import geb.Module
import org.badger.annotation.AllureStepLogger

@AllureStepLogger
class ManualsMenuModule extends Module {
    
    static content = {
        toggle { $("div.menu a.manuals") }
        linksContainer { $("#manuals-menu") }
        links { linksContainer.find("a") }
    }
    
    void open() {
        toggle.click()
        waitFor { !linksContainer.hasClass("animating") }
    }
}
