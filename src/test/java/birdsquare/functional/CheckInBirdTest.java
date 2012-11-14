package birdsquare.functional;


import birdsquare.functional.framework.BaseTest;
import birdsquare.functional.framework.TestData;
import birdsquare.functional.framework.page.CheckinFormPage;
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

    @Test
    public void checkInAnInvalidBird() {
        CheckinLocationPage checkinLocationPage = new LoginPage(webDriver).redirectToFBLogin().login().checkIn();
        checkinLocationPage.selectLocation().submitForm("123", "0");

        assertTrue(webDriver.switchTo().alert().getText().contains("[Bird Name] Please select bird name from given list."));
        assertTrue(webDriver.switchTo().alert().getText().contains("[Number of birds] Please enter valid integer greater than zero."));
    }

    @Test
    public void checkInAnInvalidBirdNumber() {
        CheckinFormPage checkinFormPage= new LoginPage(webDriver).redirectToFBLogin().login().checkIn().selectLocation();
        checkinFormPage.submitForm(TestData.VALID_BIRD_NAME, "-1");

        assertTrue(webDriver.switchTo().alert().getText().contains("[Number of birds] Please enter valid integer greater than zero."));
    }

}