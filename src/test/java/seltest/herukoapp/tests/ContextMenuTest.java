package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import seltest.herukoapp.pages.Checkboxes;
import seltest.herukoapp.pages.ContextMenu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testng.AssertJUnit.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContextMenuTest extends InitiateSeleniumTest{

    ContextMenu contextMenuPage;

    @BeforeEach
    public void goToPage(){
        /**
         * Testing link and header to the page
         */
        mainPage.mainPageStart();
        mainPage.goToLesson("Context Menu");

        contextMenuPage = new ContextMenu(driver);

        String header = contextMenuPage.getHeaderText();

        assertEquals("Context Menu", header);
    }

    @Test
    public void checkRightContextMenu() {
        /**
         * Test interaction with context menu
         */
        contextMenuPage.rightClickOnHotSpot();
        try{
            Alert alert = driver.switchTo().alert();
            String alertMessage= driver.switchTo().alert().getText();
            assertEquals("You selected a context menu", alertMessage,
                    "Alert message is error.");
            alert.dismiss();
        }catch (NoAlertPresentException e){
            fail("No Alert appears!");
        }
    }

    @Test
    public void checkLeftContextMenu() {
        /**
         * Test interaction with left click
         */
        contextMenuPage.leftClickOnHotSpot();
        try{
            Alert alert = driver.switchTo().alert();
            fail("Alert appears!");
        }catch (NoAlertPresentException e){
           //do nothing
        }
    }
}
