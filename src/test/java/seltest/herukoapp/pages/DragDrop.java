package seltest.herukoapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragDrop {

    WebDriver driver;
    Actions action;

    @FindBy(xpath = "//*[@id=\"content\"]/div/h3")
    WebElement header;

    @FindBy(id = "column-a")
    WebElement areaA;

    @FindBy(id = "column-b")
    WebElement areaB;

    public DragDrop(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(this.driver);
    }

    public String getHeaderText(){
        return header.getText();
    }

    public WebElement getAreaA(){
        return areaA;
    }

    public WebElement getAreaB(){
        return areaB;
    }

    public void dragDrop(WebElement from, WebElement to) {
        action.dragAndDrop(from, to).perform();
    }

}
