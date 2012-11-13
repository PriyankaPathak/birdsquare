package birdsquare.functional;


import birdsquare.functional.framework.BaseTest;
import birdsquare.functional.framework.page.CheckinLocationPage;
import birdsquare.functional.framework.page.LoginPage;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class CheckInBirdTest extends BaseTest {

    @Test
    public void checkInABirdSuccessfully() {
        CheckinLocationPage checkinLocationPage = new LoginPage(webDriver).redirectToFBLogin().login().checkIn();

        String birdName = "Hill Partridge (Arborophila torqueola)";
        String numberOfBirds = "2";

        checkinLocationPage.selectLocation().submitForm(birdName, numberOfBirds);

        String expectedMessage = String.format("You have checked in %s %s(s) successfully", numberOfBirds, birdName);
        assertTrue(webDriver.switchTo().alert().getText().contains(expectedMessage));
    }
}