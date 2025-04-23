package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import seltest.herukoapp.pages.ContextMenu;
import seltest.herukoapp.webdriver.BaseHerukoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.AssertJUnit.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContextMenuTest extends BaseHerukoTest {

    ContextMenu contextMenuPage;

    /**
     * Testing link and header to the page
     */
    @BeforeEach
    public void goToPage(){
        mainPage.mainPageStart();
        mainPage.goToLesson("Context Menu");

        contextMenuPage = new ContextMenu(driver);

        String header = contextMenuPage.getHeaderText();

        assertEquals("Context Menu", header);
    }

    /**
     * Test interaction with context menu
     */
    @Test
    public void checkRightContextMenu() {
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

    /**
     * Test interaction with left click
     */
    @Test
    public void checkLeftContextMenu() {
        contextMenuPage.leftClickOnHotSpot();
        try{
            Alert alert = driver.switchTo().alert();
            fail("Alert appears!");
        }catch (NoAlertPresentException e){
           //do nothing
        }
    }
}
