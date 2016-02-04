import groovy.ui.Console
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.remote.DesiredCapabilities


Console console = new Console()

String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME")
String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY")

URL webdriverEndpoint = new URL("http://${SAUCE_USERNAME}:${SAUCE_ACCESS_KEY}@ondemand.saucelabs.com:80/wd/hub")

DesiredCapabilities caps = new DesiredCapabilities()

caps.setCapability("platformVersion", "5.1")
caps.setCapability("deviceName", "Android Emulator")
caps.setCapability("app", "http://appium.s3.amazonaws.com/ContactManager.apk")
caps.setCapability("newCommandTimeout", "10000")
caps.setCapability("idleTimeout", "10000")
caps.setCapability("appiumVersion", "1.4.16")
caps.setCapability("name", "groovy repl")

AndroidDriver driver = new AndroidDriver(webdriverEndpoint, caps)


console.setVariable("driver", driver)

console.run()