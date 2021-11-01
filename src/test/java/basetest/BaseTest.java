package basetest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import prestashoppage.HomePage;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:/dev/driver/versâo_95/chromedriver.exe");
        driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
    }

    @AfterTest
    public void quit(){
        driver.quit();
    }

}
