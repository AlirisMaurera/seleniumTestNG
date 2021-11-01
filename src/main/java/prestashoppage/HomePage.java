package prestashoppage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.runtime.model.ExceptionDetails;
import org.openqa.selenium.remote.http.netty.NettyClient;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "div.hidden-sm-down span")
    private WebElement singIng;

    @FindBy(css = ".account span")
    private WebElement nameAccount;

    @FindBy(css = ".products article:nth-child(2) a")
    private WebElement product;

    private String url = "https://marcelodebittencourt.com/demoprestashop/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver,this);
    }

    public void goToSite(){
        driver.get(url);
    }

    public SingInPage singIn(){
        singIng.click();
        return new SingInPage(driver);
    }

    public String getNameHomePage(){
        return nameAccount.getText();
    }

    public ProductPage selectProduct(){
        product.click();
        return new ProductPage(driver);
    }

}
