package seltest.herukoapp.tests;

import com.google.common.io.Resources;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import seltest.herukoapp.pages.MainPage;

import java.io.FileInputStream;
import java.net.URL;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InitiateSeleniumTest {

    ChromeDriver driver;
    ChromeOptions options;
    String baseUrl;
    String downloadFolder;

    MainPage mainPage;

    @BeforeAll
    public void setup() throws Exception {
        URL res = Resources.getResource("params.properties");
        Properties defaultProps = new Properties();
        defaultProps.load(new FileInputStream(res.getFile()));

        downloadFolder = defaultProps.getProperty("downloadDir");
        baseUrl = defaultProps.getProperty("baseUrl");

        options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", downloadFolder);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);

        mainPage = new MainPage(driver);
    }

    @AfterAll
    public void teardown(){
        driver.quit();
    }

    public static int verifyLinks(String linkUrl)
    {
        int status = 0;
        try
        {
            URL url = new URL(linkUrl);

            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            status = httpURLConnect.getResponseCode();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
}
