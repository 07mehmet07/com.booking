package stepdefinitions.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import stepdefinitions.BaseStep;

public class FlightsExtrasPageStepsDefs extends BaseStep {

    @And("the user select {string} from the select meal dropdown menu")
    public void theUserSelectFromTheSelectMealDropdownMenu(String menu) {
        PAGES.getFlightsExtrasPage().setSelectMeal(menu);}


    @And("the user select Add Extra Legroom Seat for extra")
    public void theUserSelectAddExtraLegroomSeatForExtra() {
        PAGES.getFlightsExtrasPage().clickOnExtras(3);
    }

    @When("The user click on go to checkout button")
    public void the_user_click_on_go_to_checkout_button() {
        PAGES.getFlightsExtrasPage().clickOnGoToCheckoutButton();
    }

}
