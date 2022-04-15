package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.SearchResultPage;

public class OpenRozetka {

    @Test
    public void openRozetkaTest(){
        String searchString = "rozetka ua";
        WebDriverManager.chromedriver().setup();
        new SearchResultPage(new ChromeDriver())
                .openGoogle()
                .search(searchString)
                .clickSearchResultByIndex(0);
    }

    @AfterTest
    public void closeBrowser() {
        BasePage.setDown();
    }
}
