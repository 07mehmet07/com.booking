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

	@FindBy(xpath = "//span[@class='fs-4 fw-bold w-50 text-end']")
	List<WebElement> pricesOfExtra;

	@FindBy(xpath = "//div[@class='d-flex flex-column justify-content-end align-items-end']/span[1]")
	List<WebElement> totalPrice;

	// String str = "$1245";
	// str = str.replaceAll("[^\\d]", ""); // Sadece sayıları alır
	// int number = Integer.parseInt(str);
	// System.out.println(number); // Çıktı: 1245
	//

	public boolean isCorrectTotalPriceOfExtra() {
		List<String> number = totalPrice.stream().map(WebElement::getText).toList();
		return number.contains(getTotalPricesOfMainExtra());
	}

	// public Double getTotalPrice() {
	// return Double
	// .parseDouble(totalPriceWithTaxes.getText().substring(totalPriceWithTaxes.getText().indexOf("$")
	// + 1));
	// }

	public int getTotalPricesOfMainExtra() {
		int mainTotalOfPassenger1 = Integer.parseInt(pricesOfExtra.get(0).getText());
		int mainTotalOfPassenger2 = Integer.parseInt(pricesOfExtra.get(4).getText());
		return mainTotalOfPassenger1 + mainTotalOfPassenger2;
	}

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
