package birdsquare.functional;

import birdsquare.functional.framework.BaseTest;
import birdsquare.functional.framework.page.HomePage;
import birdsquare.functional.framework.page.LoginPage;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class HomePageTest extends BaseTest {

    @Test
    public void shouldRedirectToLoginBeforeShowingTheHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        assertTrue(loginPage.getLoginContentText().contains("Welcome!"));

        HomePage homePage = loginPage.redirectToFBLogin().login();
        assertTrue(homePage.isLogoutButtonVisible());
    }

    @Test
    public void shouldDisplayUserPointsOnHomePage() {
        HomePage homePage = new LoginPage(webDriver).redirectToFBLogin().login();

        assertTrue(homePage.userPointsIsShown());
    }

    @Test
    public void shouldDisplayLeaderboardOnHomePage() {
        HomePage homePage = new LoginPage(webDriver).redirectToFBLogin().login();

        assertTrue(homePage.leaderboardIsShown());
    }
}
