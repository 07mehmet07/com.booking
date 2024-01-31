package utils;

import pages.HotelDetailsPage;
import pages.HotelInfoPage;
import pages.HotelSearchPage;
import pages.HotelsCheckoutPage;
import lombok.Data;
import pages.*;

@Data
public class Pages {

	private HomePage homePage;

	private HotelDetailsPage hotelDetailsPage;

	private HotelInfoPage hotelInfoPage;

	private HotelsCheckoutPage hotelsCheckoutPage;

	private HotelSearchPage hotelSearchPage;

	private StaysTabHomepage staysTabHomepage;

	public Pages() {
		homePage = new HomePage();
		hotelDetailsPage = new HotelDetailsPage();
		hotelInfoPage = new HotelInfoPage();
		hotelsCheckoutPage = new HotelsCheckoutPage();
		hotelSearchPage = new HotelSearchPage();
		staysTabHomepage = new StaysTabHomepage();
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

	public StaysTabHomepage getStaysTabHomepage() {
		return staysTabHomepage;
	}
}