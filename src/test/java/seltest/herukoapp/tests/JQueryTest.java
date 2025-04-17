package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JQueryTest extends InitiateSeleniumTest{
    Actions action;

    By jqueryPageHeader = By.xpath("//*[@id=\"content\"]/div/h3");

    @BeforeEach
    public void goToPage() throws AWTException {
        /**
         * Testing link and header to the page
         */
        mainPage.mainPageStart();
        action = new Actions(driver);
    }

    @Test
    public void jqueryCheck(){
        /**
         * JQuery testing
         */
        mainPage.goToLesson("JQuery UI Menus");
        String header = driver.findElement(jqueryPageHeader).getText();
        assertEquals("JQueryUI - Menu", header,
                "Wrong page header.");

    }


}
