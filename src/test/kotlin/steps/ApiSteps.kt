package steps

import com.google.gson.*
import com.google.inject.Inject
import data.DataClass
import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import org.testng.Assert


class ApiSteps @Inject constructor(): En{

    var data = DataClass()
    private lateinit var valueA : String
    private lateinit var valueB : String
    private lateinit var versionA : String
    private lateinit var versionB : String

    init {
        Before("@CrealogixScenarioData"){scenario: Scenario ->
            println("starting scenario ${scenario.name}")
        }

        Given("I get the data value") {

            valueA = data.getPlatesInfo("https://packagist.org/p/league/plates.json")
            valueB = data.getPlatesInfo("https://packagist.org/packages/league/plates.json")
        }



        And("I get the latest version")
        {
            versionA= data.getLatestVersion(valueA,"packages","league/plates")
            versionB= data.getLatestVersion(valueB,"package","versions")
        }

        Then("I compare both values"){
            Assert.assertEquals(versionA,versionB)
            println("latest version is $versionA")
        }


    }

}
