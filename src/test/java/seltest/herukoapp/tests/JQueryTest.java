package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import seltest.herukoapp.webdriver.BaseHerukoTest;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JQueryTest extends BaseHerukoTest {
    Actions action;

    By jqueryPageHeader = By.xpath("//*[@id=\"content\"]/div/h3");

    /**
     * Testing link and header to the page
     */
    @BeforeEach
    public void goToPage() throws AWTException {
        mainPage.mainPageStart();
        action = new Actions(driver);
    }

    /**
     * JQuery testing
     */
    @Test
    public void jqueryCheck(){
        mainPage.goToLesson("JQuery UI Menus");
        String header = driver.findElement(jqueryPageHeader).getText();
        assertEquals("JQueryUI - Menu", header,
                "Wrong page header.");

    }


}
