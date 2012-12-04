package birdsquare.functional.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage extends Page {

    public static final String BIRD_LIST_ID = "birdlist";

    @FindBy(how = How.ID, using = BIRD_LIST_ID)
    private WebElement birdlist;

    @FindBy(how = How.ID, using = "birdnumber")
        private WebElement birdnumber;

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void waitForThePageToLoad() {
        waitForElementToLoad(By.id(BIRD_LIST_ID));
    }

    public boolean birdListIsShown() {
        return birdlist.isDisplayed();
    }

    public BirdProfilePage redirectToBirdProfilePage() {
        birdnumber.click();
        return new BirdProfilePage(webDriver);
    }
}
