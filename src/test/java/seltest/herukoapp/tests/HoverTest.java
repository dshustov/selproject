package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoverTest extends InitiateSeleniumTest{
    Actions action;

    By hoverPageHeader = By.xpath("//*[@id=\"content\"]/div/h3");
    By firstPicturePath = By.xpath("//*[@id=\"content\"]/div/div[1]/img");
    By firstLinkPath = By.xpath("//*[@id=\"content\"]/div/div[1]/div/a");


    @BeforeEach
    public void goToPage() throws AWTException {
        /**
         * Testing link and header to the page
         */
        mainPage.mainPageStart();
        action = new Actions(driver);
    }

    @Test
    public void checkHover() throws InterruptedException {
        /**
         * Simple hover test
         */
        mainPage.goToLesson("Hovers");
        String header = driver.findElement(hoverPageHeader).getText();
        assertEquals("Hovers", header,
                "Wrong page header.");
        WebElement firstPicture = driver.findElement(firstPicturePath);
        action.moveToElement(firstPicture).perform();

        driver.findElement(firstLinkPath).click();
    }
}
