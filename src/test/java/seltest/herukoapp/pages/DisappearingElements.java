package seltest.herukoapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisappearingElements {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/div/h3")
    WebElement header;

    @FindBy(linkText = "Home")
    WebElement homeButton;

    @FindBy(linkText = "About")
    WebElement aboutButton;

    @FindBy(linkText = "Contact Us")
    WebElement contactUsButton;

    @FindBy(linkText = "Portfolio")
    WebElement portfolioButton;

    @FindBy(linkText = "Gallery")
    WebElement galleryButton;

    public DisappearingElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText(){
        return header.getText();
    }

    public void clickHome(){
        homeButton.click();
    }

    public void clickAbout(){
        aboutButton.click();
    }

    public void clickContactUs(){
        contactUsButton.click();
    }

    public void clickPortfolio(){
        portfolioButton.click();
    }

    public void clickGallery(){
        galleryButton.click();
    }

    public boolean isGalleryButtonPresent(){
        try{
            driver.findElement(By.linkText("Gallery"));
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
}
