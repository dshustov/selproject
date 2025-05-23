package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import seltest.herukoapp.pages.DragDrop;
import seltest.herukoapp.webdriver.BaseHerukoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragDropTest extends BaseHerukoTest {

    DragDrop dragDropPage;

    /**
     * Testing link and header to the page
     */
    @BeforeEach
    public void goToPage(){
        mainPage.mainPageStart();
        mainPage.goToLesson("Drag and Drop");

        dragDropPage = new DragDrop(driver);

        String header = dragDropPage.getHeaderText();

        assertEquals("Drag and Drop", header);
    }

    /**
     * Test Drag n Drop between two areas
     */
    @Test
    public void checkDragDrop(){
        WebElement firstArea = dragDropPage.getAreaA();
        WebElement secondArea = dragDropPage.getAreaB();
        assertEquals("A",firstArea.getText(),
                "Wrong text in area.");
        assertEquals("B",secondArea.getText(),
                "Wrong text in area.");

        dragDropPage.dragDrop(firstArea,secondArea);

        assertEquals("B",firstArea.getText(),
                "Wrong text in area.");
        assertEquals("A", secondArea.getText(),
                "Wrong text in area.");

        dragDropPage.dragDrop(secondArea,firstArea);
        assertEquals("A",firstArea.getText(),
                "Wrong text in area.");
        assertEquals("B",secondArea.getText(),
                "Wrong text in area.");
    }
}
