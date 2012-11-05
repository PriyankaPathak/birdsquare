import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.Assert.assertTrue;

public class HomePageTest {

    private FirefoxDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.get("localhost:8080");
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
