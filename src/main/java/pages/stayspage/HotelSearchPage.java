package pages.stayspage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class HotelSearchPage extends BasePage {

	@FindBy(xpath = "(//button[@class=\"siCheckButton\"])")
	private List<WebElement> seeAvailabilityButtons;

	@FindBy(css = "h1.siTitle")
	private List<WebElement> hotelTitles;

	@FindBy(css = "h2.fs-4")
	private List<WebElement> hotelLocatedCountry;

	@FindBy(css = "h2.fs-5")
	private List<WebElement> hotelLocatedCity;

	@FindBy(css = "span.siDistance")
	private List<WebElement> hotelDistance;

	@FindBy(css = "span.siTaxiOp")
	private List<WebElement> hotelTaxiOp;

	@FindBy(css = "span.siSubtitle")
	private List<WebElement> hotelSubTitle;

	@FindBy(css = "span.siFeatures")
	private List<WebElement> hotelFeatures;

	@FindBy(css = "span.siCancelOp")
	private List<WebElement> hotelCancelOp;

	@FindBy(css = "span.siCancelOpSubtitle")
	private List<WebElement> hotelCancelOpSubtitle;

	@FindBy(css = "span.siPrice")
	private List<WebElement> hotelPrices;

	@FindBy(css = "button.pagination-button-booking")
	private List<WebElement> paginationButtons;

	@FindBy(css = "span.siPrice")
	private List<WebElement> priceTags;

	@FindBy(css = "input")
	private List<WebElement> inputFields;

	@FindBy(xpath = "//button[text()=\"Search\"]")
	private WebElement searchButton;

	public void clickSeeAvailabilityButton(int index) {
		seeAvailabilityButtons.get(index).click();
	}

	public ArrayList<String> getHotelTags() {
		ArrayList<String> hotelTags = new ArrayList<>();
		for (int i = 0; i < paginationButtons.size(); i++) {
			clickPageButton(i);
			for (int j = 0; j < hotelTitles.size(); j++) {
				StringBuilder s = new StringBuilder();
				s.append(hotelTitles.get(j).getText()).append(" - ");
				s.append(hotelLocatedCountry.get(j).getText()).append(" - ");
				s.append(hotelLocatedCity.get(j).getText()).append(" - ");
				s.append(hotelDistance.get(j).getText()).append(" - ");
				s.append(hotelTaxiOp.get(j).getText()).append(" - ");
				s.append(hotelSubTitle.get(j).getText()).append(" - ");
				s.append(hotelFeatures.get(j).getText()).append(" - ");
				s.append(hotelCancelOp.get(j).getText()).append(" - ");
				s.append(hotelCancelOpSubtitle.get(j).getText());
				hotelTags.add(s.toString());
			}
		}
		return hotelTags;
	}

	public void clickPageButton(int page) {
		wait.until(ExpectedConditions.elementToBeClickable(paginationButtons.get(page)));
		actions.moveToElement(paginationButtons.get(page)).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(paginationButtons.get(page)));
		actions.click(paginationButtons.get(page)).build().perform();
		BrowserUtils.wait(1);
	}

	public String checkBoxChooser() {
		int index = (int) (Math.random() * 10) + 19;
		wait.until(ExpectedConditions.visibilityOf(inputFields.get(index)));
		actions.moveToElement(inputFields.get(index)).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(inputFields.get(index)));
		actions.click(inputFields.get(index)).build().perform();
		return inputFields.get(index).getAttribute("value");
	}

	public void clickSearchButton() {
		wait.until(ExpectedConditions.visibilityOf(searchButton));
		actions.moveToElement(searchButton).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		actions.click(searchButton).build().perform();
	}

	public ArrayList<String> getWholeNames() {
		ArrayList<String> hotelNames = new ArrayList<>();
		for (WebElement hotelTitle : hotelTitles) {
			hotelNames.add(hotelTitle.getText());
		}
		return hotelNames;
	}

	public boolean isAnyHotelTitleDisplayed() {
		return hotelTitles.isEmpty();
	}

	public void increaseMinPriceBy50() {
		actions.keyDown(Keys.TAB).keyDown(Keys.TAB).keyDown(Keys.TAB).keyDown(Keys.ARROW_RIGHT).build().perform();
	}

	public ArrayList<Integer> getWholePrices() {
		ArrayList<Integer> prices = new ArrayList<>();
		for (int i = 0; i < paginationButtons.size(); i++) {
			clickPageButton(i);
			for (int j = 0; j < hotelTitles.size(); j++) {
				prices.add(Integer.parseInt(hotelPrices.get(j).getText().replace("$", "")));
			}
		}
		return prices;
	}

	public void decreaseMaxPriceTo50() {
		actions.keyDown(Keys.TAB)
				.keyDown(Keys.TAB)
				.keyDown(Keys.TAB)
				.keyDown(Keys.TAB)
				.build()
				.perform();
		for (int i = 0; i < 200; i++) {
			actions.keyDown(Keys.ARROW_LEFT).build().perform();
		}
		actions.keyDown(Keys.ARROW_RIGHT).build().perform();
	}

}