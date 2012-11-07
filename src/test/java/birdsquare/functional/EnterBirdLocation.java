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

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class EnterBirdLocation {

    private WebDriver webDriver;
    private static String HOME_PAGE_URL = "http://qa.birdsquare.in/birdsquare";

    private String getFirefoxProfile() {
        String workingDir = System.getProperty("user.dir");
        return workingDir + "/src/test/java/birdsquare/functional/firefox/profile";
    }

    @Before
    public void BeforeMethod()
    {
        File profileDir = new File(getFirefoxProfile());
        FirefoxProfile profile = new FirefoxProfile(profileDir);
        webDriver = new FirefoxDriver(profile);
        webDriver.get(HOME_PAGE_URL);
    }
    @Test
    public void SelectBirdLocationFromList()
    {
        webDriver.findElement(By.linkText("Check In")).click();


        WebElement myDynamicElement = (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<WebElement>()
        {
              @Override
              public WebElement apply(WebDriver d)
              {
                   return d.findElement(By.xpath("//div[@ id='location-container']/form"));
              }
        });

        String number = "10";
        String birdName = "MyBird" ;
        String comment ="This is a very beautiful bird";

        webDriver.findElement(By.xpath("//div[@ id='location-container']/form/a")).click();

        webDriver.findElement(By.xpath("//input[@name='birdName']")).sendKeys(birdName);
        webDriver.findElement(By.xpath("//input[@name='number']")).sendKeys(number);
        webDriver.findElement(By.xpath("//textarea[@class='CommentBox']")).sendKeys(comment);
        webDriver.findElement(By.xpath("//input[@id='submitbutton']")).click();
        assertTrue(webDriver.findElement(By.xpath("//div[@id='main-content']")).isDisplayed());
        //assertTrue(webDriver.findElement(By.name("You have checked in 10 Bird(s) successfully!")).isDisplayed());

        String AssertConfirmationMessage ="You have checked in " + number + " "+ birdName + "(s) successfully!";

        String ActualMessage = webDriver.findElement(By.xpath("//div[@id='main-content']")).getText();

        assertEquals(AssertConfirmationMessage, ActualMessage );

        //assertTrue(webDriver.findElement(By));



    }

   /* @Test
    public void EnterBirdNameAndNumberOfBirds()
    {

        webDriver.findElement(By.xpath("//input[@name='birdName']")).sendKeys("Bird");
        webDriver.findElement(By.xpath("//input[@name='number']")).sendKeys("10");
        webDriver.findElement(By.xpath("//textarea[@class='CommentBox']")).sendKeys("This is a very beautiful bird");
        webDriver.findElement(By.xpath("//input[@id='submitbutton']")).click();
        assertTrue(webDriver.findElement(By.xpath("//div[@id='main-content']")).isDisplayed());


    }*/
}