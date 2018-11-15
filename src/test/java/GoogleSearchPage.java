import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage extends GoogleBasePage {
    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement navigateToPage2;

    @FindBy(xpath = "//div[@class='g']")
    private List <WebElement> searchResults;

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement searchResultsFound;

    public GoogleSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return searchResultsFound.isDisplayed()&& webDriver.getCurrentUrl().contains("/search");
    }
public int getSearchResultsNumber(){
        return searchResults.size();
}

    public List <String> getSearchResults() {
        List <String> responseResultsList = new ArrayList<String>();
        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();",searchResult);
            responseResultsList.add(searchResult.getText());
        }
        return responseResultsList;
    }

    public GoogleSecondSearchPage navigateToSecondPage() {
        navigateToPage2.click();
        return new GoogleSecondSearchPage(webDriver);
    }
}
