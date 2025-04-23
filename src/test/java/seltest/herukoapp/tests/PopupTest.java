package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seltest.herukoapp.webdriver.BaseHerukoTest;

import java.awt.*;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PopupTest extends BaseHerukoTest {

    WebDriverWait wait;
 //   Actions action;
    Robot robot;
    By adPageHeader = By.xpath("//*[@id=\"content\"]/div[1]/h3");
    By adPageModalText = By.xpath("//*[@id=\"modal\"]/div[2]/div[2]/p");
    By adPageCloseButton = By.xpath("//*[@id=\"modal\"]/div[2]/div[3]/p");
    By adPageModalWindow = By.xpath("//*[@id=\"modal\"]");

    By intentPageHeader = By.xpath("//*[@id=\"content\"]/div[1]/h3");
    By intentPageCloseButton = By.xpath("//*[@id=\"ouibounce-modal\"]/div[2]/div[3]/p");
    By intentPageModalWindow = By.xpath("//*[@id=\"ouibounce-modal\"]");

    /**
     * Testing link and header to the page
     */
    @BeforeEach
    public void goToPage() throws AWTException {
        mainPage.mainPageStart();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
  //      action = new Actions(driver);
        robot = new Robot();
    }

    /**
     * Check dealing with popup window on page opening
     */
    @Test
    public void checkEntryAd() {
        mainPage.goToLesson("Entry Ad");
        String header = driver.findElement(adPageHeader).getText();
        assertEquals("Entry Ad", header,
                "Wrong page header.");

        WebElement modalWindow = driver.findElement(adPageModalWindow);
        WebElement closeButton = driver.findElement(adPageCloseButton);

        wait.until(ExpectedConditions.domAttributeToBe(modalWindow,"style",
                "display: block;"));
        wait.until(ExpectedConditions.elementToBeClickable(closeButton));

        String modalWindowText = driver.findElement(adPageModalText).getText();
        String expectedText = "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker).";
        assertEquals(expectedText,modalWindowText,
                "Text in modal window is wrong");

        closeButton.click();

        assertEquals("display: none;",modalWindow.getDomAttribute("style"),
                "Modal window was not closed");
    }

    /**
     * Test for plzing around with exit intent page and modal window
     */
    @Test
    public void checkExitIntent() throws InterruptedException {
        mainPage.goToLesson("Exit Intent");
        String header = driver.findElement(intentPageHeader).getText();
        assertEquals("Exit Intent", header,
                "Wrong page header.");

        WebElement modalWindow = driver.findElement(intentPageModalWindow);

        assertEquals("display:none;",modalWindow.getDomAttribute("style"),
                "Initially modal window was not closed");

        //   action.moveToElement(driver.findElement(intentPageHeader)).perform();

        robot.mouseMove(0,0);
        WebElement closeButton = driver.findElement(intentPageCloseButton);

        wait.until(ExpectedConditions.elementToBeClickable(closeButton));

        assertEquals("display: block;",modalWindow.getDomAttribute("style"),
                "Modal window was not opened");

        Thread.sleep(500);
        closeButton.click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(intentPageModalWindow));

        assertEquals("display: none;",modalWindow.getDomAttribute("style"),
                "Modal window was not closed");

    }
}
