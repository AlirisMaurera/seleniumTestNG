package prestashoppage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;

    @FindBy(css = ".text-sm-center .btn-primary")
    private WebElement bottonCheckout;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PayPage checkout() {
        bottonCheckout.click();
        return new PayPage(driver);
    }
}
