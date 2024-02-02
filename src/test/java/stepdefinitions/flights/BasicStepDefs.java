package stepdefinitions.flights;

import io.cucumber.java.en.Given;
import stepdefinitions.BaseStep;

public class BasicStepDefs extends BaseStep {
    @Given("the user is on the Inar Academy homepage and clicks on the Booking link")
    public void the_user_is_on_the_ınar_academy_homepage_and_clicks_on_the_booking_link() {
        PAGES.getHomePage().clickBookingLink();
    }


}
