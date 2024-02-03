package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import utils.BrowserUtils;

public class CarRentalsFunctionalTestSteps extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(CarRentalsFunctionalTestSteps.class);

    @Given("the user navigates to the inarbooking Home Page")
    public void the_user_navigates_to_the_inarbooking_home_page() {

        PAGES.getHomePage().clickBookingLink();
        LOGGER.debug("User is navigated to the booking.com page");
    }

    @When("the user clicks on the Car rentals tab")
    public void the_user_clicks_on_the_car_rentals_tab() {

        PAGES.getCarRentalsHomePage().clickOnCarRentalsTab();
        LOGGER.debug("User is navigated to the Car rentals Home page");
    }

    @Then("the user should see the welcome heading message")
    public void the_user_should_see_the_welcome_heading_message() {

        boolean isWelcomeHeadingCorrect = PAGES.getCarRentalsHomePage().isWelcomeHeadingCorrect();

        Assertions.assertThat(isWelcomeHeadingCorrect)
                .as("Since the user click on the related tab, should navigate to the Car rentals Home Page but failed!")
                .isTrue();

        LOGGER.info("User is navigated to the Car rentals Home page");
    }

    @When("the user enters Pickup Location as {string}")
    public void theUserEntersPickupLocationAs(String pickupLocation) {

        PAGES.getCarRentalsHomePage().enterValueIntoPickupLocationField(pickupLocation);
        LOGGER.debug("User enters Pickup Location correctly");
    }

    @And("the user enters Pickup Hour as {string} and Drop Hour as {string}")
    public void theUserEntersPickupHourAsAndDropHourAs(String pickupHour, String dropHour) {

        PAGES.getCarRentalsHomePage().enterHoursForPickupAndDrop(pickupHour, dropHour);
        LOGGER.debug("User enters Pickup Hour and Drop Hour correctly");
    }

    @And("the user enters Pickup Date as {string}")
    public void theUserEntersPickupDateAs(String pickupDate) {

        PAGES.getCarRentalsHomePage().setPickupDate(pickupDate);
        LOGGER.debug("User enters Pickup Date correctly");
    }

    @And("the user enters Drop-off Date as {string}")
    public void theUserEntersDropOffDateAs(String dropOffDate) {

        PAGES.getCarRentalsHomePage().setDropOffDate(dropOffDate);
        LOGGER.debug("User enters Drop-off Date correctly");
    }

    @And("the user clicks the Search Cars button")
    public void theUserClicksTheSearchCarsButton() {

        PAGES.getCarRentalsHomePage().clickOnTheSearchCarsButton();
        LOGGER.info("User is navigated to the Car Rentals Search Results page");
    }

    @Then("the user confirms the accuracy of the information entered")
    public void theUserConfirmsTheAccuracyOfTheInformationEntered() {

        boolean isWelcomeHeadingCorrect = PAGES.getCarRentalsHomePage().isWelcomeHeadingForCarRentalsSearchResultPage();

        Assertions.assertThat(isWelcomeHeadingCorrect)
                .as("Since the user click on the related tab, should navigate to the Car rentals Search Results Page but failed!")
                .isTrue();

        LOGGER.info("User is navigated to the Car rentals Search Results Page");
    }

    @And("the user enters the Card Credentials as {string}, {string}, {string}, {string}")
    public void theUserEntersTheCardCredentialsAs(String name, String cardNumber, String expirationDate, String cvv) {

        PAGES.getCarRentalsCheckoutPage().enterCardInformation(name, cardNumber, expirationDate, cvv);
        LOGGER.debug("the user enters the card credential");
        BrowserUtils.wait(2);
    }

    @And("the user clicks on the back button")
    public void theUserClicksOnTheBackButton() {

        PAGES.getCarRentalsCheckoutPage().clickOnBackButton();
        LOGGER.debug("the user clicks on the back button");
    }

    @Then("the user navigates to the previous page")
    public void theUserNavigatesToThePreviousPage() {

        boolean isThisDealingPage = PAGES.getCarRentalsCheckoutPage().isThisDealingPage();
        softAssertions.assertThat(isThisDealingPage).as("Since the user clicks on the back button, should be moved to the previous page but does not").isTrue();
    }

    @Then("the user should see the violation message at the bottom of the box")
    public void theUserShouldSeeTheViolationMessageAtTheBottomOfTheBox() {

        boolean isViolationMessageDisplayed = PAGES.getCarRentalsCheckoutPage().isViolationMessageDisplayed();
        softAssertions.assertThat(isViolationMessageDisplayed).as("Since the user enters invalid card number the violation message should be displayed but does not")
                .isTrue();
    }

    @When("types {string} in the pickup location")
    public void typesInThePickupLocation(String location) {

        PAGES.getCarRentalsHomePage().enterValueIntoPickupLocationField(location);
        LOGGER.debug("the user selects the place of pickup preference");
    }

    @Then("the user should see the {string} as the pickup location")
    public void theUserShouldSeeTheAsThePickupLocation(String location) {

        int size = PAGES.getCarRentalsSearchResultsPage().getCarPickupLocationList().size();

        for (int i = 0; i <size; i++) {
            String actual = PAGES.getCarRentalsSearchResultsPage().getCarPickupLocation(i);
            softAssertions.assertThat(actual).isEqualTo(location);
            BrowserUtils.scrollDownWithPageDownButton(1);
        }
    }

    @Then("the user navigates to the dealing page")
    public void theUserNavigatesToTheDealingPage() {
        BrowserUtils.scrollDownWithPageDownButton(2);
        boolean isDealingPage = PAGES.getCarRentalsCheckoutPage().isThisDealingPage();
        softAssertions.assertThat(isDealingPage).as("the user should see the page as Dealing Page").isTrue();
    }

    @When("clicks What is covered button")
    public void clicksWhatIsCoveredButton() {

        BrowserUtils.scrollUpWithPageUpButton(1);
        PAGES.getCarRentalsDealingPage().clickInsuranceCheckBoxes(1);
        BrowserUtils.scrollUpWithPageUpButton(1);
    }

    @Then("verify that the total price is correct")
    public void verifyThatTheTotalPriceIsCorrect() {

       double actual = PAGES.getCarRentalsDealingPage().getTotalPriceUpdated();
       softAssertions.assertThat(actual).isEqualTo(244.80);
    }

    @When("the user clicks on the Go to Book button which is at the bottom")
    public void theUserClicksOnTheGoToBookButtonWhichIsAtTheBottom() {
        
        PAGES.getCarRentalsDealingPage().clickBelowGoToBookButton();
        LOGGER.debug("the user clicks on the Go To Book Button");
    }

    @Then("the user validates whether at the Car Rentals Checkout Page")
    public void theUserValidatesWhetherAtTheCarRentalsCheckoutPage() {

        boolean isThisCheckoutPage = PAGES.getCarRentalsCheckoutPage().isThisCheckoutPage();
        softAssertions.assertThat(isThisCheckoutPage).as("the user should validate the page as CheckoutPage but does not").isTrue();
    }
}
