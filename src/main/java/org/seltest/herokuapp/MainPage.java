package org.seltest.herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {

  public void startPage(){
    //  System.setProperty("webdriver.chrome.driver", "Chrome Driver executable location on your system");
  //  System.setProperty("webdriver.chrome.driver", "C:\\Development\\misc\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.get("https://the-internet.herokuapp.com/");
    driver.manage().window().maximize();

    String title = driver.getTitle();
    System.out.println("The page title is : " + title);

    driver.quit();
  }


}
