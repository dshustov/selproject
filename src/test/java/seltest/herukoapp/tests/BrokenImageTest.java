package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seltest.herukoapp.pages.BrokenImages;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BrokenImageTest extends InitiateSeleniumTest{

    BrokenImages brokenImagesPage;

    @BeforeEach
    public void goToPage()  {
        mainPage.mainPageStart();
        mainPage.goToLesson("Broken Images");

        brokenImagesPage = new BrokenImages(driver);
        String header = brokenImagesPage.getHeaderText();

        assertEquals("Broken Images", header);
    }

    @Test
    public void checkBrokenImgs() throws IOException {
        List<WebElement> image_list = driver.findElements(By.tagName("img"));

        for (WebElement img:image_list ) {
            int code = verifyLinks( mainPage.getBaseUrl()+img.getDomAttribute("src"));
            if(code == 0) {
                fail("No response from: "+mainPage.getBaseUrl()+img.getDomAttribute("src"));
            }
            assertEquals(200, code,
                    "Wrong return code on image vrification.");
        }
    }
}
