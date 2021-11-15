package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.PerformsTouchActions
import io.appium.java_client.TouchAction
import io.appium.java_client.android.AndroidTouchAction
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.touch.offset.ElementOption.element
import io.appium.java_client.touch.offset.PointOption
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert
import java.sql.Driver
import kotlin.concurrent.thread

class OffersPromotionsPage(device: AppiumDriver<MobileElement>) : BasePage(device) {

    @FindBy(xpath= "//android.widget.Button[@resource-id='button-language']")
    var language: MobileElement? = null

    @FindBy(className = "android.widget.SeekBar")
    private var seekBarElement: MobileElement? = null

    @FindBy(xpath= "//android.widget.Button[@resource-id='button-icon-pin-location']")
    var mapIconElement: MobileElement? = null

    fun isSelectedLanguage(languageText:String){
        if(languageText == "Arabic"){
            var languageSel = language!!.text.contains("En")
            if(!languageSel)
            {
                language!!.click()
            }
        }
        else {
            Thread.sleep(2000)
            var languageSel = language!!.text.contains("عربي")
            if(!languageSel){
                language!!.click()
            }
        }
    }

    fun proximitySelect(){
        AndroidTouchAction(device as PerformsTouchActions?).press(element(seekBarElement!!)).moveTo(PointOption.point(1000, 682)).release().perform()
        Thread.sleep(2000)
        var elementVer = seekBarElement!!.text.contains("50")
        Assert.assertTrue(elementVer)
    }

    fun goTo(elementText: String){
        if(elementText.lowercase() == "promotions"){
            var element = device.findElement(By.xpath("//android.widget.ToggleButton[@text='Promotions, Off']"))
            element!!.click()
        }else{
            var element = device.findElement(By.xpath("//android.widget.ToggleButton[@text='Offers, Off']"))
            element!!.click()
        }
    }
}