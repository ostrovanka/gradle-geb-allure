package org.badger.tests.junit

import geb.junit4.GebTest
import org.badger.pages.GebishOrgHomePage
import org.badger.pages.TheBookOfGebPage
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class GebishOrgTestJunit extends GebTest {
    
    @Test
    void canGetToTheCurrentBookOfGeb() {
        GebishOrgHomePage homePage = to GebishOrgHomePage
        
        homePage.manualsMenu.open()
        homePage.verifyManualsMenuItem(0, "current")
        homePage.openManualsMenuItem(0)
        
        at TheBookOfGebPage
    }
    
    @Test
    void canGetToTheCurrentBookOfGeb_failing() {
        GebishOrgHomePage homePage = to GebishOrgHomePage
        
        homePage.manualsMenu.open()
        homePage.verifyManualsMenuItem(0, "urrent")
        homePage.openManualsMenuItem(0)
        
        at TheBookOfGebPage
    }
    
}
