package birdsquare.functional;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import static birdsquare.functional.Framework.*;

import java.io.File;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;


public class CheckIn_SelectLocation_Test {


    private String getFirefoxProfile() {
        String workingDir = System.getProperty("user.dir");
        return workingDir + "/src/test/java/birdsquare/functional/firefox/profile";
    }

    @Before
    public void BeforeMethod()
    {
        // cannot use FireFoxDriver in Go yet
        if (runningInGo()) return;

        File profileDir = new File(getFirefoxProfile());
        FirefoxProfile profile = new FirefoxProfile(profileDir);
        webDriver = new FirefoxDriver(profile);
        webDriver.get(HOME_PAGE_URL);
    }

    @Test
    public void SelectBirdLocationFromList()
    {
        // cannot use FireFoxDriver in Go yet
        if (runningInGo()) return;
        webDriver.findElement(By.linkText("Sighting")).click();


        WebElement myDynamicElement = (new WebDriverWait(webDriver, 50)).until(new ExpectedCondition<WebElement>()
        {

              @Override
              public WebElement apply(WebDriver d)
              {
                   return d.findElement(By.xpath("//ul[@id='location-container']/li/div/div/a"));
              }
        });

        webDriver.findElement(By.xpath("//ul[@id='location-container']/li/div/div/a")).click();

        String number = "10";
        String birdName = "MyBird" ;
        String comment ="This is a very beautiful bird";


        webDriver.findElement(By.id("birdname-field")).sendKeys(birdName);
        webDriver.findElement(By.id("numberofbirds-field")).sendKeys(number);
        webDriver.findElement(By.id("comments")).sendKeys(comment);


        webDriver.findElement(By.xpath("//input[@type='submit']")).click();

       // assertTrue(webDriver.findElement(By.xpath("//div[@id='main-content']")).isDisplayed());

        //String AssertConfirmationMessage ="You have checked in " + number + " "+ birdName + "(s) successfully!";

        //String ActualMessage = CommonVariables.webDriver.findElement(By.xpath("//div[@id='main-content']")).getText();

       // assertEquals(AssertConfirmationMessage, ActualMessage );
    }



}