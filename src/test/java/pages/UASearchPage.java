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

    @FindBy(css = "div[class*='checkboxWrapper']>label")
    public List<WebElement> bookWithMilesCheckboxLabel;

    @FindBy(css = "div[class*='checkboxWrapper']>input")
    public List<WebElement> checkBoxInputs;

    @FindBy(css = "#bookFlightOriginInput")
    public WebElement fromInputBox;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toInputBox;

    @FindBy(id = "DepartDate")
    public WebElement datesInputBox;

    @FindBy(id = "passengerSelector")
    public WebElement travelersCount;

    public void clickOnCabinTypeOption(String optionText){
        for(WebElement element : cabinTypeOptions){
            if(element.getText().equals(optionText)){
                element.click();
                break;
            }
        }
    }


    @FindBy(id = "cabinType")
    public WebElement cabinTypeDropdown;

    @FindBy(css = "button[type='submit']")
    public WebElement findFlightsButton;

    @FindBy(css = "button[aria-label='Substract one Adult']")
    public WebElement addOneMoreAdultButton;

    @FindBy(css = "li[id^='cabinType_item-']")
    public List<WebElement> cabinTypeOptions;




}
