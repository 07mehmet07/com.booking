package pages.flightspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class FlightsExtrasPage extends BasePage {

	@FindBy(xpath = "//select[@class='form-select fs-4']")
	WebElement selectMeal;

	@FindBy(xpath = "//div/input[@class='form-check-input']")
	List<WebElement> extras;

	@FindBy(css = ".btn.btn-blue>.fs-4")
	WebElement goToCheckoutButton;

	public void setSelectMeal(int i) {
		Select select = new Select(selectMeal);
		select.selectByIndex(i - 1);
	}

	public void clickOnExtras(int i) {
		extras.get(i - 1).click();
	}

	public void clickOnGoToCheckoutButton() {
		goToCheckoutButton.click();
	}

}
