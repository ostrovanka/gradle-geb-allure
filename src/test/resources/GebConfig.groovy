/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/#configuration
*/


import org.badger.drivers.CustomDriver

import java.text.NumberFormat

Properties properties = new Properties()
File propertiesFile = new File('./src/main/resources/geb.properties')
propertiesFile.withInputStream {
    properties.load(it)
}

waiting {
    timeout = NumberFormat.getInstance().parse(properties.'waiting.timeout')
}

environments {
    
    chrome {
        driver = CustomDriver.CHROME.driverClosure()
    }
    
    chromeHeadless {
        driver = CustomDriver.CHROME_HEADLESS.driverClosure()
    }
    
    firefox {
        atCheckWaiting = 1
        driver = CustomDriver.FIREFOX.driverClosure()
        
    }
    
    remoteChrome {
        atCheckWaiting = 1
        driver = CustomDriver.REMOTE_CHROME.driverClosure()
    }
    
    remoteFirefox {
        atCheckWaiting = 1
        driver = CustomDriver.REMOTE_FIREFOX.driverClosure()
    }
    
}

baseUrl = properties.'baseUrl'



