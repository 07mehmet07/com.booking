package pages.stayspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class HotelSearchPage extends BasePage {

	@FindBy(xpath = "(//button[@class=\"siCheckButton\"])")
	private List<WebElement> seeAvailabilityButtons;

	public void clickSeeAvailabilityButton(int index) {
		seeAvailabilityButtons.get(index).click();
	}

}
