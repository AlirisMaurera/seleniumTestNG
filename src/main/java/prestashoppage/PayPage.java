package prestashoppage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayPage {

    private WebDriver driver;

    @FindBy(name = "id_address_delivery")
    private WebElement address;

    @FindBy(name = "confirm-addresses")
    private WebElement confirmationAddress;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmationOption;

    @FindBy(id = "payment-option-1")
    private WebElement selectPay;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement selecAgreeTerm;

    @FindBy(css = ".ps-shown-by-js button")
    private WebElement pay;

    @FindBy(css = ".cart-total span:nth-child(2)")
    private WebElement total;

    public PayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isSelectAddress() {
        if(address.isSelected()){
            return true;
        }else return false;
    }

    public void addressContinue() {
        confirmationAddress.click();
    }

    public void shippingContinue() {
        confirmationOption.click();
    }

    public void selectPayment() {
        selectPay.click();
    }

    public void agreeTerm() {
        selecAgreeTerm.click();
    }

    public String getTotal() {
    return total.getText();
    }

    public ConfirmationPage pay() {
        pay.click();
        return new ConfirmationPage(driver);
    }
}
