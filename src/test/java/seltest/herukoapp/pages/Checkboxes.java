package seltest.herukoapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkboxes {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/div/h3")
    WebElement header;

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    WebElement checkBox1;

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
    WebElement checkBox2;

    public Checkboxes(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText(){
        return header.getText();
    }

    public boolean isCheckbox1On(){
        return checkBox1.isSelected();
    }

    public boolean isCheckbox2On(){
        return checkBox2.isSelected();
    }

    public void checkBox1Click(){
        checkBox1.click();
    }

    public void checkBox2Click(){
        checkBox2.click();
    }
}
