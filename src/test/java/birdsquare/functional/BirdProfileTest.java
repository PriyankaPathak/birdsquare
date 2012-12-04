package birdsquare.functional;

import birdsquare.functional.framework.BaseTest;
import birdsquare.functional.framework.page.BirdProfilePage;
import birdsquare.functional.framework.page.HomePage;
import birdsquare.functional.framework.page.LoginPage;
import birdsquare.functional.framework.page.SearchPage;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class BirdProfileTest extends BaseTest{
    @Test
    public void birdListShouldBeShown(){
        HomePage homePage = new LoginPage(webDriver).redirectToFBLogin().login();
        SearchPage searchPage = homePage.search();
        assertTrue(searchPage.birdListIsShown());
    }

    @Test
    public void birdProfileIsShown(){
        HomePage homePage = new LoginPage(webDriver).redirectToFBLogin().login();
        SearchPage searchPage = homePage.search();
        BirdProfilePage birdProfilePage = searchPage.redirectToBirdProfilePage();
        assertTrue(birdProfilePage.birdDetailsAreShown());
    }
}
