package pages.flightspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class FlightsSelectTicketPage extends BasePage {


    @FindBy(css = "button.text-center")
    List<WebElement> selectTicketButtons;







    public void selectTicketForRoundWay(int i){
        selectTicketButtons.get(0).click();
    }






}
