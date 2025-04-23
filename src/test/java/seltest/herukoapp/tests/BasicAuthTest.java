package seltest.herukoapp.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seltest.herukoapp.webdriver.BaseHerukoTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BasicAuthTest extends BaseHerukoTest {

    private By successTextBy = By.xpath("//*[@id=\"content\"]/div/p");


    /**
     * Silly test to check link
     */
    @Test
    public void verifyLink()  {
        mainPage.mainPageStart();
        mainPage.goToLesson("Basic Auth");
    }

    /**
     * Test successful Authorisation
     */
    @Test
    public void successAuth() throws MalformedURLException {
        String loginUrl = buildLoginUrl("admin", "admin");
        driver.get(loginUrl);
        WebElement successText = driver.findElement(successTextBy);
        assertEquals("Congratulations! You must have the proper credentials.", successText.getText(),
                "Wrong successful login text.");
    }

    /**
     * Test scenarios for failed Authorisation
     */
    @ParameterizedTest
    @CsvSource({"admin, test",
                "test, 123",
                "admin, Admin"})
    public void failedAuth(String login, String password) throws MalformedURLException {
        String loginUrl = buildLoginUrl(login, password);
        driver.get(loginUrl);

        List <WebElement> successText = driver.findElements(successTextBy);
        assertEquals(0, successText.size(),
                "Unexpected success login text.");
    }

    /**
     * Convert base url into login/password url
     */
    public String buildLoginUrl(String login, String password) throws MalformedURLException {
        URL mainUrl = new URL(mainPage.getBaseUrl());
        return "https://" + login +":"+ password + "@" + mainUrl.getHost() + "/basic_auth";
    }


}
