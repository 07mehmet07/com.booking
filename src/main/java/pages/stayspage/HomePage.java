package pages.stayspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HomePage extends BasePage {

	@FindBy(linkText = "Booking")
	private WebElement bookingLink;

	public HomePage() {
		super();
	}

	public void clickBookingLink() {
		bookingLink.click();
	}

}
