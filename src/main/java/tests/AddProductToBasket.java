package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.HomePage;

public class AddProductToBasket {

    @Test
    public void addProductToBasketTest() {
        WebDriverManager.chromedriver().setup();
        new HomePage(new ChromeDriver())
                .openRozetka()
                .clickCategory()
                .clickOnGamingDevices()
                .clickOnGamingChairs()
                .selectPopularChairs()
                .checkOnlyInRozetkaChairColor()
                .clickOnHatorChair()
                .clickOnBuyButton()
                .getProductTitle()
                .makeScreenshot();
    }

    @AfterTest
    public void closeBrowser() {BasePage.setDown();}
}
