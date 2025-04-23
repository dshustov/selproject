package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import seltest.herukoapp.pages.Checkboxes;
import seltest.herukoapp.webdriver.BaseHerukoTest;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CheckboxesTest extends BaseHerukoTest {

    Checkboxes checkboxesPage;

    /**
     * Testing link and header to the page
     */
    @BeforeEach
    public void goToPage(){
        mainPage.mainPageStart();
        mainPage.goToLesson("Checkboxes");

        checkboxesPage = new Checkboxes(driver);

        String header = checkboxesPage.getHeaderText();

        assertEquals("Checkboxes", header);
    }

    /**
     * Simple test to check checkboxes
     */
    @Test
    public void checkboxesLogic(){
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
