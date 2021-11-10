package basetest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import prestashoppage.HomePage;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        //System.setProperty("webdriver.chrome.driver","C:/dev/driver/versâo_95/chromedriver.exe");

        String host = "localhost";
        DesiredCapabilities dc = DesiredCapabilities.chrome();

        if (System.getProperty("BROWSER") != null
                && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }

        if (System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";
        driver = new RemoteWebDriver(new URL(completeUrl), dc);
    }

    @AfterTest
    public void quit(){
        driver.quit();
    }

}
