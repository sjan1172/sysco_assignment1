package com.sysco.assignment1.tests.e2e;

import com.sysco.assignment1.functions.ShoppingCartFunc;
import com.sysco.assignment1.functions.UserFunc;
import com.sysco.assignment1.tests.dataProviders.TCE2E_001_TestData;
import com.sysco.assignment1.utils.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TCE2E_001_CheckoutCreditCardTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Online Shopping - Checkout");
    }

    @Test(description = "Verify whether user can proceed to checkout having one item on cart", priority = 0)
    public void verifyWhetherUserAllowedToProceedCheckoutHavingOneItemOnCart(){
        //Retrieving Test Data for the TestCase
        TCE2E_001_TestData testData = new TCE2E_001_TestData();

        //Navigate to My Account
        UserFunc.getLogin(testData.username, testData.password);
        Assert.assertTrue(UserFunc.verifyWhetherCorrectUserLoggedIn(testData.verifyUsername), "=== LoggedIn username did not display correctly. ===");
        System.out.println(String.format("=== CHECKPOINT: LoggedIn username displayed correctly (Displayed Name: %s) ===", testData.verifyUsername));

        //Clean cart
        ShoppingCartFunc.cleanCart();

        //Validating whether all items removed
        ShoppingCartFunc.openCart();
        Assert.assertTrue(ShoppingCartFunc.isNoItemsLabelDisplayed(), "=== All items not removed from Cart ===");
        System.out.println("=== CHECKPOINT: All items removed from Cart ===");
        ShoppingCartFunc.closeCart();

        //Add a random men item to cart
        UserFunc.addRandomItemFromMensCategoryToCart(testData.searchCategory1);
        ShoppingCartFunc.verifyCartItemExists(UserFunc.userSelectedCartItemDetails);
        System.out.println("=== CHECKPOINT: New Item Added to Cart Successfully ===");

        //Click ‘Secure Checkout’
        ShoppingCartFunc.clickSecureCheckout();
        System.out.println("=== CHECKPOINT: User visited checkout page successfully ===");

        //Verify First and last name in checkout page
        Assert.assertTrue(ShoppingCartFunc.verifyWhetherCorrectUserLoggedIn(testData.verifyUsername), "=== LoggedIn username did not display in Checkout Page ===");
        System.out.println(String.format("=== CHECKPOINT: LoggedIn username displayed correctly (Displayed Name: %s) ===", testData.verifyUsername));
    }

    @Test(description = "Verify whether user can proceed to checkout having two items on cart", priority = 1)
    public void verifyWhetherUserAllowedToProceedCheckoutHavingTwoItemsOnCart(){
        //Retrieving Test Data for the TestCase
        TCE2E_001_TestData testData = new TCE2E_001_TestData();

        //Navigate to My Account
        UserFunc.getLogin(testData.username, testData.password);
        Assert.assertTrue(UserFunc.verifyWhetherCorrectUserLoggedIn(testData.verifyUsername), "=== LoggedIn username did not display correctly. ===");
        System.out.println(String.format("=== CHECKPOINT: LoggedIn username displayed correctly (Displayed Name: %s) ===", testData.verifyUsername));

        //Clean cart
        ShoppingCartFunc.cleanCart();

        //Validating whether all items removed
        ShoppingCartFunc.openCart();
        Assert.assertTrue(ShoppingCartFunc.isNoItemsLabelDisplayed(), "=== All items not removed from Cart ===");
        System.out.println("=== CHECKPOINT: All items removed from Cart ===");
        ShoppingCartFunc.closeCart();

        //Add a random men item to cart
        UserFunc.addRandomItemFromMensCategoryToCart(testData.searchCategory1);
        ShoppingCartFunc.verifyCartItemExists(UserFunc.userSelectedCartItemDetails);
        System.out.println("=== CHECKPOINT: New Item Added to Cart Successfully ===");

        //Add a random men item to cart
        UserFunc.addRandomItemFromMensCategoryToCart(testData.searchCategory1);
        ShoppingCartFunc.verifyCartItemExists(UserFunc.userSelectedCartItemDetails);
        System.out.println("=== CHECKPOINT: New Item Added to Cart Successfully ===");

        //Click ‘Secure Checkout’
        ShoppingCartFunc.clickSecureCheckout();
        System.out.println("=== CHECKPOINT: User visited checkout page successfully ===");

        //Verify First and last name in checkout page
        Assert.assertTrue(ShoppingCartFunc.verifyWhetherCorrectUserLoggedIn(testData.verifyUsername), "=== LoggedIn username did not display in Checkout Page ===");
        System.out.println(String.format("=== CHECKPOINT: LoggedIn username displayed correctly (Displayed Name: %s) ===", testData.verifyUsername));
    }

    @Test(description = "Verify whether user cannot continue checkout without filling mandatory fields", priority = 2)
    public void verifyWhetherUserCannotContinueWithoutProvidingMandatoryFields(){
        //Retrieving Test Data for the TestCase
        TCE2E_001_TestData testData = new TCE2E_001_TestData();

        //Navigate to My Account
        UserFunc.getLogin(testData.username, testData.password);
        Assert.assertTrue(UserFunc.verifyWhetherCorrectUserLoggedIn(testData.verifyUsername), "=== LoggedIn username did not display correctly. ===");
        System.out.println(String.format("=== CHECKPOINT: LoggedIn username displayed correctly (Displayed Name: %s) ===", testData.verifyUsername));

        //Clean cart
        ShoppingCartFunc.cleanCart();

        //Validating whether all items removed
        ShoppingCartFunc.openCart();
        Assert.assertTrue(ShoppingCartFunc.isNoItemsLabelDisplayed(), "=== All items not removed from Cart ===");
        System.out.println("=== CHECKPOINT: All items removed from Cart ===");
        ShoppingCartFunc.closeCart();

        //Add a random men item to cart
        UserFunc.addRandomItemFromMensCategoryToCart(testData.searchCategory1);
        ShoppingCartFunc.verifyCartItemExists(UserFunc.userSelectedCartItemDetails);
        System.out.println("=== CHECKPOINT: New Item Added to Cart Successfully ===");

        //Click ‘Secure Checkout’
        ShoppingCartFunc.clickSecureCheckout();
        System.out.println("=== CHECKPOINT: User visited checkout page successfully ===");

        //Verify First and last name in checkout page
        Assert.assertTrue(ShoppingCartFunc.verifyWhetherCorrectUserLoggedIn(testData.verifyUsername), "=== LoggedIn username did not display in Checkout Page ===");
        System.out.println(String.format("=== CHECKPOINT: LoggedIn username displayed correctly (Displayed Name: %s) ===", testData.verifyUsername));

        //Click on Continue button function without adding mandatory values
        ShoppingCartFunc.continueCheckout();
        System.out.println("=== CHECKPOINT: User clicks continue without filling mandatory values");

        //Verify whether Required Field error messages available on checkout page
        Assert.assertTrue(ShoppingCartFunc.verifyErrorMessageEnableToSaveShippingInformation() || ShoppingCartFunc.verifyRequiredFieldTextVisibleOnCheckoutPage(), "=== There are no Required Field message(s) ===");
        System.out.println("=== CHECKPOINT: User cannot proceed without mandatory fields ===");
    }

    @Test(description = "Verify whether user can proceed to payment method by filling mandatory fields", priority = 3)
    public void verifyWhetherUserCanProceedToPaymentMethodStepAfterProvidingMandatoryFields(){
        //Retrieving Test Data for the TestCase
        TCE2E_001_TestData testData = new TCE2E_001_TestData();

        //Navigate to My Account
        UserFunc.getLogin(testData.username, testData.password);
        Assert.assertTrue(UserFunc.verifyWhetherCorrectUserLoggedIn(testData.verifyUsername), "=== LoggedIn username did not display correctly. ===");
        System.out.println(String.format("=== CHECKPOINT: LoggedIn username displayed correctly (Displayed Name: %s) ===", testData.verifyUsername));

        //Clean cart
        ShoppingCartFunc.cleanCart();

        //Validating whether all items removed
        ShoppingCartFunc.openCart();
        Assert.assertTrue(ShoppingCartFunc.isNoItemsLabelDisplayed(), "=== All items not removed from Cart ===");
        System.out.println("=== CHECKPOINT: All items removed from Cart ===");
        ShoppingCartFunc.closeCart();

        //Add a random men item to cart
        UserFunc.addRandomItemFromMensCategoryToCart(testData.searchCategory1);
        ShoppingCartFunc.verifyCartItemExists(UserFunc.userSelectedCartItemDetails);
        System.out.println("=== CHECKPOINT: New Item Added to Cart Successfully ===");

        //Click ‘Secure Checkout’
        ShoppingCartFunc.clickSecureCheckout();
        System.out.println("=== CHECKPOINT: User visited checkout page successfully ===");

        //Verify First and last name in checkout page
        Assert.assertTrue(ShoppingCartFunc.verifyWhetherCorrectUserLoggedIn(testData.verifyUsername), "=== LoggedIn username did not display in Checkout Page ===");
        System.out.println(String.format("=== CHECKPOINT: LoggedIn username displayed correctly (Displayed Name: %s) ===", testData.verifyUsername));

        //Add values Post code 2000 and click Continue
        ShoppingCartFunc.refreshPage();
        ShoppingCartFunc.fillMandatoryFields("2000", "Address 01", "0779505544");
        ShoppingCartFunc.continueCheckout();
        Assert.assertFalse(ShoppingCartFunc.verifyRequiredFieldTextVisibleOnCheckoutPage(), "=== There are Required Field message(s) ===");
        System.out.println("=== CHECKPOINT: User allowed to continue after filling mandatory values");
    }

    @Test(description = "Verify Credit Card field on Checkout page after selecting payment method as credit card", priority = 4)
    public void verifyCCFieldsAreVisibleOnCheckoutPageAfterSelectingPaymentMethodAsCreditCard(){
        //Retrieving Test Data for the TestCase
        TCE2E_001_TestData testData = new TCE2E_001_TestData();

        //Navigate to My Account
        UserFunc.getLogin(testData.username, testData.password);
        Assert.assertTrue(UserFunc.verifyWhetherCorrectUserLoggedIn(testData.verifyUsername), "=== LoggedIn username did not display correctly. ===");
        System.out.println(String.format("=== CHECKPOINT: LoggedIn username displayed correctly (Displayed Name: %s) ===", testData.verifyUsername));

        //Clean cart
        ShoppingCartFunc.cleanCart();

        //Validating whether all items removed
        ShoppingCartFunc.openCart();
        Assert.assertTrue(ShoppingCartFunc.isNoItemsLabelDisplayed(), "=== All items not removed from Cart ===");
        System.out.println("=== CHECKPOINT: All items removed from Cart ===");
        ShoppingCartFunc.closeCart();

        //Add a random men item to cart
        UserFunc.addRandomItemFromMensCategoryToCart(testData.searchCategory1);
        ShoppingCartFunc.verifyCartItemExists(UserFunc.userSelectedCartItemDetails);
        System.out.println("=== CHECKPOINT: New Item Added to Cart Successfully ===");

        //Add a random men item to cart
        UserFunc.addRandomItemFromMensCategoryToCart(testData.searchCategory2);
        ShoppingCartFunc.verifyCartItemExists(UserFunc.userSelectedCartItemDetails);
        System.out.println("=== CHECKPOINT: New Item Added to Cart Successfully ===");

        //Click ‘Secure Checkout’
        ShoppingCartFunc.clickSecureCheckout();
        System.out.println("=== CHECKPOINT: User visited checkout page successfully ===");

        //Verify First and last name in checkout page
        Assert.assertTrue(ShoppingCartFunc.verifyWhetherCorrectUserLoggedIn(testData.verifyUsername), "=== LoggedIn username did not display in Checkout Page ===");
        System.out.println(String.format("=== CHECKPOINT: LoggedIn username displayed correctly (Displayed Name: %s) ===", testData.verifyUsername));


        //Add values Post code 2000 and click Continue
        ShoppingCartFunc.refreshPage();
        ShoppingCartFunc.fillMandatoryFields("2000", "Address 01", "0779505544");
        ShoppingCartFunc.continueCheckout();
        Assert.assertFalse(ShoppingCartFunc.verifyRequiredFieldTextVisibleOnCheckoutPage(), "=== There are Required Field message(s) ===");
        System.out.println("=== CHECKPOINT: User allowed to continue after filling mandatory values");

        //Select Payment type CC and validate CC fields 
        ShoppingCartFunc.selectPaymentMethodCreditCard();
        ShoppingCartFunc.verifyCreditCardFieldVisible();
    }
}