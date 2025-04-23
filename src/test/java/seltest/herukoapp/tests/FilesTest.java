package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seltest.herukoapp.webdriver.BaseHerukoTest;

import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FilesTest extends BaseHerukoTest {

    WebDriverWait wait;
    By downloadPageTitle = By.xpath("//*[@id=\"content\"]/div/h3");
    By downloadFile = By.xpath("//*[@id=\"content\"]/div/a[1]");
    By uploadPageTitle = By.xpath("//*[@id=\"content\"]/div[1]/h3");
    By uploadFileChooser = By.id("file-upload");
    By uploadButton = By.id("file-submit");
    By uploadedTitle = By.xpath("//*[@id=\"content\"]/div/h3");
    By uploadedFileName = By.id("uploaded-files");

    /**
     * Testing link and header to the page
     */
    @BeforeEach
    public void goToPage() {
        mainPage.mainPageStart();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /**
     * Checking file download with Selenium
     */
    @Test
    public void checkFileDownload() throws InterruptedException {
        mainPage.goToLesson("File Download");

        String header = driver.findElement(downloadPageTitle).getText();
        assertEquals("File Downloader", header,
                "Wrong page header.");

        WebElement fileLink = driver.findElement(downloadFile);
        String fileName = fileLink.getText();

        fileLink.click();
        System.out.println(downloadFolder);
        String filePath = downloadFolder+File.separator+fileName;

        boolean fileSaved = isFileDownloaded(filePath);
        if(fileSaved){
            File file = new File(filePath);
            if(!file.delete()){
                fail("Can not delete: "+downloadFolder);
            }
        }
        else{
            fail("File not saved into: "+downloadFolder);
        }
    }

    /**
     * Checking file upload with Selenium
     */
    @Test
    public void checkUploadFile(){
        String testFileName = "Test.txt";
        mainPage.goToLesson("File Upload");

        String header = driver.findElement(uploadPageTitle).getText();
        assertEquals("File Uploader", header,
                "Wrong page header.");

        WebElement fileInput = driver.findElement(uploadFileChooser);
        fileInput.sendKeys(downloadFolder+File.separator+testFileName);

        driver.findElement(uploadButton).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(uploadedFileName));

        assertEquals("File Uploaded!", driver.findElement(uploadPageTitle).getText());
        assertEquals(testFileName,driver.findElement(uploadedFileName).getText());

    }
    private boolean isFileDownloaded(String filePath) throws InterruptedException {
        final int SLEEP_TIME_MILLIS = 1000;
        System.out.println(filePath);
        File file = new File(filePath);
        final int timeout = 10* SLEEP_TIME_MILLIS;
        int timeElapsed = 0;
        while (timeElapsed<timeout){
            if (file.exists()) {
                return true;
            } else {
                timeElapsed +=SLEEP_TIME_MILLIS;
                Thread.sleep(SLEEP_TIME_MILLIS);
            }
        }
        return false;
    }
}
