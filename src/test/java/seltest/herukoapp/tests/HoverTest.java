package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import seltest.herukoapp.webdriver.BaseHerukoTest;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoverTest extends BaseHerukoTest {
    Actions action;

    By hoverPageHeader = By.xpath("//*[@id=\"content\"]/div/h3");
    By firstPicturePath = By.xpath("//*[@id=\"content\"]/div/div[1]/img");
    By firstLinkPath = By.xpath("//*[@id=\"content\"]/div/div[1]/div/a");

    /**
     * Testing link and header to the page
     */
    @BeforeEach
    public void goToPage() throws AWTException {
        mainPage.mainPageStart();
        action = new Actions(driver);
    }

    /**
     * Simple hover test
     */
    @Test
    public void checkHover() {
        mainPage.goToLesson("Hovers");
        String header = driver.findElement(hoverPageHeader).getText();
        assertEquals("Hovers", header,
                "Wrong page header.");
        WebElement firstPicture = driver.findElement(firstPicturePath);
        action.moveToElement(firstPicture).perform();

        driver.findElement(firstLinkPath).click();
    }
}
