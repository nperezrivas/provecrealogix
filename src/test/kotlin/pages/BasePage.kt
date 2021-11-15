package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.PerformsTouchActions
import io.appium.java_client.android.AndroidTouchAction
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How
import org.openqa.selenium.support.PageFactory
import java.time.Duration

abstract class BasePage (val device: AppiumDriver<MobileElement>) {
    init {
        PageFactory.initElements(AppiumFieldDecorator(device), this)
    }

    @FindBy(xpath= "//android.widget.Button[@resource-id='button-footer-registration']")
    private var registrationOptionMenu : MobileElement? = null

    @FindBy(xpath="//android.widget.Button[@resource-id='button-footer-forgot']")
    private var forgotOptionMenu : MobileElement? = null

    @FindBy(xpath="//android.widget.Button[@resource-id='button-footer-login']")
    private var loginOptionMenu : MobileElement? = null

    @FindBy(xpath="//android.widget.Button[@resource-id='button-footer-offers']")
    private var offersOptionMenu : MobileElement? = null

    @FindBy(xpath="//android.widget.Button[@resource-id='button-footer-contact']")
    private var contactOptionMenu : MobileElement? = null

    fun selectMenu(menuSelect: String){
        when(menuSelect){
            "Registration"->registrationOptionMenu!!.click()
            "Forgot" ->forgotOptionMenu!!.click()
            "Login"->loginOptionMenu!!.click()
            "Offers"->offersOptionMenu!!.click()
            "Contact"->contactOptionMenu!!.click()
            else ->{
                loginOptionMenu!!.click()
            }
        }
    }

    fun swipePosition(presxOffset: Int, pressyOffset: Int, movexOffset: Int, moveyOffset: Int){

        AndroidTouchAction(device as PerformsTouchActions?)
            .press(PointOption.point(presxOffset, pressyOffset))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
            .moveTo(PointOption.point(movexOffset, moveyOffset))
            .release().perform()
    }
}