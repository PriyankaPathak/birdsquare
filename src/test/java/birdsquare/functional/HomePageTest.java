package birdsquare.functional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static birdsquare.functional.Framework.*;

import static org.junit.Assert.assertTrue;

public class HomePageTest {


    @Before
    public void setUp() {
        if (runningInGo()) return;
        webDriver = new FirefoxDriver();
        webDriver.get(HOME_PAGE_URL);
    }

    @Ignore
    @Test
    public void shouldShowHomePage() {
        if (runningInGo()) return;

        WebElement mainContentElement = webDriver.findElement(By.id("home-content"));
        assertTrue(mainContentElement.getText().contains("Welcome to BirdSquare"));
        assertTrue(webDriver.findElement(By.xpath("//span[@class='ui-btn-inner ui-btn-corner-all']")).isDisplayed());
    }

}
