package stepdefinitions.flights;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

public class FlightsDetailsPageStepDefs extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(FlightsCheckAndPayPageStepDefs.class);

	@And("the user enter {string} to the contact email input area")
	public void theUserEnterToTheContactEmailInputArea(String email) {
		PAGES.getFlightsDetailsPage().setContactEmailArea(email);
		LOGGER.info("The user enters a valid email");

	}

	@And("the user enters phone number as {string}")
	public void theUserEntersPhoneNumberAs(String phoneNo) {
		PAGES.getFlightsDetailsPage().setPhoneNumberArea(phoneNo);
		LOGGER.info("The user enters a valid phone number");

	}

	@And("the user enters as {string} first name and as {string} last name for #{int} passenger")
	public void theUserEntersAsFirstNameAndAsLastNameForPassenger(String firstName, String lastName,
			int passengerNumber) {
		PAGES.getFlightsDetailsPage().setFirstNameInputAreas(firstName, lastName, passengerNumber);
		LOGGER.info("The user enters a first name and a last name");

	}

	@And("the user select {string} as gender for #{int} passenger")
	public void theUserSelectAsGenderForPassenger(String gender, int numberOfPassenger) {
		PAGES.getFlightsDetailsPage().selectGender(gender, numberOfPassenger);
		BrowserUtils.wait(2);
		LOGGER.info("The user selects a gender and then selects year,month, a day for birth date.");

	}

	@And("the user select birthdate as {string} for #{int} passenger")
	public void theUserSelectBirthdateAsForPassenger(String birthDate, int numOfPassenger) {
		BrowserUtils.scrollDownWithPageDownButton(1);
		PAGES.getFlightsDetailsPage().selectBirthDate(birthDate, numOfPassenger);
		LOGGER.info("The user selects year,month,day for birth date.");

	}

	@And("the user clicks on select extras button")
	public void theUserClicksOnSelectExtrasButton() {
		PAGES.getFlightsDetailsPage().clickOnSelectExtrasButton();
		LOGGER.info("The user clicks on select extras button.");

	}

}