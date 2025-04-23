package seltest.herukoapp.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ChromeDriverSession extends AbstractDriverSession{

    ChromeOptions options;

    public ChromeDriverSession() throws IOException {
    }

    @Override
    public WebDriver establishSession() {
        options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", downloadFolder);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        return driver;
    }

    @Override
    public void terminateSession() {
        driver.quit();
    }
}
