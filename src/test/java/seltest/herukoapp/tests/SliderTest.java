package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import seltest.herukoapp.webdriver.BaseHerukoTest;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SliderTest extends BaseHerukoTest {
    Actions action;

    By sliderPageHeader = By.xpath("//*[@id=\"content\"]/div/h3");

    By sliderPath = By.xpath("//*[@id=\"content\"]/div/div/input");

    /**
     * Testing link and header to the page
     */
    @BeforeEach
    public void goToPage() throws AWTException {
        mainPage.mainPageStart();
        action = new Actions(driver);
    }

    /**
     * Moving slider
     */
    @Test
    public void checkSlider() {
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
