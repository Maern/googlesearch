import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleSearchPage extends GoogleBasePage {
    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement navigateToPage2;

    /**
     * Constructor for GoogleSearchPage PageObject
     * @param webDriver - WebDriver instance from test
     */
    public GoogleSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to check if Page is loaded
     * @return true or false value of UrlContains check with wait for 5 secs
     */
    public boolean isPageLoaded() {
        return waitUntilUrlContains("/search?");
    }

    /**
     * Override method of BasePage method getSearchResultsNumber, used to implement waitUntilElementVisible
     * @return method from GoogleBasePage
     */
    @Override
    public int getSearchResultsNumber(){
        waitUntilElementVisible(navigateToPage2);
                return super.getSearchResultsNumber();
    }

    /**
     * Simple method to navigate to another page
     * @return new GoogleSecondSearchPage PageObject
     */
    public GoogleSecondSearchPage navigateToSecondPage() {
        navigateToPage2.click();
        return new GoogleSecondSearchPage(webDriver);
    }
}
