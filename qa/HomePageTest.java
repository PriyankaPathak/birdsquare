import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static junit.framework.Assert.assertTrue;

public class HomePageTest {

    private WebDriver webDriver;
    private static String HOME_PAGE_URL = "http://localhost:8080";

    @Before
    public void setUp() {
        webDriver = new HtmlUnitDriver();
        webDriver.get(HOME_PAGE_URL);
    }

    @Test
    public void shouldShowHomePage() {
        WebElement mainContentElement = webDriver.findElement(By.id("main-content"));
        assertTrue(mainContentElement.getText().contains("Welcome to BirdSquare"));
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
