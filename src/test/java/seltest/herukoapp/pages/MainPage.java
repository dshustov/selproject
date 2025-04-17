package seltest.herukoapp.pages;

import com.google.common.io.Resources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class MainPage {

    WebDriver driver;
    String baseUrl;


    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    WebElement header;

    public MainPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        URL res = Resources.getResource("params.properties");
        Properties defaultProps = new Properties();

        defaultProps.load(new FileInputStream(res.getFile()));
        baseUrl = defaultProps.getProperty("baseUrl");
    }

    public void goToLesson(String linkText){
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
    }

    public void mainPageStart(){
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    public String getBaseUrl(){
        return baseUrl;
    }

    public String getHeaderText(){
        return header.getText();
    }

}
