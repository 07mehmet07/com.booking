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
		PAGES.getHotelsCheckoutPage().fillCardHoldersNameField("TarÄ±q Jake Gulbas");
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

	// Validation Test of booking one room for twenty adults Test
	@And("choose the adult option for twenty times")
	public void chooseTheAdultOptionForTwentyTimes() {
		LOGGER.debug("User can not choose twenty adult for one room.");
		PAGES.getHotelsTabHomePage().increaseAdultCountForManyTimes(20);
	}

	// Min Price Functionality Test
	public static List<Integer> prices = new ArrayList<>();

	@Given("user increase min price to fifty dollars")
	public void user_increase_min_price_to_fifty_dollars() {
		PAGES.getHotelSearchPage().increaseMinPriceBy50();
		LOGGER.debug("User increased min price to $50");
	}

	@Then("user should see only hotels with min fifty dollars price")
	public void user_should_see_only_hotels_with_min_fifty_dollars_price() {
		prices = PAGES.getHotelSearchPage().getWholePrices();
		for (int price : prices) {
			Assertions.assertThat(price).isEqualTo(50);
		}
		LOGGER.info("User sees only hotels with $50");
	}

	// Max Price Functionality Test

	@Given("user increase max price to fifty dollars")
	public void user_increase_max_price_to_fifty_dollars() {
		prices = null;
		PAGES.getHotelSearchPage().decreaseMaxPriceTo50();
		LOGGER.debug("User increased max price to $50");
	}

	@Then("user should see only hotels with max fifty dollars price")
	public void user_should_see_only_hotels_with_max_fifty_dollars_price() {
		prices = PAGES.getHotelSearchPage().getWholePrices();
		for (int price : prices) {
			Assertions.assertThat(price).isEqualTo(50);
		}
		LOGGER.info("User sees only hotels with $50");
	}

	// Invalid credentials test
	@Given("types {string} in the search bar")
	public void types_in_the_search_bar(String city) {
		PAGES.getHotelsTabHomePage().clickOnCityField();
		PAGES.getHotelsTabHomePage().sendKeysToDestination(city);
		LOGGER.info("User sends " + city + " as a destination");
	}

	@When("user fills {string}, {string}, {string} fields")
	public void user_fills_fields(String firstName, String lastName, String email) {
		PAGES.getHotelDetailsPage().fillFirstNameField(firstName);
		PAGES.getHotelDetailsPage().fillLastNameField(lastName);
		PAGES.getHotelDetailsPage().fillEmailField(email);
		BrowserUtils.scrollDownWithPageDownButton(1);
	}

	@When("in the final details page user fills {string}, {string}, {string}, {string} afterwards clicks complete booking button")
	public void in_the_final_details_page_user_fills_afterwards_clicks_complete_booking_button(String phoneNumber,
			String cardHoldersName, String cardNumber, String cvc) {
		BrowserUtils.scrollUpWithPageUpButton(2);
		PAGES.getHotelsCheckoutPage().fillPhoneNumberField(phoneNumber);
		BrowserUtils.scrollDownWithPageDownButton(1);
		PAGES.getHotelsCheckoutPage().fillCardHoldersNameField(cardHoldersName);
		BrowserUtils.scrollDownWithPageDownButton(1);
		PAGES.getHotelsCheckoutPage().fillCardNumberField(cardNumber);
		PAGES.getHotelsCheckoutPage().fillExpDateField("11/28");
		PAGES.getHotelsCheckoutPage().fillCvvField(cvc);
		PAGES.getHotelsCheckoutPage().clickCompleteBookingButton();
		LOGGER.info("User filled payment credentials in the page and clicked complete button");
	}

	@Then("user should not see checkout dialogue and so will not be able to click close button properly")
	public void user_should_not_see_checkout_dialogue_and_so_will_not_be_able_to_click_close_button_properly() {
		try {
			boolean result = PAGES.getHotelsTabHomePage().isTheDialogueDisplayed();
			LOGGER.debug("User sees the dialogue is displayed");
			Assertions.fail("Dialogue is displayed");
			BrowserUtils.scrollDownWithPageDownButton(1);
			PAGES.getHotelsTabHomePage().closeTheDialog();
		}
		catch (Exception ex) {
			Assertions.assertThat(true).isTrue();
			LOGGER.info("The dialogue is not displayed");
		}
	}

	// Validation Test of FÄ°ndAStay at Offers Test
	@And("user click to the find a stay button")
	public void user_click_to_the_find_a_stay_button() {
		LOGGER.info("User clicks to FindAStay button for navigate to page");
		PAGES.getHotelsTabHomePage().clickOnFindAStayButton();
	}

	@Then("user have to reach Offering hotels")
	public void user_have_to_reach_offering_hotels() {
		LOGGER.debug("User have to seee offering hotels in the page ");
		String errorMessageDisplayed = PAGES.getHotelsTabHomePage().isTheErrorMessageDisplayed();
		Assertions.assertThat(errorMessageDisplayed).isEqualTo("404 Not Found");
	}

	// functionality of destinationHotelField Test
	@And("types numbers in the search bar")
	public void types_numbers_in_the_search_bar() {
		LOGGER.debug("User can not enter numbers to Destination field");
		PAGES.getHotelsTabHomePage().sendKeysToDestination("12354678");
	}

	// phone Number SelectionButton validation Test
	@And("in the final details page user selects US and fill the phone number")
	public void in_the_final_details_page_user_selects_us_and_fill_the_phone_number() {
		BrowserUtils.scrollUpWithPageUpButton(2);
		LOGGER.info("user selects phoneCountry as US and enters vlid phone Number for US");
		PAGES.getHotelsCheckoutPage().selectPhoneCountry("US");
		PAGES.getHotelsCheckoutPage().fillPhoneNumberField("5555551234");
		BrowserUtils.wait(0.5);
	}

	@And("user change selection to Fr")
	public void user_change_selection_to_fr() {
		LOGGER.info("User changes the selection to FR");
		PAGES.getHotelsCheckoutPage().selectPhoneCountry("FR");
	}

	@Then("user shows the invalid phone number message")
	public void user_shows_the_invalid_phone_number_message() {
		LOGGER.debug("After changing selection of Country from US to FR user get Invalid phone number message.");
		PAGES.getHotelsCheckoutPage().isDisplayedInvalidPhoneNumberMessage();
	}

}