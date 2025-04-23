package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seltest.herukoapp.pages.DisappearingElements;
import seltest.herukoapp.webdriver.BaseHerukoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisappearingElementsTest extends BaseHerukoTest {

    DisappearingElements disappearingElementsPage;

    /**
     * Silly test to check header
     */
    @BeforeEach
    public void goToPage(){
        mainPage.mainPageStart();
        mainPage.goToLesson("Disappearing Elements");

        disappearingElementsPage = new DisappearingElements(driver);

        String header = disappearingElementsPage.getHeaderText();
        assertEquals("Disappearing Elements", header);
    }

    /**
     * Test Home Button action
     */
    @Test
    public void checkHomeButton() {
        disappearingElementsPage.clickHome();
        String header = mainPage.getHeaderText();
        assertEquals("Welcome to the-internet", header,
                "Wrong page header.");
    }

    /**
     * Test About Button action
     */
    @Test
    public void checkAboutButton() {
        disappearingElementsPage.clickAbout();
        WebElement error = driver.findElement(By.xpath("/html/body/h1"));
        assertEquals("Not Found",error.getText(),
                "Wrong error message.");
    }

    /**
     * Test Contact Button action
     */
    @Test
    public void checkContactUsButton() {
        disappearingElementsPage.clickContactUs();
        WebElement error = driver.findElement(By.xpath("/html/body/h1"));
        assertEquals("Not Found",error.getText(),
                "Wrong error message.");
    }

    /**
     * Test Portfolio Button action
     */
    @Test
    public void checkPortfolioButton() {
        disappearingElementsPage.clickPortfolio();
        WebElement error = driver.findElement(By.xpath("/html/body/h1"));
        assertEquals("Not Found",error.getText(),
                "Wrong error message.");
    }

    /**
     * Test Gallery Button action 10 times
     * If button not present, just log message about it
     */
    @RepeatedTest(10)
    public void checkGalleryButton() {
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
