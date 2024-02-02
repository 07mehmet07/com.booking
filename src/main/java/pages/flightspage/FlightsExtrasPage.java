package pages.flightspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class FlightsExtrasPage extends BasePage {

	@FindBy(css = "select.fs-4")
	private WebElement selectMeal;

	@FindBy(css = "select.fs-4>option")
	private List<WebElement> namesOfMeals;

	@FindBy(xpath = "//div/input[@class='form-check-input']")
	List<WebElement> extras;

	@FindBy(css = ".btn.btn-blue>.fs-4")
	WebElement goToCheckoutButton;

	public void setSelectMeal(String mealName) {
		List<String> listOfMeals = namesOfMeals.stream().map(meal -> meal.getAttribute("value")).toList();
		Select selectMeals = new Select(selectMeal);
		selectMeals.selectByIndex(listOfMeals.indexOf(mealName));
	}

	public void clickOnExtras(int i) {
		extras.get(i - 1).click();
	}

	public void clickOnGoToCheckoutButton() {
		goToCheckoutButton.click();
	}

}
