import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleStartPage extends GoogleBasePage {


    @FindBy(xpath="//*[@id='lst-ib']")
    private WebElement googleSearchBox;

    @FindBy(xpath="//input[@name='btnK']")
    private WebElement searchButton;

    public GoogleStartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded(){
        return  googleSearchBox.isDisplayed() && webDriver.getCurrentUrl().contains("google.com");
    }
    public GoogleSearchPage search(String searchTerm){
        googleSearchBox.sendKeys(searchTerm);
        waitUntilElementIsClickable(searchButton);
        searchButton.click();
        return new GoogleSearchPage(webDriver);

    }
}
