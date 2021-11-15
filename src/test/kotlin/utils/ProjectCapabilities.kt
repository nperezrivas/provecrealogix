package utils
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.AfterTest
import java.net.URL
import java.util.concurrent.TimeUnit

object ProjectCapabilities {
    var driver: AppiumDriver<MobileElement>? = null

    fun setup() {
        val capabilities = DesiredCapabilities()
        var serverAddress = URL("http://localhost:4723/wd/hub")

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.alahli.mobile.android")
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.alahli.mobile.android.MainActivity")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android")
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true)
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "false")

        driver = AndroidDriver(serverAddress, capabilities)

        driver?.let {
            it.manage()?.timeouts()?.implicitlyWait(25, TimeUnit.SECONDS)
        }
    }

    @AfterSuite(alwaysRun = true)
    fun tearDown(){
        driver?.quit()?: throw Exception("Driver instance was unable to quit.")
    }

    fun resetApp(){
        driver?.resetApp()
    }
}