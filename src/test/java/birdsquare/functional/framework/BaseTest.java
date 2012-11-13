package birdsquare.functional.framework;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public abstract class BaseTest {

    public static String HOME_PAGE_URL = Environments.getHomePageUrl();

    protected WebDriver webDriver;

    @Before
    public void setUp() {
        File profileDir = new File(getFirefoxProfile());
        FirefoxProfile profile = new FirefoxProfile(profileDir);
        webDriver = new FirefoxDriver(profile);
        webDriver.get(BaseTest.HOME_PAGE_URL);
        new WebDriverWait(webDriver, 10).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return (Boolean) ((JavascriptExecutor)webDriver).executeScript("return FB != null;");
            }
        });
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    private String getFirefoxProfile() {
        String workingDir = System.getProperty("user.dir");
        return String.format("%s/src/test/java/birdsquare/functional/firefox/profile", workingDir);
    }
}
