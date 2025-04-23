package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SliderTest extends InitiateSeleniumTest{
    Actions action;

    By sliderPageHeader = By.xpath("//*[@id=\"content\"]/div/h3");

    By sliderPath = By.xpath("//*[@id=\"content\"]/div/div/input");

    @BeforeEach
    public void goToPage() throws AWTException {
        /**
         * Testing link and header to the page
         */
        mainPage.mainPageStart();
        action = new Actions(driver);
    }

    @Test
    public void checkSlider() {
        /**
         * Moving slider
         */
        mainPage.goToLesson("Horizontal Slider");
        String header = driver.findElement(sliderPageHeader).getText();
        assertEquals("Horizontal Slider", header,
                "Wrong page header.");

        WebElement slider = driver.findElement(sliderPath);
        action.click(slider)
                .perform();

        for (int i=0;i<4;i++){
            action.sendKeys(Keys.ARROW_RIGHT).perform();
        }
    }
}
