package birdsquare.functional.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created with IntelliJ IDEA.
 * User: ashwinko
 * Date: 12/4/12
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class BirdProfilePage extends Page{
    public static final String BIRD_DETAILS_ID = "birdprofile-content";

    @FindBy(how = How.ID, using = BIRD_DETAILS_ID)
    private WebElement birdDetails;

    public BirdProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void waitForThePageToLoad() {
        waitForElementToLoad(By.id(BIRD_DETAILS_ID));
    }


    public boolean birdDetailsAreShown() {
        return birdDetails.isDisplayed();
    }
}
