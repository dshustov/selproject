package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seltest.herukoapp.pages.ChallengeDOM;
import seltest.herukoapp.pages.DisappearingElements;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisappearingElementsTest extends InitiateSeleniumTest{

    DisappearingElements disappearingElementsPage;

    @BeforeEach
    public void goToPage(){
        /**
         * Silly test to check header
         */
        mainPage.mainPageStart();
        mainPage.goToLesson("Disappearing Elements");

        disappearingElementsPage = new DisappearingElements(driver);

        String header = disappearingElementsPage.getHeaderText();
        assertEquals("Disappearing Elements", header);
    }

    @Test
    public void checkHomeButton() {
        /**
         * Test Home Button action
         */
        disappearingElementsPage.clickHome();
        String header = mainPage.getHeaderText();
        assertEquals("Welcome to the-internet", header,
                "Wrong page header.");
    }

    @Test
    public void checkAboutButton() {
        /**
         * Test About Button action
         */
        disappearingElementsPage.clickAbout();
        WebElement error = driver.findElement(By.xpath("/html/body/h1"));
        assertEquals("Not Found",error.getText(),
                "Wrong error message.");
    }

    @Test
    public void checkContactUsButton() {
        /**
         * Test Contact Button action
         */
        disappearingElementsPage.clickContactUs();
        WebElement error = driver.findElement(By.xpath("/html/body/h1"));
        assertEquals("Not Found",error.getText(),
                "Wrong error message.");
    }

    @Test
    public void checkPortfolioButton() {
        /**
         * Test Portfolio Button action
         */
        disappearingElementsPage.clickPortfolio();
        WebElement error = driver.findElement(By.xpath("/html/body/h1"));
        assertEquals("Not Found",error.getText(),
                "Wrong error message.");
    }

    @RepeatedTest(10)
    public void checkGalleryButton() {
        /**
         * Test Gallery Button action 10 times
         * If button not present, just log message about it
         */
        if (disappearingElementsPage.isGalleryButtonPresent()) {
            disappearingElementsPage.clickGallery();
            WebElement error = driver.findElement(By.xpath("/html/body/h1"));
            assertEquals("Not Found", error.getText(),
                    "Wrong error message.");
        }
        else{
            System.out.println("Element is not present, skip");
        }
    }
}
