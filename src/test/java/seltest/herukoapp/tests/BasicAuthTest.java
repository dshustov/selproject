package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seltest.herukoapp.pages.MainPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BasicAuthTest extends InitiateSeleniumTest{

    private By successTextBy = By.xpath("//*[@id=\"content\"]/div/p");


    @Test
    public void verifyLink()  {
        /**
         * Silly test to check link
         */
        mainPage.mainPageStart();
        mainPage.goToLesson("Basic Auth");
    }

    @Test
    public void successAuth() throws MalformedURLException {
        /**
         * Test successful Authorisation
         */
        String loginUrl = buildLoginUrl("admin", "admin");
        driver.get(loginUrl);
        WebElement successText = driver.findElement(successTextBy);
        assertEquals("Congratulations! You must have the proper credentials.", successText.getText(),
                "Wrong successful login text.");
    }

    @ParameterizedTest
    @CsvSource({"admin, test",
                "test, 123",
                "admin, Admin"})
    public void failedAuth(String login, String password) throws MalformedURLException {
        /**
         * Test scenarios for failed Authorisation
         */
        String loginUrl = buildLoginUrl(login, password);
        driver.get(loginUrl);

        List <WebElement> successText = driver.findElements(successTextBy);
        assertEquals(0, successText.size(),
                "Unexpected success login text.");
    }

    public String buildLoginUrl(String login, String password) throws MalformedURLException {
        /**
         * Convert base url into login/password url
         */
        URL mainUrl = new URL(mainPage.getBaseUrl());
        return "https://" + login +":"+ password + "@" + mainUrl.getHost() + "/basic_auth";
    }


}
