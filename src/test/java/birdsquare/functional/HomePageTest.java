package birdsquare.functional;

import birdsquare.functional.framework.BaseTest;
import birdsquare.functional.framework.page.LoginPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HomePageTest extends BaseTest {

    @Test
    public void shouldShowHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        assertTrue(loginPage.getLoginContentText().contains("Welcome!"));
    }
}
