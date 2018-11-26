package com.sysco.assignment1.tests;

import com.sysco.assignment1.common.Categories;
import com.sysco.assignment1.functions.ShoppingCartFunc;
import com.sysco.assignment1.functions.UserFunc;
import com.sysco.assignment1.utils.TestBase;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigateToMyAccountTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Checkout - Navigate to My Account");
    }

    @Test
    public void validatePaymentTypeCCFields(){
        //Navigate to My Account
        UserFunc.loadPage();
        UserFunc.getLogin("williamjacob802@gmail.com", "0okmNHY6");
        Assert.assertTrue(UserFunc.verifyWhetherCorrectUserLoggedIn("WILLIAM JACOB"), "=== LoggedIn username did not display correctly. ===");
        System.out.println("=== LoggedIn username displayed correctly ===");

        ShoppingCartFunc.cleanCart();
        //Validating whether all items removed
        ShoppingCartFunc.openCart();
        Assert.assertTrue(ShoppingCartFunc.isNoItemsLabelDisplayed(), "=== All items not removed from Cart ===");
        System.out.println("=== All items removed from Cart ===");

        ShoppingCartFunc.closeCart();
        System.out.println("=== Closed Cart ===");

        UserFunc.addRandomItemFromMensCategoryToCart(Categories.LIFESTYLE);
        UserFunc.addRandomItemFromMensCategoryToCart(Categories.SCHOOL);

        ShoppingCartFunc.verifyCartItemExists();
        UserFunc.quiteDriver();
    }
}