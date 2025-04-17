package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seltest.herukoapp.pages.DynamicLoading;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicLoadingTest extends InitiateSeleniumTest{

    DynamicLoading dynamicLoadingPage;
    WebDriverWait wait;

    @BeforeEach
    public void goToPage(){
        /**
         * Testing link and header to the page
         */
        mainPage.mainPageStart();
        mainPage.goToLesson("Dynamic Loading");

        dynamicLoadingPage = new DynamicLoading(driver);

        String header = dynamicLoadingPage.getHeaderText();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        assertEquals("Dynamically Loaded Page Elements", header,
                "Wrong page header.");
    }

    @Test
    public void checkExample1() {
        /**
         * Check Example 1: Element on page that is hidden
         */
        dynamicLoadingPage.getEx1().click();
        dynamicLoadingPage.getStartButton().click();

        wait.until(ExpectedConditions.domAttributeToBe(dynamicLoadingPage.getLoading(),"style",
                "display: none;"));

        assertEquals("Hello World!", dynamicLoadingPage.getFinishTitle());
    }

    @Test
    public void checkExample2() {
        /**
         * Check Example 2: Element rendered after the fact
         */
        dynamicLoadingPage.getEx2().click();
        dynamicLoadingPage.getStartButton().click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.id("finish"),1));

        assertEquals("Hello World!", dynamicLoadingPage.getFinishTitle());
    }
}
