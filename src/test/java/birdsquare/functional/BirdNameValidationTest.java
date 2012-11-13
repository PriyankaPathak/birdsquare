package birdsquare.functional;

import birdsquare.functional.framework.BaseTest;
import birdsquare.functional.framework.page.CheckinLocationPage;
import birdsquare.functional.framework.page.LoginPage;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class BirdNameValidationTest extends BaseTest {

    @Test
    public void checkInAnInvalidBird() {
        CheckinLocationPage checkinLocationPage = new LoginPage(webDriver).redirectToFBLogin().login().checkIn();
        checkinLocationPage.selectLocation().submitForm("123", "0");

        assertTrue(webDriver.switchTo().alert().getText().contains("[Bird Name] Please select bird name from given list."));
        assertTrue(webDriver.switchTo().alert().getText().contains("[Number of birds] Please enter valid integer greater than zero."));
    }
}
