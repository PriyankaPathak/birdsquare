package birdsquare.functional.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Page {

    public static final String LOGIN_CONTENT_ID = "login-content";

    @FindBy(how = How.ID, using = LOGIN_CONTENT_ID)
    private WebElement loginContent;

    @FindBy(how = How.ID, using = "facebookLogin")
    private WebElement facebookLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void waitForThePageToLoad() {
        waitForElementToLoad(By.id(LOGIN_CONTENT_ID));
    }

    public String getLoginContentText() {
        return loginContent.getText();
    }

    public FacebookLoginPage redirectToFBLogin() {
        facebookLogin.click();
        return new FacebookLoginPage(webDriver);
    }
}
