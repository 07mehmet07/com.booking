package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import utils.BrowserUtils;
import utils.DriverManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HotelBookingSteps extends stepdefinitions.BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(HotelBookingSteps.class);

	@Given("user is in the booking.com page")
	public void user_is_in_the_booking_com_page() {
		PAGES.getHomePage().clickBookingLink();
		LOGGER.info("User is navigated to the booking.com page");
	}

	@And("types New York in the search bar")
	public void types_new_york_in_the_search_bar() {
		PAGES.getHotelsTabHomePage().clickOnCityField();
		PAGES.getHotelsTabHomePage().sendKeysToDestination("New York");
		LOGGER.info("User sends New York as a destination");
	}

	@And("chooses next month's 8'th day to 10'th day")
	public void chooses_next_month_s_8_day_to_10_day() {
		PAGES.getHotelsTabHomePage().clickDatePickerAndSelect(1);
		LOGGER.info("User selects days 8 to 10");
	}

	@And("chooses one adult")
	public void chooses_one_adult() {
		LOGGER.info("One adult is selected default");
	}

	@And("clicks search hotels button")
	public void clicks_search_hotels_button() {
		PAGES.getHotelsTabHomePage().clickOnSearchButton();
		LOGGER.info("User Clicks on the Search Button");
	}

	@When("user navigated to hotel search page")
	public void user_navigated_to_hotel_search_page() {
		LOGGER.info("User is navigated to Hotel Search Page");
	}

	@And("user chooses first hotel")
	public void user_chooses_first_hotel() {
		PAGES.getHotelSearchPage().clickSeeAvailabilityButton(0);
		LOGGER.info("User clicks to See Availability Button");
	}

	@And("in the mentioned hotel's description page user clicks reserve or book now")
	public void in_the_mentioned_hotel_s_description_page_user_clicks_reserve_or_book_now() {
		PAGES.getHotelInfoPage().clickBookNowButton();
		LOGGER.info("User in the Hotel's Info Page and clicks book now button");
	}

	@And("user sees checkout process' first page")
	public void user_sees_checkout_process_first_page() {
		LOGGER.info("User in the Hotel's Detail Page");
	}

	@And("user selects the work selection")
	public void userSelectsTheWorkSelection() {
		PAGES.getHotelDetailsPage().selectTheTravelForWork("yes");
		BrowserUtils.wait(0.5);
	}

	@And("user fills first name, last name, email fields")
	public void userFillsFirstNameLastNameEmailFields() {
		PAGES.getHotelDetailsPage().fillFirstNameField("Sefa");
		PAGES.getHotelDetailsPage().fillLastNameField("Ataker");
		PAGES.getHotelDetailsPage().fillEmailField("KingCan@gmail.com");
		BrowserUtils.scrollDownWithPageDownButton(1);
	}

	@And("user selects the Who are you booking for")
	public void userSelectsTheWhoAreYouBookingFor() {
		PAGES.getHotelDetailsPage().selectTheWhoAreYouBookingFor(2);
		BrowserUtils.scrollDownWithPageDownButton(1);
	}

	@And("user click to the next page button")
	public void userClickToTheNextPageButton() {
		PAGES.getHotelDetailsPage().clickFinalDetailsButton();
	}

	@And("in the final details page user fills phone number, card holders name, card number, cvc afterwards clicks complete booking button")
	public void in_the_final_details_page_user_fills_phone_number_card_holders_name_card_number_cvc_afterwards_clicks_complete_booking_button() {
		BrowserUtils.scrollUpWithPageUpButton(2);
		PAGES.getHotelsCheckoutPage().fillPhoneNumberField("5555551234");
		BrowserUtils.scrollDownWithPageDownButton(1);
		PAGES.getHotelsCheckoutPage().fillCardHoldersNameField("Tarıq Jake Gulbas");
		BrowserUtils.scrollDownWithPageDownButton(1);
		PAGES.getHotelsCheckoutPage().fillCardNumberField("1234123412341234");
		PAGES.getHotelsCheckoutPage().fillExpDateField("11/28");
		PAGES.getHotelsCheckoutPage().fillCvvField("123");
		PAGES.getHotelsCheckoutPage().clickCompleteBookingButton();
		LOGGER.info("User filled payment credentials in the page and clicked complete button");
	}

	@Then("user should see checkout dialogue and click close button properly")
	public void user_should_see_checkout_dialogue_and_click_close_button_properly() {
		boolean result = PAGES.getHotelsTabHomePage().isTheDialogueDisplayed();
		Assertions.assertThat(result).isTrue();
		LOGGER.info("User sees the dialogue is displayed");
		BrowserUtils.scrollDownWithPageDownButton(1);
		PAGES.getHotelsTabHomePage().closeTheDialog();
	}

	@And("verify user sees booking.com homepage")
	public void verify_user_sees_booking_com_homepage() {
		boolean result = DriverManager.getWebDriver()
			.getCurrentUrl()
			.startsWith("https://InarAcademy:Fk160621.@test.inar-academy.com/booking");
		Assertions.assertThat(result).isTrue();
		LOGGER.info("User is navigated to the home page");
	}

	// Duplicate Test
	public static List<String> hotelTagsList = new ArrayList<>();

	public static Set<String> hotelTagsSet = new HashSet<>();

	@When("automation collects all hotel names by passing through pages")
	public void automation_collects_all_hotel_names_by_passing_through_pages() {
		hotelTagsList = PAGES.getHotelSearchPage().getHotelTags();
		LOGGER.debug("There are " + hotelTagsList.size() + " hotel cards in total website");
		hotelTagsSet.addAll(hotelTagsList);
		LOGGER.debug("There are " + hotelTagsSet.size() + " hotel cards in control set");
	}

	@Then("an assertion is made to check whether there are any duplicate")
	public void an_assertion_is_made_to_check_whether_there_are_any_duplicate() {
		Assertions.assertThat(hotelTagsList.size()).isEqualTo(hotelTagsSet.size());
		LOGGER.info("User sees that there are only unique hotel tags");
	}

	// Brand Checkbox Test

	public static String brandName;

	public static ArrayList<String> names;

	@When("user clicks a random brand name button")
	public void user_clicks_a_random_brand_name_button() {
		brandName = PAGES.getHotelSearchPage().checkBoxChooser();
		LOGGER.debug("User clicks a random checkbox");
	}

	@When("clicks search button")
	public void clicks_search_button() {
		PAGES.getHotelSearchPage().clickSearchButton();
		LOGGER.debug("User clicks search button");
	}

	@Then("user should see only same brand hotels as the checkbox")
	public void user_should_see_only_same_brand_hotels_as_the_checkbox() {
		names = PAGES.getHotelSearchPage().getWholeNames();
		for (String name : names) {
			Assertions.assertThat(brandName).isEqualTo(name);
		}
		LOGGER.info("User sees only mentioned hotel brand");
	}

	// QuickAndEasyTripPlannerTest
	@When("automation collects the numbers of Hotels Resorts Luxery and Cabins and Checks the numbers validation")
	public void automation_collects_the_numbers_of_hotels_resorts_luxery_and_cabins_and_checks_the_numbers_validation() {
		BrowserUtils.scrollDownWithPageDownButton(3);
		BrowserUtils.wait(0.5);
		LOGGER.info("Hotels,Resorts,Luxery and Cabins numbers must be true!");
		PAGES.getHotelsTabHomePage()
			.checkTheTotalNumbersOfHotelsResortsLuxeryAndCabins("9361 hotels", "9583 hotels", "9361 hotels",
					"8695 hotels");
		LOGGER.debug("All Item's numbers are correct!");
		BrowserUtils.wait(1.0);
	}

	@When("click to the Hotels cabins tab")
	public void click_to_the_hotels_cabins_tab() {
		LOGGER.info("User have to navigate to the Hotel Serch Page for Cabins");
		PAGES.getHotelsTabHomePage().clickOnOptionInQuickPlanner("Cabins");
	}

	@Then("user should see the Cabin Hotels in new page")
	public void user_should_see_the_cabin_hotels_in_new_page() {
		Assertions.assertThat(PAGES.getHotelSearchPage().isAnyHotelTitleDisplayed()).isTrue();
		LOGGER.debug("Cabins Page do not show any Hotel!");
	}

	// Validation Test of booking one room for twenty adults
	@And("choose the adult option for twenty times")
	public void chooseTheAdultOptionForTwentyTimes() {
		LOGGER.debug("User can not choose twenty adult for one room.");
		PAGES.getHotelsTabHomePage().increaseAdultCountForManyTimes(20);
	}

}