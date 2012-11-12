package birdsquare.functional;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import static birdsquare.functional.Framework.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class BirdNameValidationTest {


    @Before
    public void BeforeMethod()
    {
        CheckIn_SelectLocation_Test Object_EnterBirdLocation = new CheckIn_SelectLocation_Test();
        Object_EnterBirdLocation.BeforeMethod();

    }

    @Test
    public void BirdNameTest()
    {
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

        webDriver.findElement(By.id("birdname-field")).sendKeys("123");
        webDriver.findElement(By.xpath("//input[@type='submit']")).click();


    }


}
