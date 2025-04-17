package seltest.herukoapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddRemoveElements {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/h3")
    WebElement header;

    @FindBy(xpath = "//*[text()='Add Element']")
    WebElement addButton;

    @FindBy(xpath = "//*[@id=\"elements\"]/button")
    WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"elements\"]/button")
    List<WebElement> buttons;

    public AddRemoveElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText(){
        return header.getText();
    }

    public WebElement addButton(){
        return addButton;
    }

    public WebElement deleteButton(){
        return deleteButton;
    }

    public List<WebElement> buttons(){
        return buttons;
    }
}
