import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class GoogleSecondSearchPage extends GoogleBasePage {

    /**
     * Constructor for GoogleSecondSearchPage PageObject
     * @param webDriver - new WebDriver from tests
     */
    public GoogleSecondSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to check if Page is loaded
     * @return true/false value of check if URL contains required string
     */
    public boolean isPageLoaded() {
        return waitUntilUrlContains("start=10");
    }

}
