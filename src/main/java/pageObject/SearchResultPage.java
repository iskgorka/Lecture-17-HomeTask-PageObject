package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends BasePage {
    private By searchInput = new By.ByXPath("//input[@class=\"gLFyf gsfi\"]");

    @FindBy(xpath = "//h3[@class=\"LC20lb MBeuO DKV0Md\"]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchRozetka;

    @FindBy(xpath = "//div[@class=\"goods-tile__inner\"]")
    private List<WebElement> iphoneResults;

    @FindBy(xpath = "//button[@class=\"buy-button button button--with-icon button--green button--medium ng-star-inserted\"]")
    private WebElement buyButton;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SearchResultPage openGoogle() {
        driver.get("https://www.google.com.ua/");
        return this;
    }

    public SearchResultPage search(String searchString) {
        WebElement searchInputElement = driver.findElement(searchInput);
        searchInputElement.clear();
        searchInputElement.sendKeys(searchString);
        driver.findElement(searchInput).submit();
        return new SearchResultPage(driver);
    }

    public SearchResultPage clickSearchResultByIndex(int index) {
        String result = searchResults.get(index).getText();
        searchResults.get(index).click();
        System.out.println(result);
        return new SearchResultPage(driver);
    }

    public SearchResultPage searchIphone13(){
        softAssert.assertTrue(searchRozetka.isDisplayed());
        softAssert.assertAll();
        searchRozetka.sendKeys("iphone 13 pro max 256");
        searchRozetka.sendKeys(Keys.ENTER);
        return this;
    }

    public SearchResultPage clickOnIphone13(){
        softAssert.assertTrue(iphoneResults.get(0).isDisplayed());
        softAssert.assertAll();
        iphoneResults.get(0).click();
        return this;
    }

    public SearchResultPage checkOnBuyButton(){
        softAssert.assertTrue(buyButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }
}
