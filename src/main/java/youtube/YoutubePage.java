package youtube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YoutubePage {

    private WebDriver driver;

    private String url = "https://www.youtube.com/";

    @FindBy(name = "search_query")
    private WebElement searchQuery;

    @FindBy(css = "#center button:nth-child(2)")
    private WebElement goQuery;

    public YoutubePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToYoutube(){
        driver.get(url);
    }

    public NamePage searchName(String name){
        searchQuery.sendKeys(name);

        return new NamePage(driver);
    }

    public NamePage clickSearch(){

        goQuery.click();
        return new NamePage(driver);
    }

}
