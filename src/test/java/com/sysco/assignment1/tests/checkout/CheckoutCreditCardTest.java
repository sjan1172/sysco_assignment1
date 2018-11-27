package com.sysco.assignment1.tests.checkout;

import com.sysco.assignment1.common.Categories;
import com.sysco.assignment1.functions.ShoppingCartFunc;
import com.sysco.assignment1.functions.UserFunc;
import com.sysco.assignment1.models.CartDetails;
import com.sysco.assignment1.models.CartItem;
import com.sysco.assignment1.utils.TestBase;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutCreditCardTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Online Shopping - Checkout");
    }

    @Test(description = "Verify Credit Card field on Checkout Page", alwaysRun = true)
    public void verifyCCFieldsAreVisibleOnCheckoutPage(){
        //Navigate to My Account
        UserFunc.getLogin("williamjacob802@gmail.com", "0okmNHY6");
        Assert.assertTrue(UserFunc.verifyWhetherCorrectUserLoggedIn("WILLIAM JACOB"), "=== LoggedIn username did not display correctly. ===");
        System.out.println("=== LoggedIn username displayed correctly ===");

        //Clean cart
        ShoppingCartFunc.cleanCart();

        //Validating whether all items removed
        ShoppingCartFunc.openCart();
        Assert.assertTrue(ShoppingCartFunc.isNoItemsLabelDisplayed(), "=== All items not removed from Cart ===");
        System.out.println("=== All items removed from Cart ===");
        ShoppingCartFunc.closeCart();

        //Add a random men item to cart
//        UserFunc.addRandomItemFromMensCategoryToCart(Categories.LIFESTYLE);
//        ShoppingCartFunc.verifyCartItemExists(UserFunc.userSelectedCartItemDetails);

        //Add a random men item to cart
        UserFunc.addRandomItemFromMensCategoryToCart(Categories.SCHOOL);
        ShoppingCartFunc.verifyCartItemExists(UserFunc.userSelectedCartItemDetails);

        //Click ‘Secure Checkout’
        ShoppingCartFunc.clickSecureCheckout();

        //Verify First and last name in checkout page
        Assert.assertTrue(ShoppingCartFunc.verifyWhetherCorrectUserLoggedIn("WILLIAM JACOB"), "=== LoggedIn username did not display in Checkout Page ===");
        System.out.println("=== LoggedIn username displayed in Checkout Page ===");

        //Validate Continue button function without adding mandatory values
        ShoppingCartFunc.continueCheckoutWithoutFillingAnyFields();

        //Add values Post code 2000 and click Continue
        ShoppingCartFunc.continueCheckoutFillingMandatoryData("2000", "Address 01", "0779505544");

        //Select Payment type CC and validate CC fields 
        ShoppingCartFunc.selectPaymentMethodCreditCard();
        ShoppingCartFunc.verifyCreditCardFieldVisible();
    }
}