package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testng.annotations.BeforeTest;
import seltest.herukoapp.pages.AddRemoveElements;
import seltest.herukoapp.pages.Checkboxes;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CheckboxesTest extends InitiateSeleniumTest{

    Checkboxes checkboxesPage;

    @BeforeEach
    public void goToPage(){
        /**
         * Testing link and header to the page
         */
        mainPage.mainPageStart();
        mainPage.goToLesson("Checkboxes");

        checkboxesPage = new Checkboxes(driver);

        String header = checkboxesPage.getHeaderText();

        assertEquals("Checkboxes", header);
    }

    @Test
    public void checkboxesLogic(){
        /**
         * Simple test to check checkboxes
         */
        assertFalse(checkboxesPage.isCheckbox1On(),
                "Checkbox state is wrong.");
        assertTrue(checkboxesPage.isCheckbox2On(),
                "Checkbox state is wrong.");

        checkboxesPage.checkBox1Click();
        checkboxesPage.checkBox2Click();

        assertTrue(checkboxesPage.isCheckbox1On(),
                "Checkbox state is wrong.");
        assertFalse(checkboxesPage.isCheckbox2On(),
                "Checkbox state is wrong.");
    }
}
