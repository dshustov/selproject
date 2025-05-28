package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import seltest.herukoapp.webdriver.BaseHerukoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaScriptAlertTest  extends BaseHerukoTest {
    private Actions action;

    By result = By.xpath("//*[@id=\"result\"]");

    @BeforeEach
    public void goToPage() {
        mainPage.mainPageStart();
        action = new Actions(driver);
    }

    @Test
    public void clickForJSAlert(){
        mainPage.goToLesson("JavaScript Alerts");
        WebElement link = driver.findElement(By.xpath("//*[contains(text(), 'Click for JS Alert')]"));
        link.click();

        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        assertEquals(text, "I am a JS Alert");
        alert.accept();

        assertEquals(driver.findElement(result).getText(), "You successfully clicked an alert");
    }

    @Test
    public void clickJSConfirmButton(){
        mainPage.goToLesson("JavaScript Alerts");
        WebElement link = driver.findElement(By.xpath("//*[contains(text(), 'Click for JS Confirm')]"));
        link.click();

        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        assertEquals(text, "I am a JS Confirm");
        alert.accept();

        assertEquals(driver.findElement(result).getText(), "You clicked: Ok");

        link.click();

        alert = driver.switchTo().alert();
        text = alert.getText();
        assertEquals(text, "I am a JS Confirm");
        alert.dismiss();

        assertEquals(driver.findElement(result).getText(), "You clicked: Cancel");

    }
}
