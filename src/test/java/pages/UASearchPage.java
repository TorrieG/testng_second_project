package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UASearchPage {
    public UASearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[id^=headerNav]")
    public List<WebElement> mainMenuList;

    @FindBy(xpath = "(//ul[@role='tablist'])[2]//li")
    public List<WebElement> bookTravelMenuList;

    @FindBy(xpath = "//span[@class='app-components-BookFlightForm-bookFlightForm__checkmark--2DHJD']")
    public List<WebElement> roundTripOneWayRadioButtons;

    @FindBy(id = "oneway")
    public WebElement oneWayRadioButton;

    @FindBy(id = "roundtrip")
    public WebElement roundTripButton;

    @FindBy(id = "award")
    public WebElement bookWithMilesCheckbox;

    @FindBy(css = "label[for='award']")
    public WebElement flexibleDatesCheckbox;

    @FindBy(id = "#bookFlightOriginInput")
    public WebElement fromInputBox;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toInputBox;

    @FindBy(id = "DepartDate")
    public WebElement datesInputBox;

    @FindBy(id = "")
    public WebElement dayInputBox;

    @FindBy(id = "passengerSelector")
    public WebElement travelersCount;

    @FindBy(css = "input[class=app-components-PassengerSelector-passengers__passengerRow__input--13_Gq]")
    public WebElement getTravelersCount;

    @FindBy(css = "#cabinType>div")
    public WebElement cabinDropdown;

    @FindBy(css = "button[type='submit']")
    public WebElement findFlightsButton;

    @FindBy(xpath = "(//div[@class='app-components-Shopping-TripInfo-styles__tripOriginDestinationHeader--RcPyp']//span)[3]")
    public WebElement departureDetails;
}
