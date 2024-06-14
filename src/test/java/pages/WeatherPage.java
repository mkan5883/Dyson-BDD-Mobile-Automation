package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class WeatherPage extends BasePage {
    @AndroidFindBy(id = "com.dyson.recruitment.test:id/connection_display_title")
    @iOSXCUITFindBy(accessibility = "fetch_data_title_label")
    private WebElement connectionDisplayTitle;

    @AndroidFindBy(id = "com.dyson.recruitment.test:id/connection_display_primary_button")
    @iOSXCUITFindBy(accessibility = "Fetch Data")
    private WebElement fetchDataButton;

    @AndroidFindBy(id = "com.dyson.recruitment.test:id/fetch_data_title")
    @iOSXCUITFindBy(accessibility = "view_results_title_label")
    private WebElement fetchDataTitle;

    @AndroidFindBy(id = "com.dyson.recruitment.test:id/fetch_data_description")
    @iOSXCUITFindBy(accessibility = "view_results_body_label")
    private WebElement fetchDataDescription;

    @AndroidFindBy(id = "com.dyson.recruitment.test:id/fetch_data_primary_button")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeApplication[@name=\"ConnectivityRemoteTest\"]//XCUIElementTypeWindow[1]//XCUIElementTypeOther)[5]")
    private WebElement viewResultsButton;

    @AndroidFindBy(id = "com.dyson.recruitment.test:id/weather_display_weather_icon")
    @iOSXCUITFindBy(accessibility = "weather_icon")
    private WebElement weatherIcon;

    @AndroidFindBy(id = "com.dyson.recruitment.test:id/weather_display_weather_title")
    @iOSXCUITFindBy(accessibility = "weather_title_label")
    private WebElement weatherTitle;

    @AndroidFindBy(id = "com.dyson.recruitment.test:id/weather_display_weather_value")
    @iOSXCUITFindBy(accessibility = "weather_description_label")
    private WebElement weather;

    @AndroidFindBy(id = "com.dyson.recruitment.test:id/weather_display_temperature_icon")
    @iOSXCUITFindBy(accessibility = "temperature_icon")
    private WebElement temperatureIcon;

    @AndroidFindBy(id = "com.dyson.recruitment.test:id/weather_display_temperature_title")
    @iOSXCUITFindBy(accessibility = "temperature_title_label")
    private WebElement temperatureTitle;

    @AndroidFindBy(id = "com.dyson.recruitment.test:id/weather_display_temperature_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'°C')]")
    private WebElement temperature;

    @AndroidFindBy(id = "com.dyson.recruitment.test:id/weather_display_primary_button")
    @iOSXCUITFindBy(id = "//XCUIElementTypeApplication[@name=\"ConnectivityRemoteTest\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]")
    private WebElement doneButton;

    public WeatherPage(AppiumDriver driver) {
        super(driver);
    }

    public String getConnectionText() {
        return getText(connectionDisplayTitle);
    }

    public void clickFetchDataButton() {
        click(fetchDataButton);
    }

    public String getFetchDataTitle() {
        return getText(fetchDataTitle);
    }

    public String getFetchDataDescription() {
        return getText(fetchDataDescription);
    }

    public boolean isViewResultButtonEnabled() {
        return viewResultsButton.isEnabled();
    }

    public void clickViewResultButton() {
        click(viewResultsButton);
    }

    public boolean isWeatherIconIsDisplayed() {
        return weatherIcon.isDisplayed();
    }

    public String getWeatherTitle() {
        return getText(weatherTitle);
    }

    public String getWeatherValue() {
        return getText(weather).trim();
    }

    public boolean isTemperatureIconIsDisplayed() {
        return temperatureIcon.isDisplayed();
    }

    public String getTemperatureTitle() {
        return getText(temperatureTitle);
    }

    public String getTemperatureValue() {
        return getText(temperature);
    }

    public boolean isDoneButtonEnabled() {
        return doneButton.isEnabled();
    }

}
