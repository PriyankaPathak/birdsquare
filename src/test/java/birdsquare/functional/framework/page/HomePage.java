package birdsquare.functional.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends Page {

    public static final String HOME_CONTENT_ID = "home-content";

    @FindBy(how = How.ID, using = "fb-logout-btn")
    private WebElement logoutBtn;

    @FindBy(how = How.ID, using = "sighting")
    private WebElement sighting;

    @FindBy(how = How.ID, using = "userpoints-number")
    private WebElement userPoints;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void waitForThePageToLoad() {
        waitForElementToLoad(By.id(HOME_CONTENT_ID));
    }

    public CheckinLocationPage checkIn() {
        sighting.click();
        return new CheckinLocationPage(webDriver);
    }

    public boolean isLogoutButtonVisible() {
        return logoutBtn != null;
    }

    public boolean userPointsIsShown() {
        return userPoints.isDisplayed();
    }

    public int getCurrentUserPoints(){
        return Integer.parseInt(userPoints.getText());
    }
}
