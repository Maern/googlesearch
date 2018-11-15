import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleSearchTest {
    /**
     * Task:
     * - navigate to goolge.com
     * - enter Selenium SearchTerm
     * - Click on Search button
     * - Check that number of search results 10 on page 1
     * - Check that all results contain SearchTerm
     * - Go to Page 2
     * - Check that search results number = 10
     * - Check that all results contain searchTerm
     * - Add JavaDocs for all methods
     * - Add readme.md with detailed description
     * - Add gitignore
     * - Push to the GitHub
     */
    private WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://google.com");

    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }


    @Test
    public void googleSearchTest(){
        String searchTerm = "Selenium";

        GoogleStartPage googleStartPage = new GoogleStartPage(webDriver);

        Assert.assertTrue(googleStartPage.isPageLoaded(),"Google page is not loaded");

        GoogleSearchPage googleSearchPage = googleStartPage.search(searchTerm);

        Assert.assertTrue(googleSearchPage.isPageLoaded(),"Page with search results is not loaded");

        Assert.assertEquals(googleSearchPage.getSearchResultsNumber(),10,"Results number doesn't match expected value");

        List<String> searchResultsList = googleSearchPage.getSearchResults();

            for(String searchResult : searchResultsList){
                Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),"SearchTerm"+searchTerm+
                        "not found in"+searchResult);
            }
        GoogleSecondSearchPage googleSecondSearchPage = googleSearchPage.navigateToSecondPage();

    }
}
