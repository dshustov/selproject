package seltest.herukoapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenu {
    WebDriver driver;
    Actions actions;

    @FindBy(xpath = "//*[@id=\"content\"]/div/h3")
    WebElement header;

    @FindBy(xpath = "//*[@id=\"hot-spot\"]")
    WebElement hotSpot;

    public ContextMenu(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(this.driver);
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText(){
        return header.getText();
    }

    public void rightClickOnHotSpot(){
        actions.contextClick(hotSpot).perform();
    }

    public void leftClickOnHotSpot(){
        hotSpot.click();
    }
}
