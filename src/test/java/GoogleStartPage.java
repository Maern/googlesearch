import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleStartPage extends GoogleBasePage {


    @FindBy(xpath="//*[@name='q']")
    private WebElement googleSearchBox;

    /**
     * Constructor for GoogleStartPage PageObject
     * @param webDriver - WebDriver instance from test
     */
    public GoogleStartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to check if page is loaded
     * @return true or false value of check
     */
    public boolean isPageLoaded(){
        return waitUntilUrlContains("google.com")&& googleSearchBox.isDisplayed();
    }

    /**
     * Method to perform search on Google page
     * @param searchTerm - String with search term required for test
     * @return new GoogleSearchPage PageObject
     */
    public GoogleSearchPage search(String searchTerm){
        waitUntilElementIsClickable(googleSearchBox);
        googleSearchBox.sendKeys(searchTerm);
        googleSearchBox.sendKeys(Keys.RETURN);
        return new GoogleSearchPage(webDriver);

    }

}
