package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seltest.herukoapp.pages.DynamicLoading;
import seltest.herukoapp.webdriver.BaseHerukoTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicLoadingTest extends BaseHerukoTest {

    DynamicLoading dynamicLoadingPage;
    WebDriverWait wait;

    /**
     * Testing link and header to the page
     */
    @BeforeEach
    public void goToPage(){
        mainPage.mainPageStart();
        mainPage.goToLesson("Dynamic Loading");

        dynamicLoadingPage = new DynamicLoading(driver);

        String header = dynamicLoadingPage.getHeaderText();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        assertEquals("Dynamically Loaded Page Elements", header,
                "Wrong page header.");
    }

    /**
     * Check Example 1: Element on page that is hidden
     */
    @Test
    public void checkExample1() {
        dynamicLoadingPage.getEx1().click();
        dynamicLoadingPage.getStartButton().click();

        wait.until(ExpectedConditions.domAttributeToBe(dynamicLoadingPage.getLoading(),"style",
                "display: none;"));

        assertEquals("Hello World!", dynamicLoadingPage.getFinishTitle());
    }

    /**
     * Check Example 2: Element rendered after the fact
     */
    @Test
    public void checkExample2() {
        dynamicLoadingPage.getEx2().click();
        dynamicLoadingPage.getStartButton().click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.id("finish"),1));

        assertEquals("Hello World!", dynamicLoadingPage.getFinishTitle());
    }
}
