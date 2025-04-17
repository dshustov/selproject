package seltest.herukoapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class ChallengeDOM {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/div/h3")
    WebElement header;

    @FindBy(className = "button")
    WebElement blueButton;

    @FindBy(css = ".button.alert")
    WebElement redButton;

    @FindBy(css = ".button.success")
    WebElement greenButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[2]/table/thead/tr")
    WebElement tableHeader;

    @FindBy(xpath = "(//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr)[last()]")
    WebElement lastTableRow;

    @FindBy(xpath = "//*[@id=\"content\"]/script")
    WebElement scriptText;

    public ChallengeDOM(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText(){
        return header.getText();
    }

    public WebElement getBlueButton() { return blueButton; }

    public WebElement getRedButton(){
        return redButton;
    }

    public WebElement getGreenButton(){
        return greenButton;
    }

    public List<WebElement> getTableHeaders(){
        return tableHeader.findElements(By.tagName("th"));
    }

    public List<WebElement> getLastTableRowElements(){
        return lastTableRow.findElements(By.tagName("td"));
    }

    public String getAnswerValue(){
        String innerText = scriptText.getDomProperty("innerHTML");
        return extractAnswer(innerText);
    }
    private String extractAnswer(String innerText){
        /**
         * Extract answer string from innerHTML. In case of error returns ""
         */
        String output = "";

        try{
            String[] sentences = innerText.split("Answer: ");
            String[] answer = sentences[1].split("'");
            output = answer[0];
        }
        catch(Exception e) {
            fail("Error on parsing inner HTML");
        }
        finally{
            return output;
        }
    }

}
