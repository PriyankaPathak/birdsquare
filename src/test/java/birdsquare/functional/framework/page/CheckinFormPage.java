package birdsquare.functional.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckinFormPage extends Page {

    public static final String LOCATION_FIELD_ID = "location-field";

    @FindBy(how = How.ID, using = "birdname-field")
    private WebElement birdName;

    @FindBy(how = How.ID, using = "numberofbirds-field")
    private WebElement numberOfBirds;

    @FindBy(how = How.ID, using = "submit")
    private WebElement submit;

    public CheckinFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void waitForThePageToLoad() {
        waitForElementToLoad(By.id(LOCATION_FIELD_ID));
    }

    public void submitForm(String birdNameText, String numberOfBirdsText) {
        birdName.sendKeys(birdNameText);
        numberOfBirds.sendKeys(numberOfBirdsText);
        submit.click();
    }
}
