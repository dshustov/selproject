package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import seltest.herukoapp.pages.AddRemoveElements;
import seltest.herukoapp.pages.DragDrop;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragDropTest extends InitiateSeleniumTest{

    DragDrop dragDropPage;

    @BeforeEach
    public void goToPage(){
        /**
         * Testing link and header to the page
         */
        mainPage.mainPageStart();
        mainPage.goToLesson("Drag and Drop");

        dragDropPage = new DragDrop(driver);

        String header = dragDropPage.getHeaderText();

        assertEquals("Drag and Drop", header);
    }

    @Test
    public void checkDragDrop(){
        /**
         * Test Drag n Drop between two areas
         */
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
