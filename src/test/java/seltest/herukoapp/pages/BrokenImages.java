package seltest.herukoapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrokenImages {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/div/h3")
    WebElement header;

    public BrokenImages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText(){
        return header.getText();
    }
}
