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

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void waitForThePageToLoad() {
        waitForElementToLoad(By.id(HOME_CONTENT_ID));
    }

    public boolean isLogoutButtonVisible() {
        return logoutBtn != null;
    }
}
