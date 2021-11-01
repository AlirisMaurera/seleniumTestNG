package prestashoppage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingInPage {

    private WebDriver driver;

    @FindBy(css = "div.no-account a")
    private WebElement createAccount;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement submit;


    public SingInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateAccountPage createAccountUser(){
        createAccount.click();
        return new CreateAccountPage(driver);
    }


    public YourAccountPage login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();
        return new YourAccountPage(driver);
    }


}
