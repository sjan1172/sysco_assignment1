package com.sysco.assignment1.functions;

import com.sysco.assignment1.common.Constants;
import com.sysco.assignment1.common.ElementStatus;
import com.sysco.assignment1.common.Messages;
import com.sysco.assignment1.models.CartItem;
import com.sysco.assignment1.pages.AUTLandingPage;
import com.sysco.assignment1.pages.AUTLoginPage;
import com.sysco.assignment1.pages.SecureCheckoutPage;
import com.sysco.assignment1.pages.ShoppingCartPage;
import com.sysco.assignment1.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

/**
 * Created by Shiyam Jannan on 11/21/18.
 */
public class ShoppingCartFunc {

    public static AUTLandingPage autLandingPage = new AUTLandingPage();
    public static AUTLoginPage autLoginPage = new AUTLoginPage();
    public static ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    public static SecureCheckoutPage secureCheckoutPage = new SecureCheckoutPage();


    /**
     * Created By: Shiyam Jannan
     * Inputs: N/A
     * Output: true/false
     * Purpose: This method returns flase if values shown near card icon.
     * Else returns false.
     */
    public static Boolean isCartEmpty(){
        if(!autLandingPage.isCartItemsCountDisplayed()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Created By: Shiyam Jannan
     * Inputs: N/A
     * Output: true/false
     * Purpose: This method returns true if values shown near card icon.
     * Else returns false.
     */
    public static void cleanCart() {
        if (!isCartEmpty()) {
            openCart();
            int cartItems = shoppingCartPage.getCartItemCount();
            for(int i=0; i<cartItems; i++){

                shoppingCartPage.clickCloseItem();
                shoppingCartPage.clickOKModelWindow();
                System.out.println(String.format("Removed Item (%s) from Cart successfully", i+1));
            }
            System.out.println("No more items in the Cart");
        }
    }

    public static Boolean isNoItemsLabelDisplayed(){
        return shoppingCartPage.getNoItemsInCartText().equals(Messages.CART_NO_ITEMS);
    }

    /**
     * Created By: Shiyam Jannan
     * Inputs: N/A
     * Output: N/A
     * Purpose: Opens cart. Skip if already opened.
     */
    public static void openCart() {
        if(shoppingCartPage.isPanelHidden()){
            autLandingPage.clickCart();
            System.out.println("Cart Opened");
        }
    }

    /**
     * Created By: Shiyam Jannan
     * Inputs: N/A
     * Output: N/A
     * Purpose: Close cart. Skip if already closed.
     */
    public static void closeCart() {
        if(!shoppingCartPage.isPanelHidden()){
            shoppingCartPage.clickOnCloseIcon();
            System.out.println("Cart Closed");
        }
    }

    public static void getCartItemsCount() {
        if(!shoppingCartPage.isPanelHidden()){
            shoppingCartPage.clickOnCloseIcon();
            System.out.println("Cart Closed");
        }
    }

    public static void verifyCartItemExists(CartItem userSelectedCartItemDetails) {
        openCart();
        boolean itemFound = false;
        int latestCartItems = shoppingCartPage.getCartItemCount();
        for (int i=0; i<latestCartItems; i++){
            if(shoppingCartPage.getCartItemNameByIndex(i).equals(userSelectedCartItemDetails.getItemName())
                    && shoppingCartPage.getCartItemPriceByIndex(i).equals(userSelectedCartItemDetails.getItemPrice())){
                itemFound = true;
            }
        }
        Assert.assertTrue(itemFound, "Selected Item does not exists in the Cart (ITEM NAME | ITEM PRICE)");
        System.out.println(String.format("Selected Item does not exists in the Cart (ITEM NAME: %s | ITEM PRICE: %s)",
                userSelectedCartItemDetails.getItemName(), userSelectedCartItemDetails.getItemPrice()));
        closeCart();
    }

    public static void clickSecureCheckout(){
        openCart();
        shoppingCartPage.clickProceedToCheckout();
        closeCart();
    }

    public static boolean verifyWhetherCorrectUserLoggedIn(String expectedText){
        if(expectedText.equals(secureCheckoutPage.getLoggedInUserGeetingText())){
            return true;
        }
        else{
            return false;
        }
    }

    public static void continueCheckoutWithoutFillingAnyFields(){
        secureCheckoutPage.clickContinue();
    }

    public static void continueCheckoutFillingMandatoryData(String postalCode, String address1, String phoneNumber){
        secureCheckoutPage.enterPostalCode(postalCode);
        secureCheckoutPage.pause(2000);
        secureCheckoutPage.enterAddressLine1(address1);
        secureCheckoutPage.enterPhoneNumber(phoneNumber);
        secureCheckoutPage.clickContinue();
        secureCheckoutPage.pause(5000);
    }

    public static void selectPaymentMethodCreditCard(){
        secureCheckoutPage.selectCreditCardOption();
    }

    public static void verifyCreditCardFieldVisible(){
        Assert.assertTrue(secureCheckoutPage.isCreditCardNumberFieldVisible(), "=== Credit Card Number field not visible! ===");
        System.out.println("=== Credit Card Number field is visible! ===");

        Assert.assertTrue(secureCheckoutPage.isCreditCardCVVFieldVisible(), "=== Credit Card CVV field not visible! ===");
        System.out.println("=== Credit Card CVV field is visible! ===");
    }
}
