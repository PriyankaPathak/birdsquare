package birdsquare.functional.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CheckinFormPage extends Page {

    public static final String LOCATION_FIELD_ID = "location-field";

    @FindBy(how = How.ID, using = "birdname-field")
    private WebElement birdNameField;

    @FindBy(how = How.ID, using = "numberofbirds-field")
    private WebElement numberOfBirdsField;

    @FindBy(how = How.ID, using = "submit")
    private WebElement submit;

    @FindBy(how = How.ID, using = "comments")
    private WebElement commentField;

    public CheckinFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void waitForThePageToLoad() {
        waitForElementToLoad(By.id(LOCATION_FIELD_ID));
    }

    public void submitForm(String birdNameText, String numberOfBirdsText) {
        submitForm(birdNameText, numberOfBirdsText, "");
    }

    public void submitForm(String birdNameText, String numberOfBirdsText, String comment) {
        birdNameField.sendKeys(birdNameText);
        birdNameField.sendKeys(Keys.DOWN);
        numberOfBirdsField.sendKeys(numberOfBirdsText);
        commentField.sendKeys(comment);
        submit.click();
    }

    public List<WebElement> getBirdAutocompleteListFor(String partialBirdNameText) {
        String autoCompleteSelectionCss = ".ui-autocomplete li";

        birdNameField.sendKeys(partialBirdNameText);
        waitForElementToLoad(By.cssSelector(autoCompleteSelectionCss));
        return webDriver.findElements(By.cssSelector(autoCompleteSelectionCss));
    }
}
