package youtube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NamePage {

    private WebDriver driver;

    private WebDriverWait wait;

    public NamePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle()  {
        //wait(10);
        return driver.getTitle();
    }
}
