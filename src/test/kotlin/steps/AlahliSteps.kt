package steps

import com.google.inject.Inject
import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import org.testng.annotations.AfterSuite
import pages.LoginPage
import pages.OffersPromotionsPage
import utils.ProjectCapabilities


class AlahliSteps @Inject constructor(): En{

    var appium = ProjectCapabilities
    private lateinit var loginPage: LoginPage
    private lateinit var offersPromotionsPage: OffersPromotionsPage

    init {
        Before("@CrealogixScenario"){scenario: Scenario ->
            appium.setup()
            loginPage = LoginPage(appium.driver!!)
            offersPromotionsPage= OffersPromotionsPage(appium.driver!!)

        }

        After("@CrealogixScenario"){scenario: Scenario ->
            loginPage = LoginPage(appium.driver!!)
            offersPromotionsPage= OffersPromotionsPage(appium.driver!!)
            appium.tearDown()
        }



        Given("I am in the {string} screen"){menuOption: String->

            loginPage.popUpClose()
            loginPage.selectMenu("$menuOption")
            loginPage.isLoginPage()
        }

        When("I tap on the offers menu"){
            loginPage.selectMenu("Offers")
        }

        When("I click on Language button"){
            loginPage.elementLanguage!!.click()
            Thread.sleep(2000)
        }

        And("I Set search on the map"){
            offersPromotionsPage.mapIconElement!!.click()
        }

        And("I have {string} language selected"){ language: String->
            loginPage.isSelectedLanguage(language)
            Thread.sleep(2000)
        }

        Then("I select the tab offers"){
            offersPromotionsPage.isSelectedLanguage("English")
            Thread.sleep(2000)
            offersPromotionsPage.goTo("offers")
        }

        Then("I set the proximity on 50km"){
            offersPromotionsPage.proximitySelect()
        }

        Then("I should see Language correctly for {string}"){language: String->
            when(language){
                "Arabic" ->loginPage.isArabian()
                "English" -> loginPage.isEnglish()
            }
            Thread.sleep(2000)
        }
    }

}