package seltest.herukoapp.webdriver;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class InitiateSelenium extends AbstractDriverSession{


    public InitiateSelenium() throws IOException {
    }

    @Override
    WebDriver establishSession() throws Exception {
        if (super.driverName.equals("Chrome")) {
            ChromeDriverSession chromeSession = new ChromeDriverSession();
            driver = chromeSession.establishSession();
        }
        else if (driverName.equals("Edge")){
            // TODO
        }
        else {
            throw new Exception(super.driverName + " has invalid value");
        }

        return driver;
    }

    @Override
    void terminateSession() {
        driver.quit();
    }
}
