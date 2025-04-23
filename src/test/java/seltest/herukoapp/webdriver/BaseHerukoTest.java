package seltest.herukoapp.webdriver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import seltest.herukoapp.pages.MainPage;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseHerukoTest {

    protected WebDriver driver;
    InitiateSelenium initSelenium;
    protected MainPage mainPage;
    protected String downloadFolder;

    @BeforeAll
    public void setup() throws Exception {
        initSelenium = new InitiateSelenium();
        driver = initSelenium.establishSession();
        mainPage = new MainPage(driver);
        downloadFolder = initSelenium.downloadFolder;
    }

    @AfterAll
    public void teardown(){
        initSelenium.terminateSession();
    }
}
