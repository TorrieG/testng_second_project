package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiters;

public class UnitedAirlinesTest extends Base{

    @Test(priority = 1, description = "Test Case 1 | Main menu")
    public void testMainMenu(){
        String[] mainMenuListItems = {
                "BOOK",
                "MY TRIPS",
                "TRAVEL INFO",
                "MILEAGEPLUS® PROGRAM",
                "DEALS",
                "HELP"
        };
        for (int i = 0; i < 6; i++) {
            System.out.println(mainMenuListItems[i]);
            Assert.assertEquals(uaSearchPage.mainMenuList.get(i).getText(), mainMenuListItems[i]);
        }
    }
    @Test(priority = 2, description = "Test Case 2 | Book travel menu")
    public void testBookTravelMenu(){
        String[] bookTravelMenuItems = {
                "Book",
                "Flight status",
                "Check-in",
                "My trips"
        };
        for (int i = 0; i < 4; i++) {

            System.out.println(bookTravelMenuItems[i]);
            Assert.assertEquals(uaSearchPage.bookTravelMenuList.get(i).getText(), bookTravelMenuItems[i]);
        }
    }
    @Test(priority = 3, description = "Test Case 3 | Round-trip and One-way")
    public void testRoundTripAndOneWay(){

        Assert.assertTrue(uaSearchPage.roundTripOneWayRadioButtons.get(0).isDisplayed());
        Assert.assertTrue(uaSearchPage.roundTripButton.isSelected());
        Assert.assertTrue(uaSearchPage.roundTripOneWayRadioButtons.get(0).isEnabled());

        Assert.assertTrue(uaSearchPage.roundTripOneWayRadioButtons.get(1).isDisplayed());
        Assert.assertTrue(uaSearchPage.roundTripOneWayRadioButtons.get(1).isEnabled());
        Assert.assertFalse(uaSearchPage.roundTripOneWayRadioButtons.get(1).isSelected());

        uaSearchPage.roundTripOneWayRadioButtons.get(1).click();

        Assert.assertTrue(uaSearchPage.oneWayRadioButton.isSelected());
        Assert.assertFalse(uaSearchPage.roundTripButton.isSelected());
    }
    @Test(priority = 4, description = "Test Case 4 | Book with miles and Flexible dates")
    public void testMilesAndFlexibleDates(){
//        Assert.assertTrue(uaSearchPage.bookWithMilesCheckbox.isDisplayed());
//        Assert.assertTrue(uaSearchPage.bookWithMilesCheckbox.isEnabled());
//        Assert.assertFalse(uaSearchPage.bookWithMilesCheckbox.isSelected());

        Assert.assertTrue(uaSearchPage.flexibleDatesCheckbox.isDisplayed());
        Assert.assertTrue(uaSearchPage.flexibleDatesCheckbox.isEnabled());
        Assert.assertFalse(uaSearchPage.flexibleDatesCheckbox.isSelected());

//        uaSearchPage.bookWithMilesCheckbox.click();
        uaSearchPage.flexibleDatesCheckbox.click();

//        Assert.assertTrue(uaSearchPage.bookWithMilesCheckbox.isSelected());
//        Assert.assertTrue(uaSearchPage.flexibleDatesCheckbox.isSelected());

//        uaSearchPage.bookWithMilesCheckbox.click();
        uaSearchPage.flexibleDatesCheckbox.click();

//        Assert.assertFalse(uaSearchPage.bookWithMilesCheckbox.isSelected());
        Assert.assertFalse(uaSearchPage.flexibleDatesCheckbox.isSelected());
    }
    @Test(priority = 5, description = "Test Case 5 | One-way ticket search results")
    public void testOneWayTicketSearchResults(){
        uaSearchPage.oneWayRadioButton.click();
        //uaSearchPage.fromInputBox.click();
        // "Chicago, IL, US (ORD)"
        uaSearchPage.toInputBox.sendKeys("Miami, FL, US (MIA)");
        uaSearchPage.datesInputBox.click();
        uaSearchPage.datesInputBox.clear();
        uaSearchPage.datesInputBox.sendKeys("Jan 30");
        uaSearchPage.travelersCount.click();
        Waiters.pause(1);
        uaSearchPage.getTravelersCount.sendKeys("2");
        uaSearchPage.cabinDropdown.click();

        //uaSearchPage.cabinDropdown.sendKeys("b");
        // Business or First
        Waiters.pause(2);
        uaSearchPage.findFlightsButton.click();
        Waiters.pause(2);
        Assert.assertEquals(uaSearchPage.departureDetails.getText(), "Phoenix, AZ, US to Miami, FL, US");



    }
}
