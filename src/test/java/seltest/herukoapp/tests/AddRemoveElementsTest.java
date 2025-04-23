package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.WebElement;
import seltest.herukoapp.pages.AddRemoveElements;
import seltest.herukoapp.webdriver.BaseHerukoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddRemoveElementsTest extends BaseHerukoTest {

    AddRemoveElements addRemoveElementsPage;

    /**
     * Testing link and header to the page
     */
    @BeforeEach
    public void goToPage(){
        mainPage.mainPageStart();
        mainPage.goToLesson("Add/Remove Elements");

        addRemoveElementsPage = new AddRemoveElements(driver);

        String header = addRemoveElementsPage.getHeaderText();

        assertEquals("Add/Remove Elements", header);
    }

    /**
     * check added button attributes
     */
    @Test
    public void checkAddedButton() {
        WebElement button = addRemoveElementsPage.addButton();
        assertEquals("addElement()",button.getDomAttribute("onclick"),
                "Add button has wrong method on click.");
        button.click();

        WebElement deleteButton = addRemoveElementsPage.deleteButton();
        assertEquals("Delete", deleteButton.getText(),
                "Wrong text on Delete button.");
        assertEquals("added-manually",deleteButton.getDomAttribute("class"),
                "Wrong class on delete button.");
    }

    /**
     * Check adding/deleting buttons
     */
    @ParameterizedTest
    @CsvSource({"1","2","10"})
    public void testAddButton(int iterations) {
        int size;
        WebElement addButton = addRemoveElementsPage.addButton();
        for (int i = 0; i < iterations; i++) {
            addButton.click();
        }

        size = addRemoveElementsPage.buttons().size();
        assertEquals(iterations, size,
                "Wrong amount of generated buttons.");

        for (int i = 0; i < iterations; i++){
            WebElement deleteButton = addRemoveElementsPage.deleteButton();
            deleteButton.click();
        }

        size = addRemoveElementsPage.buttons().size();
        assertEquals(0, size,
                "Some unexpected buttons left.");
    }
}
