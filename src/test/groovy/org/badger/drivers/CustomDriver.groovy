package org.badger.drivers

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

enum CustomDriver {
    CHROME{
        Closure<ChromeDriver> driverClosure() {
            WebDriverManager.chromedriver().setup();
            return {
                newDriver = new ChromeDriver()
                BrowserSingleton.instance.browser = newDriver
                return newDriver
            }
        }
    },
    CHROME_HEADLESS{
        Closure<ChromeDriver> driverClosure() {
            WebDriverManager.chromedriver().setup()
            return {
                ChromeOptions o = new ChromeOptions()
                o.addArguments('headless')
                newDriver = new ChromeDriver(o)
                BrowserSingleton.instance.browser = newDriver
                return newDriver
            }
        }
    },
    FIREFOX{
        Closure<FirefoxDriver> driverClosure() {
            WebDriverManager.firefoxdriver().setup();
            return {
                newDriver = new FirefoxDriver()
                BrowserSingleton.instance.browser = newDriver
                return newDriver
            }
        }
    },
    REMOTE_CHROME{
        Closure<RemoteWebDriver> driverClosure() {
            return {
                DesiredCapabilities abilities = DesiredCapabilities.chrome()
                newDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), abilities)
                BrowserSingleton.instance.browser = newDriver
                return newDriver
            }
        }
    },
    REMOTE_FIREFOX{
        Closure<RemoteWebDriver> driverClosure() {
            return {
                DesiredCapabilities abilities = DesiredCapabilities.firefox()
                newDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), abilities)
                BrowserSingleton.instance.browser = newDriver
                return newDriver
            }
        }
    }
    
    def newDriver
    
    abstract Closure<? extends RemoteWebDriver> driverClosure();
}
