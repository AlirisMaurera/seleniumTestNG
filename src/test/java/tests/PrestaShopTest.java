package tests;

import basetest.BaseTest;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import prestashoppage.*;
import static org.hamcrest.CoreMatchers.is;

public class PrestaShopTest extends BaseTest {

    HomePage homePage;
    SingInPage singInPage;
    ProductPage productPage;
    private String email, password,name;
    //Parametrizando
    @BeforeTest
    @Parameters({"email", "password", "name"})
    public void Parametizer(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;

    }
    //Teste logar
    @Test
    public void Logar(){
        homePage = new HomePage(driver);
        homePage.goToSite();
        singInPage = homePage.singIn();
        YourAccountPage yourAccountPage = singInPage.login(email,password);
        homePage = yourAccountPage.goToTheMainPage();

        //Verificando que está logado
        assertThat(name, is(homePage.getNameHomePage()));
    }
    //Teste comprando produto
    @Test(dependsOnMethods = "Logar")
    public void buyProduct(){

        productPage = homePage.selectProduct();
        productPage.selectSize("M");
        productPage.selectQuantity("3");
        productPage.addToCart();

        // Verificando valores
        assertThat(productPage.getInformation(), endsWith("Product successfully added to your shopping cart"));
        assertThat(productPage.getPrice(), is("$28.72"));
        assertThat(productPage.getsize(), is("M"));
        assertThat(productPage.getquantity(), is("3"));
        assertThat(productPage.getSubTotal(), is("$86.16"));
        assertThat(productPage.getShipping(), is("$7.00"));
        assertThat(productPage.getTotal(), is("$93.16"));
    }
    //Teste pagamento
    @Test(dependsOnMethods = "buyProduct")
    public void Pay(){
       // buyProduct();
        CheckoutPage checkoutPage = productPage.proceedToCheckout();

        PayPage payPage = checkoutPage.checkout();

        //Verificando que o endereço está selecionado
        assertThat(true,is(payPage.isSelectAddress()));

        payPage.addressContinue();
        payPage.shippingContinue();
        payPage.selectPayment();
        payPage.agreeTerm();

        //Verifica o valor do pagamento total
        assertThat(payPage.getTotal(),is("$93.16"));

        ConfirmationPage confirmationPage = payPage.pay();

        //Verifica que a compra foi sucesso
        assertThat(confirmationPage.getConfirmation(),endsWith("YOUR ORDER IS CONFIRMED"));

    }
}
