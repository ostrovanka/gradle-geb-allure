package org.badger.tests.spock


import geb.spock.GebSpec
import org.badger.pages.GebishOrgHomePage
import org.badger.pages.TheBookOfGebPage
import org.junit.Test

class GebishOrgTestSpock extends GebSpec {
    @Test
    def "Can get to the current Book Of Geb"() {
        given:
        GebishOrgHomePage homePage = to GebishOrgHomePage
        
        when:
        homePage.manualsMenu.open()
        then:
        homePage.verifyManualsMenuItem(0, "current")
        
        when:
        homePage.openManualsMenuItem(0)
        then:
        at TheBookOfGebPage
    }
    
    @Test
    def "Can get to the current Book Of Geb (failing)"() {
        given:
        GebishOrgHomePage homePage = to GebishOrgHomePage
        
        when:
        homePage.manualsMenu.open()
        then:
        homePage.verifyManualsMenuItem(0, "urrent")
        homePage.openManualsMenuItem(0)
        and:
        at TheBookOfGebPage
    }
    
}
