package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seltest.herukoapp.pages.ChallengeDOM;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ChallengeDOMTest extends InitiateSeleniumTest{

    ChallengeDOM challengeDOMPage;
    @BeforeAll
    public void goToPage(){
        /**
         * Silly test to check header
         */
        mainPage.mainPageStart();
        mainPage.goToLesson("Challenging DOM");

        challengeDOMPage = new ChallengeDOM(driver);

        String header = challengeDOMPage.getHeaderText();
        assertEquals("Challenging DOM", header);
    }

    @Test
    public void checkBlueButton() throws InterruptedException {
        /**
         * Test clicks on Blue button and checks, that button text changed
         */

        String originalButtonText;
        Thread.sleep(500);
        WebElement blueButton = challengeDOMPage.getBlueButton();
        originalButtonText = blueButton.getText();
        blueButton.click();
        Thread.sleep(1000);
        blueButton = challengeDOMPage.getBlueButton();
        assertNotEquals(originalButtonText, blueButton.getText(),
                "Text on Blue Button not changed.");

    }

    @Test
    public void checkRedButton() throws InterruptedException {
        /**
         * Test clicks on Red button and checks, that ID for button changed
         */
        String originalButtonId;

        Thread.sleep(500);
        WebElement redButton = challengeDOMPage.getRedButton();
        originalButtonId = redButton.getDomAttribute("id");
        redButton.click();
        Thread.sleep(1000);
        redButton = challengeDOMPage.getRedButton();
        assertNotEquals(originalButtonId,redButton.getDomAttribute("id"),
                "Text on Red Button not changed.");
    }

    @Test
    public void checkGreenButton() throws InterruptedException {
        /**
         * Test clicks on Green button and checks, that button text changed
         */
        String originalButtonText;

        Thread.sleep(500);
        WebElement greenButton = challengeDOMPage.getGreenButton();
        originalButtonText = greenButton.getText();
        greenButton.click();
        Thread.sleep(1000);
        greenButton = challengeDOMPage.getGreenButton();
        assertNotEquals(originalButtonText,greenButton.getText(),
                "Text on Green Button not changed.");
    }

    @Test
    public void checkTableHeader(){
        /**
         * Verify table headers
         */
        List<String> headerNames = Arrays.asList("Lorem","Ipsum","Dolor","Sit","Amet","Diceret","Action");

        List<WebElement> headers = challengeDOMPage.getTableHeaders();
        assertEquals(headerNames.size(),headers.size(),
                "Unexpected amount of table headers");

        for (WebElement header:headers) {
            assertTrue(headerNames.contains(header.getText()),
                    "Header name is not present.");
        }
    }

    @Test
    public void checkLastRow(){
        /**
         * Verify last table row
         */
        List<String> cellValues = Arrays.asList("Iuvaret9","Apeirian9","Adipisci9","Definiebas9","Consequuntur9","Phaedrum9");
        List<WebElement> cells = challengeDOMPage.getLastTableRowElements();

        for (int i=0; i<(cells.size()-1); i++){
            assertTrue(cellValues.contains(cells.get(i).getText()),
                    "Cell value is not presnt.");
        }

        WebElement editlink = cells.get(cells.size()-1).findElement(By.linkText("edit"));
        editlink.click();

        WebElement deletelink = cells.get(cells.size()-1).findElement(By.linkText("delete"));
        deletelink.click();
    }

    @Test
    public void checkCanvasUpdate(){
        /**
         * Verify that answer changes on refresh
         */
        String currentAnswer = challengeDOMPage.getAnswerValue();
        driver.navigate().refresh();

        String newAnswer = challengeDOMPage.getAnswerValue();
        assertNotEquals(currentAnswer,newAnswer,
                "Answer not changed after refresh.");
    }


}
