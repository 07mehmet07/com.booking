package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HotelDetailsPage extends BasePage {
    @FindBy(xpath = "(//input[@name=\"firstname\"])")
    private WebElement firstNameField;

    @FindBy(xpath = "(//input[@name=\"firstname\"])")
    private WebElement lastNameField;

    @FindBy(xpath = "(//input[@name=\"firstname\"])")
    private WebElement emailField;

    public void fillFirstNameField(String text){
        firstNameField.sendKeys(text);
    }
    public void fillLastNameField(String text){
        firstNameField.sendKeys(text);
    }
    public void fillEmailField(String text){
        firstNameField.sendKeys(text);
    }
}
