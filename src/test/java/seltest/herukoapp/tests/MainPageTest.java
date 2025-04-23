package seltest.herukoapp.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebElement;
import seltest.herukoapp.webdriver.BaseHerukoTest;

public class MainPageTest extends BaseHerukoTest {

    @BeforeEach
    public void openStartPage(){
        mainPage.mainPageStart();
    }

    @Test
    public void startPage(){
        String title = driver.getTitle();
        assertEquals("The Internet", title,
                "Wrong page header.");
    }

    @Test
    public void checkABTestingPage(){
        mainPage.goToLesson("A/B Testing");
        WebElement header = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        assertEquals("A/B Test Variation 1", header.getText(),
                "Wrong page header. And this is intended!");
    }

}
