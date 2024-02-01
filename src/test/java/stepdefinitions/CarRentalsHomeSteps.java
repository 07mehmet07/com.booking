package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

public class CarRentalsHomeSteps extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(CarRentalsHomeSteps.class);

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

}
