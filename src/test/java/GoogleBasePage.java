import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class GoogleBasePage {
    WebDriver webDriver;

    public abstract boolean isPageLoaded();

    public boolean waitUntilElementIsClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);

        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return false;
    }

    protected boolean isUrlContains(String partialUrl) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        try {
            return wait.until(ExpectedConditions.urlContains(partialUrl));
        } catch (TimeoutException e) {
            return false;
        }
    }



}
