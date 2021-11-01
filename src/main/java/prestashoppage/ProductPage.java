package prestashoppage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;

    private WebDriverWait wait;

    @FindBy(id = "group_1")
    private WebElement sizeProduct;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityProduct;

    @FindBy(css = ".add button")
    private WebElement addProduct;

    @FindBy(id = "myModalLabel")
    private WebElement modal;

    @FindBy( css = "#blockcart-modal .product-price")
    private WebElement price;

    @FindBy(css = "#blockcart-modal .col-md-6:nth-child(2) span:nth-child(3) strong")
    private WebElement sizeModal;

    @FindBy(css = "#blockcart-modal .col-md-6:nth-child(2) span:nth-child(5) strong")
    private WebElement quantityModal;

    @FindBy(css = ".cart-content p:nth-child(2) span:nth-child(2)")
    private WebElement subTotal;

    @FindBy(css = ".cart-content p:nth-child(3) span:nth-child(2)")
    private WebElement shipping;

    @FindBy(css = ".cart-content p:nth-child(5) span:nth-child(2)")
    private WebElement total;

    @FindBy(css = ".cart-content-btn  a")
    private WebElement checkout;



    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectSize(String size){
        Select select = new Select(sizeProduct);
        select.selectByVisibleText(size);
    }

    public void selectQuantity(String value){
        quantityProduct.clear();
        quantityProduct.sendKeys(value);
    }

    public void addToCart(){
        addProduct.click();
    }

    public String getInformation() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModalLabel")));
        return modal.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getsize() {
        return sizeModal.getText();
    }

    public String getquantity() {
        return quantityModal.getText();
    }

    public String getSubTotal() {
        return subTotal.getText();
    }

    public String getShipping() {
        return shipping.getText();
    }

    public String  getTotal() {
        return total.getText();
    }


    public CheckoutPage proceedToCheckout() {
        checkout.click();
        return new CheckoutPage(driver);
    }
}
