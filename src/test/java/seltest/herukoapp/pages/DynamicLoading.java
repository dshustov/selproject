package seltest.herukoapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoading {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/div/h3")
    WebElement header;

    @FindBy(xpath ="//*[@id=\"content\"]/div/a[1]")
    WebElement ex1;

    @FindBy(xpath = "//*[@id=\"content\"]/div/a[2]")
    WebElement ex2;

    @FindBy(xpath = "//*[@id=\"start\"]/button")
    WebElement startButton;

    @FindBy(id = "loading")
    WebElement loading;

    @FindBy(xpath = "//*[@id=\"finish\"]/h4")
    WebElement finishTitle;

    public DynamicLoading(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText(){
        return header.getText();
    }

    public WebElement getEx1() { return ex1;}

    public WebElement getEx2() { return ex2;}

    public WebElement getStartButton() {return startButton;}

    public WebElement getLoading() {return loading;}

    public String getFinishTitle() {return finishTitle.getText();}

}
