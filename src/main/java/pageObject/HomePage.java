package pageObject;

import com.sun.security.auth.SolarisNumericUserPrincipal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"menu-categories__link\"]")
    private List<WebElement> mainCategories;

    @FindBy(xpath = "//div[@class=\"tile-cats\"]")
    private List<WebElement> popularCategories;

    @FindBy(xpath = "//div[@class=\"tile-cats\"]")
    private List<WebElement> gamingDevices;

    @FindBy(xpath = "//select[@class=\"select-css ng-untouched ng-pristine ng-valid ng-star-inserted\"]")
    private WebElement selectElement;

    private final static Color LABEL_ONLY_IN_ROZETKA = Color.fromString("rgb(216, 55, 152)");

    @FindBy(xpath = "//div[@class=\"goods-tile__inner\"]")
    private List<WebElement> chairs;

    @FindBy(xpath = "//button[@class=\"buy-button button button--with-icon button--green button--medium ng-star-inserted\"]")
    private WebElement buyButton;

    @FindBy(xpath = "//h1[@class=\"product__title\"]")
    private WebElement productTitle;

    public HomePage openRozetka() {
        driver.get("https://rozetka.com.ua/");
        return this;
    }

    public HomePage clickCategory(){
        softAssert.assertTrue(mainCategories.get(2).isDisplayed());
        softAssert.assertEquals(mainCategories.get(2).getText(),"Товары для геймеров");
        softAssert.assertAll();
        mainCategories.get(2).click();
        return this;
    }

    public HomePage clickOnGamingDevices() {
        softAssert.assertTrue(popularCategories.get(10).isDisplayed());
        softAssert.assertEquals(popularCategories.get(10).getText(), "Игровая периферия");
        softAssert.assertAll();
        popularCategories.get(10).click();
        return this;
    }

    public HomePage clickOnGamingChairs() {
        try {
            gamingDevices.get(5).click();
            return this;
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            softAssert.assertTrue(gamingDevices.get(5).isDisplayed());
            softAssert.assertAll();
            gamingDevices.get(5).click();
            return this;
        }
    }

    public HomePage selectPopularChairs() {
        try {
            Select selectObject = new Select(selectElement);
            selectObject.selectByIndex(3);
            return this;
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex){
            softAssert.assertTrue(selectElement.isDisplayed());
            softAssert.assertAll();
            Select selectObject = new Select(selectElement);
            selectObject.selectByIndex(3);
            return this;
        }
    }

    public HomePage checkOnlyInRozetkaChairColor(){
        Color labelOnlyInRozetka = Color
                .fromString(driver.findElement(By.xpath("//span[@class='goods-tile__label promo-label promo-label_type_exclusive ng-star-inserted']"))
                        .getCssValue("background-color"));
        System.out.println(labelOnlyInRozetka.equals(LABEL_ONLY_IN_ROZETKA));
        return this;
    }

    public HomePage clickOnHatorChair(){
        softAssert.assertTrue(chairs.get(1).isDisplayed());
        softAssert.assertAll();
        chairs.get(1).click();
        return this;
    }

    public HomePage clickOnBuyButton(){
        softAssert.assertTrue(buyButton.isDisplayed());
        softAssert.assertAll();
        buyButton.click();
        return this;
    }

    public HomePage getProductTitle(){
        softAssert.assertTrue(productTitle.isDisplayed());
        softAssert.assertAll();
        System.out.println(productTitle.getText());
        return this;
    }
}
