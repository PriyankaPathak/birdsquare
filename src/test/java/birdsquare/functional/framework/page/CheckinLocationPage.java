package birdsquare.functional.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckinLocationPage extends Page {

    public static final String FIRST_LOCATION_ID = "location-0";

    @FindBy(how = How.ID, using = FIRST_LOCATION_ID)
    private WebElement firstLocation;

    public CheckinLocationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void waitForThePageToLoad() {
        waitForElementToLoad(By.id(FIRST_LOCATION_ID));
    }

    public CheckinFormPage selectLocation() {
        firstLocation.click();
        return new CheckinFormPage(webDriver);
    }
}
