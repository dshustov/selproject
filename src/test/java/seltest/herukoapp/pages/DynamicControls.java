package seltest.herukoapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DynamicControls {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/h4[1]")
    WebElement header;

    @FindBy(xpath = "//*[@type=\"checkbox\"]/parent::div")
    WebElement checkboxArea;

    @FindBy(css = "[type=\"checkbox\"]")
    WebElement checkbox;

    @FindBy(xpath = "//*[@id=\"checkbox-example\"]/button")
    WebElement addRemoveButton;

    @FindBy(xpath = "//*[@id=\"input-example\"]/input")
    WebElement textBox;

    @FindBy(xpath = "//*[@id=\"input-example\"]/button")
    WebElement enableDisableButton;

    public DynamicControls(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText(){
        return header.getText();
    }

    public WebElement getCheckbox(){ return checkbox; }

    public WebElement getAddRemoveButton(){
        return addRemoveButton;
    }

    public WebElement getTextBox(){
        return textBox;
    }

    public WebElement getEnableDisableButton() {
        return enableDisableButton;
    }

    public String getCheckboxText() {
        return checkboxArea.getText();
    }
}
