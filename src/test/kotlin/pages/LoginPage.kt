package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.pagefactory.AndroidFindBy
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Driver

class LoginPage(device: AppiumDriver<MobileElement>) : BasePage(device) {

    @FindBy(xpath= "//android.widget.Button[@resource-id='button-language']")
    var elementLanguage: MobileElement? = null

    @FindBy(xpath= "//android.widget.Button[@resource-id='button-login']")
    var loginBtnElement: MobileElement? = null

    fun isSelectedLanguage(languageText:String){
        var  element = loginBtnElement!!.text.contains("LOGIN")
        if(languageText == "Arabic"){
            if(element)
            {
                elementLanguage!!.click()
            }
            Thread.sleep(2000)
        }
        else {
            if(!element){
                elementLanguage!!.click()
            }
            Thread.sleep(2000)
        }
    }

    fun popUpClose(){
        Thread.sleep(10000)
        var userNameElement = device.findElements(By.ByXPath("//android.widget.Image[@resource-id='icon']")).filter { l -> l.isDisplayed }
        if(!userNameElement.isNullOrEmpty()){
            userNameElement.first().click()
        }
    }

    fun isLoginPage(){
        val listElements = listOf<Boolean>(
            device.findElement(By.ByXPath("//android.view.View[@text='login-username']")).isDisplayed,
            device.findElement(By.xpath("//android.view.View[@text='login-password']")).isDisplayed,
            device.findElement(By.className("android.widget.CheckBox")).isDisplayed)
        if(!listElements.any()){
            throw Exception("The login is missing some login element")
        }
    }

    fun isEnglish(){
        var  element = loginBtnElement!!.text.contains("LOGIN")
        if(!element){
            throw Exception("The language selected is not the English")
        }
    }

    fun isArabian(){
        var  element = loginBtnElement!!.text.contains("LOGIN")
        if(element){
            throw Exception("The language selected is not the Arabian")
        }
    }
}