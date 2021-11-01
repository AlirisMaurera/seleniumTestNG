package prestashoppage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {

    private WebDriver driver;

    @FindBy(css = "div.form-control-valign > label:nth-child(1)")
    private WebElement mr;

    @FindBy(css = "div.form-control-valign > label:nth-child(2)")
    private WebElement mrs;

    @FindBy(name = "firstname")
    private WebElement fistNameForm;

    @FindBy(name = "lastname")
    private WebElement lastNameForm;

    @FindBy(name = "email")
    private WebElement emailForm;

    @FindBy(name = "password")
    private WebElement passwordForm;

    @FindBy(name = "birthday")
    private WebElement birthdayForm;

    @FindBy(name = "psgdpr")
    private WebElement term;

    @FindBy(css = ".clearfix button")
    private WebElement save;


    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectOption(String value){
       String botton1 = mr.getText();
       String botton2 = mrs.getText();
       if (botton1.equalsIgnoreCase(value)){
           mr.click();
       }else mrs.click();
    }

    public void resgisterForm(String firstName, String lastName, String email, String password, String birthdate){

        fistNameForm.sendKeys(firstName);
        lastNameForm.sendKeys(lastName);
        emailForm.sendKeys(email);
        passwordForm.sendKeys(password);
        birthdayForm.sendKeys(birthdate);
        term.click();
    }

    public void saveForm(){
        save.click();
    }


}
