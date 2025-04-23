package seltest.herukoapp.webdriver;

import com.google.common.io.Resources;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.net.URL;

public abstract class AbstractDriverSession {

    WebDriver driver;

    String baseURL;
    String downloadFolder;
    String driverName;

    public AbstractDriverSession() throws IOException {
        URL res = Resources.getResource("params.properties");
        Properties defaultProps = new Properties();
        defaultProps.load(new FileInputStream(res.getFile()));

        downloadFolder = defaultProps.getProperty("downloadDir");
        baseURL = defaultProps.getProperty("baseURL");
        driverName = defaultProps.getProperty("driverName");
    }

    abstract WebDriver establishSession() throws Exception;
    abstract void terminateSession();
}
