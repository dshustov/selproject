package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seltest.herukoapp.pages.DynamicControls;
import seltest.herukoapp.webdriver.BaseHerukoTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicControlsTest extends BaseHerukoTest {

    DynamicControls dynamicControls;
    WebDriverWait wait;

    /**
     * Testing link and header to the page
     */
    @BeforeEach
    public void goToPage(){
        mainPage.mainPageStart();
        mainPage.goToLesson("Dynamic Controls");

        dynamicControls = new DynamicControls(driver);

        String header = dynamicControls.getHeaderText();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        assertEquals("Dynamic Controls", header,
                "Wrong page header.");
    }

    /**
     * Check logic of delete add checkbox, which appears in different places
     */
    @Test
    public void checkAddRemoveButton() {
        WebElement checkbox = dynamicControls.getCheckbox();
        WebElement addRemoveButton = dynamicControls.getAddRemoveButton();

        assertEquals("checkbox", checkbox.getDomAttribute("type"),
                "Input tag has wrong type.");

        assertEquals("A checkbox", dynamicControls.getCheckboxText(),
                "Wrong text on the checkbox");

        assertEquals("Remove", addRemoveButton.getText(),
                "Wrong button text.");

        addRemoveButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(addRemoveButton));

        try{
            dynamicControls.getCheckbox().isSelected();
            fail("Checkbox still present ");
        }
        catch(NoSuchElementException e){
            // Do nothing
        }

        assertEquals("Add", addRemoveButton.getText(),
                "Wrong button text.");

        dynamicControls.getAddRemoveButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(addRemoveButton));

        checkbox.click();

        assertEquals("Remove", addRemoveButton.getText(),
                "Wrong button text.");
        assertEquals("A checkbox", dynamicControls.getCheckboxText(),
                "Wrong text on the checkbox");
    }

    @Test
    public void checkEnableDisableButton(){
        WebElement eDButton = dynamicControls.getEnableDisableButton();
        WebElement textBox = dynamicControls.getTextBox();

        assertFalse(textBox.isEnabled(),
                "Text box is enabled.");

        eDButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(eDButton));

        assertTrue(textBox.isEnabled(),
                "Text box is disabled.");
    }

}
