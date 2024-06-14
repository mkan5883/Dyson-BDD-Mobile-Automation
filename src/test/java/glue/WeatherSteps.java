package glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.WeatherPage;
import utils.DriverManager;

public class WeatherSteps {

    private final WeatherPage weatherPage;

    public WeatherSteps(DriverManager driverManager) {
        this.weatherPage = new WeatherPage(driverManager.getDriver());
    }

    @Given("I have an internet connection")
    public void checkInternetConnection() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(weatherPage.getConnectionTitleText(), "Connected",
                "Connection Title is correct");
        softAssert.assertTrue(weatherPage.getConnectionDescriptionText().contains("You are connected to the internet"),
                "Connection Description is correct");
        softAssert.assertTrue(weatherPage.isFetchButtonEnabled(), "Fetch Data button is enabled");
        softAssert.assertAll();

    }

    @When("I have successfully downloaded the weather data")
    public void fetchData() {
        SoftAssert softAssert = new SoftAssert();
        weatherPage.clickFetchDataButton();
        softAssert.assertTrue(weatherPage.getFetchDataTitle().equalsIgnoreCase("Data collected"),
                "Fetch Data Title is correct");
        softAssert.assertTrue(weatherPage.getFetchDataDescription().contains("The weather data has been successfully collected"),
                "Fetch Data Description is correct");
        softAssert.assertTrue(weatherPage.isViewResultButtonEnabled(),
                "View Results button is enabled");
        softAssert.assertAll();

    }

    @Then("I can see the weather and temperature for today")
    public void checkWeatherData() {
        SoftAssert softAssert = new SoftAssert();
        weatherPage.clickViewResultButton();
        softAssert.assertTrue(weatherPage.isWeatherIconIsDisplayed(), "Weather icon is displayed");
        softAssert.assertEquals(weatherPage.getWeatherTitle(), "Weather", "Weather title is correct");
        String weather = weatherPage.getWeatherValue();
        //This validation should be improved by validate from an API or DB
        softAssert.assertTrue(weather.equalsIgnoreCase("broken clouds"), "Weather value is correct");
        softAssert.assertTrue(weatherPage.isTemperatureIconIsDisplayed(), "Temperature icon is displayed");
        softAssert.assertEquals(weatherPage.getTemperatureTitle(), "Temperature",
                "Temperature title is correct");
        String temperatureText = weatherPage.getTemperatureValue();
        //This validation should be improved by validate from an API or DB
        softAssert.assertTrue(temperatureText.equalsIgnoreCase("31.82°C"),
                "Temperature value is correct");
        softAssert.assertTrue(weatherPage.isDoneButtonEnabled(), "Done button is enabled");
        softAssert.assertAll();
    }
}
