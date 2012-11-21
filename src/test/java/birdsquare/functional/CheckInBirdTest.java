package birdsquare.functional;


import birdsquare.functional.framework.BaseTest;
import birdsquare.functional.framework.TestData;
import birdsquare.functional.framework.page.CheckinFormPage;
import birdsquare.functional.framework.page.CheckinLocationPage;
import birdsquare.functional.framework.page.HomePage;
import birdsquare.functional.framework.page.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.Assert.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CheckInBirdTest extends BaseTest {

    @Test
    public void checkInABirdSuccessfullyWithoutCommentsAndIncrementUserPointsByOne() {

        String numberOfBirds = "2";
        String comments = "";

        HomePage homePage = new LoginPage(webDriver).redirectToFBLogin().login();
        int prevUserPoints = homePage.getCurrentUserPoints();
        CheckinLocationPage checkinLocationPage = homePage.checkIn();
        String location = checkinLocationPage.getFirstLocationId();
        CheckinFormPage checkinFormPage = checkinLocationPage.selectLocation();

        checkinFormPage.submitForm(TestData.VALID_BIRD_NAME, numberOfBirds, comments);

        System.out.println(location);

        String expectedMessage = String.format("You have checked in %s %s(s) successfully in %s.", numberOfBirds, TestData.VALID_BIRD_NAME,location);

        Alert alertBox = webDriver.switchTo().alert();
        assertTrue(alertBox.getText().contains(expectedMessage));
        alertBox.accept();

        Assert.assertTrue(homePage.isLogoutButtonVisible());
        Assert.assertThat(homePage.getCurrentUserPoints(), is(prevUserPoints+1));

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

    @Test
    public void checkThatWeCanCountBirdList() {
        CheckinFormPage checkinFormPage= new LoginPage(webDriver).redirectToFBLogin().login().checkIn().selectLocation();

        assertAutoCompleteResultCount(checkinFormPage, "malab", 12);
        assertAutoCompleteResultCount(checkinFormPage, "hornbill", 10);
    }

    private void assertAutoCompleteResultCount(CheckinFormPage checkinFormPage, String partialBirdNameText, int expectedNumber) {
        List<WebElement> autoCompleteList = checkinFormPage.getBirdAutocompleteListFor(partialBirdNameText);
        assertThat(autoCompleteList.size(), is(expectedNumber));
        checkinFormPage.resetBirdNameField();
    }


}

