package utils;

import lombok.Data;
import pages.HomePage;
import pages.carrentalspage.CarRentalsCheckoutPage;
import pages.carrentalspage.CarRentalsDealingPage;
import pages.carrentalspage.CarRentalsHomePage;
import pages.carrentalspage.CarRentalsSearchResultsPage;
import pages.flightspage.*;
import pages.stayspage.*;

@Data
public class Pages {

	private CarRentalsCheckoutPage carRentalsCheckoutPage;

	private CarRentalsDealingPage carRentalsDealingPage;

	private CarRentalsHomePage carRentalsHomePage;

	private CarRentalsSearchResultsPage carRentalsSearchResultsPage;

	private FlightsBookingResultPage flightsBookingResultPage;

	private FlightsCheckAndPayPage flightsCheckAndPayPage;

	private FlightsDetailsPage flightsDetailsPage;

	private FlightsExtrasPage flightsExtrasPage;

	private FlightsFarePage flightsFarePage;

	private FlightsHomePage flightsHomePage;

	private FlightsSelectTicketPage flightsSelectTicketPage;

	private HomePage homePage;

	private HotelDetailsPage hotelDetailsPage;

	private HotelInfoPage hotelInfoPage;

	private HotelsCheckoutPage hotelsCheckoutPage;

	private HotelSearchPage hotelSearchPage;

	private HotelsTabHomePage hotelsTabHomePage;

	public Pages() {
		homePage = new HomePage();
		hotelDetailsPage = new HotelDetailsPage();
		hotelInfoPage = new HotelInfoPage();
		hotelsCheckoutPage = new HotelsCheckoutPage();
		hotelSearchPage = new HotelSearchPage();
		hotelsTabHomePage = new HotelsTabHomePage();
		carRentalsCheckoutPage = new CarRentalsCheckoutPage();
		carRentalsDealingPage = new CarRentalsDealingPage();
		carRentalsHomePage = new CarRentalsHomePage();
		carRentalsSearchResultsPage = new CarRentalsSearchResultsPage();
		flightsBookingResultPage = new FlightsBookingResultPage();
		flightsCheckAndPayPage = new FlightsCheckAndPayPage();
		flightsDetailsPage = new FlightsDetailsPage();
		flightsExtrasPage = new FlightsExtrasPage();
		flightsFarePage = new FlightsFarePage();
		flightsHomePage = new FlightsHomePage();
		flightsSelectTicketPage = new FlightsSelectTicketPage();
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public HotelDetailsPage getHotelDetailsPage() {
		return hotelDetailsPage;
	}

	public HotelInfoPage getHotelInfoPage() {
		return hotelInfoPage;
	}

	public HotelsCheckoutPage getHotelsCheckoutPage() {
		return hotelsCheckoutPage;
	}

	public HotelSearchPage getHotelSearchPage() {
		return hotelSearchPage;
	}

	public HotelsTabHomePage getHotelsTabHomePage() {
		return hotelsTabHomePage;
	}

	public FlightsBookingResultPage getFlightsBookingResultPage() {
		return flightsBookingResultPage;
	}

	public FlightsCheckAndPayPage getFlightsCheckAndPayPage() {
		return flightsCheckAndPayPage;
	}

	public FlightsDetailsPage getFlightsDetailsPage() {
		return flightsDetailsPage;
	}

	public FlightsExtrasPage getFlightsExtrasPage() {
		return flightsExtrasPage;
	}

	public FlightsFarePage getFlightsFarePage() {
		return flightsFarePage;
	}

	public FlightsHomePage getFlightsHomePage() {
		return flightsHomePage;
	}

	public FlightsSelectTicketPage getFlightsSelectTicketPage() {
		return flightsSelectTicketPage;
	}

	public CarRentalsCheckoutPage getCarRentalsCheckoutPage() {
		return carRentalsCheckoutPage;
	}

	public CarRentalsDealingPage getCarRentalsDealingPage() {
		return carRentalsDealingPage;
	}

}