package birdsquare.functional.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    protected WebDriver webDriver;
    private WebDriverWait wait;

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 30);
        waitForThePageToLoad();
        PageFactory.initElements(webDriver, this);
    }

    public abstract void waitForThePageToLoad();

    protected void waitForElementToLoad(final By by) {
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return webDriver.findElement(by) != null;
            }
        });
    }

    protected void switchToNextWindow() {
        waitUntilWindowsOpenUp(2);
        webDriver.switchTo().window((String) webDriver.getWindowHandles().toArray()[1]);
    }

    protected void switchBackToMainWindow() {
        waitUntilWindowsOpenUp(1);
        webDriver.switchTo().window((String) webDriver.getWindowHandles().toArray()[0]);
    }

    private void waitUntilWindowsOpenUp(final int numberOfWindows) {
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return webDriver.getWindowHandles().size() == numberOfWindows;
            }
        });
    }
}