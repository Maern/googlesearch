import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSecondSearchPage extends GoogleBasePage {

    @FindBy(xpath = "//div[@class='g']")
    private List <WebElement> searchResults;

    public GoogleSecondSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return webDriver.getCurrentUrl().contains("start=10");
    }

    public int getSearchResultsNumber() {
        return searchResults.size();
    }

    public List <String> getSearchResults() {
        List <String> responseResultsList = new ArrayList <String>();
        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", searchResult);
            responseResultsList.add(searchResult.getText());
        }
        return responseResultsList;
    }
}
