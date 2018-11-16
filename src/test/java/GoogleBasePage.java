import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public abstract class GoogleBasePage {
    WebDriver webDriver;

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    protected List <WebElement> searchResults;

    /**
     * Method to get size of web elements List
     *
     * @return - size of the List
     */
    public int getSearchResultsNumber() {
        return searchResults.size();
    }

    /**
     * Method to create ArrayList which would contain text from searchResults List
     *
     * @return - ArrayList with stored strings
     */
    public List <String> getSearchResults() {
        List <String> responseResultsList = new ArrayList <>();
        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", searchResult);
            responseResultsList.add(searchResult.getText());
        }
        return responseResultsList;
    }

    public abstract boolean isPageLoaded();

    /**
     * Method to implement wait until element is clickable
     *
     * @param webElement - webElement which should be checked by this method
     */
    protected void waitUntilElementIsClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Method to implement wait until page URL contains partialUrl
     * @param partialUrl - String with text value which is used to check in URL
     * @return - wait until URL contains partialUrl string
     */
    protected boolean waitUntilUrlContains(String partialUrl) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        try {
            return wait.until(ExpectedConditions.urlContains(partialUrl));
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Method to implement wait until webElement is visible
     * @param webElement - webElement from the page which should be checked
     * @return - wait until webElement is Visible
     */
    protected WebElement waitUntilElementVisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        return wait.until(ExpectedConditions.visibilityOf(webElement));

    }


}
