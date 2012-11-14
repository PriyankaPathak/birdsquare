package birdsquare.functional.framework.page;

import birdsquare.functional.framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FacebookLoginPage extends Page {

    public static final String USER_NAME = "email";
    public static final String TEST_USER_NAME = "nyldgvv_sharpeson_1352697835@tfbnw.net";
    public static final String TEST_PASSWORD = "birdsquare123";

    @FindBy(how = How.ID, using = USER_NAME)
    private WebElement username;

    @FindBy(how = How.ID, using = "pass")
    private WebElement password;

    @FindBy(how = How.NAME, using = "login")
    private WebElement loginBtn;

    public FacebookLoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void waitForThePageToLoad() {
        switchToNextWindow();
        waitForElementToLoad(By.id(USER_NAME));
    }

    public HomePage login() {
        username.sendKeys(TEST_USER_NAME);
        password.sendKeys(TEST_PASSWORD);
        loginBtn.click();
        switchBackToMainWindow();

        // TODO this is a bug! upon login, the user should be back at the HomePage
        webDriver.get(BaseTest.HOME_PAGE_URL);
        return new HomePage(webDriver);
    }
}
