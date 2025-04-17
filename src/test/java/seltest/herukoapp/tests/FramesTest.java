package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.awt.*;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FramesTest extends InitiateSeleniumTest{

    By framePageHeader = By.xpath("//*[@id=\"content\"]/div/h3");
    By nestedFrameslink = By.xpath("//*[@id=\"content\"]/div/ul/li[1]/a");
    By iframeLink = By.xpath("//*[@id=\"content\"]/div/ul/li[2]/a");
    By middleFrame = By.name("frame-middle");
    By middleFrameText = By.xpath("/html/body/div");
    By frameTop = By.name("frame-top");
    By leftFrame = By.name("frame-left");
    By leftFrameText = By.xpath("/html/body");
    By bottomFrame = By.name("frame-bottom");
    By bottomFrameText = By.xpath("/html/body");
    By iFrame = By.id("mce_0_ifr");
    By iFrameText = By.xpath("//*[@id=\"tinymce\"]/p");


    @BeforeEach
    public void goToPage() throws AWTException {
        /**
         * Testing link and header to the page
         */
        mainPage.mainPageStart();
    }

    @Test
    public void checkFrames() {
        /**
         * Simple test of frames
         */
        mainPage.goToLesson("Frames");
        String header = driver.findElement(framePageHeader).getText();
        assertEquals("Frames", header,
                "Wrong page header.");

        driver.findElement(nestedFrameslink).click();

        WebElement frameTopEl = driver.findElement(frameTop);
        driver.switchTo().frame(frameTopEl);

        WebElement leftFrameEl = driver.findElement(leftFrame);
        driver.switchTo().frame(leftFrameEl);
        assertEquals("LEFT",driver.findElement(leftFrameText).getText());

        driver.switchTo().parentFrame();
        WebElement middleFrameEl = driver.findElement(middleFrame);
        driver.switchTo().frame(middleFrameEl);
        assertEquals("MIDDLE",driver.findElement(middleFrameText).getText());

        driver.switchTo().defaultContent();
        WebElement bottomFrameEl = driver.findElement(bottomFrame);
        driver.switchTo().frame(bottomFrameEl);
        assertEquals("BOTTOM",driver.findElement(bottomFrameText).getText());
    }

    @Test
    public void checkIframe(){
        /**
         * checking iFrames
         */
        mainPage.goToLesson("Frames");
        String header = driver.findElement(framePageHeader).getText();
        assertEquals("Frames", header,
                "Wrong page header.");
        driver.findElement(iframeLink).click();

        WebElement iFrameEl = driver.findElement(iFrame);
        driver.switchTo().frame(iFrameEl);
        assertEquals("Your content goes here.",driver.findElement(iFrameText).getText());
    }
}
