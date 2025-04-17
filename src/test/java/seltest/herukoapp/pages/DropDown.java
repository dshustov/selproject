package seltest.herukoapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {
    WebDriver driver;
    Select select;

    @FindBy(xpath = "//*[@id=\"content\"]/div/h3")
    WebElement header;

    @FindBy(id = "dropdown")
    WebElement dropdown;

    @FindBy(xpath = "//*[@id=\"dropdown\"]/option[2]")
    WebElement option1;

    @FindBy(xpath = "//*[@id=\"dropdown\"]/option[3]")
    WebElement option2;

    @FindBy(xpath = "//*[@id=\"dropdown\"]/option[1]")
    WebElement defaultOption;

    public DropDown(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        select =new Select(dropdown);
    }

    public String getHeaderText(){
        return header.getText();
    }

    public WebElement getDropdown(){
        return dropdown;
    }

    public WebElement getOption1() { return option1; }

    public WebElement getOption2() { return option2; }

    public WebElement getDefaultOption() { return defaultOption; }

    public void selectByValue(String value){
        select.selectByValue(value);
    }

    public void selectByText(String text){
        select.selectByVisibleText(text);
    }

    public void selectByInd(int ind){
        select.selectByIndex(ind);
    }

    public List<WebElement> getOptions(){
        return select.getOptions();
    }
}
