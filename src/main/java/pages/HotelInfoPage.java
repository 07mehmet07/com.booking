package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HotelInfoPage extends BasePage {

	@FindBy(xpath = "//button[@class='bookNow']")
	private WebElement bookNowButton;

	public void clickBookNowButton() {
		bookNowButton.click();
	}

}
