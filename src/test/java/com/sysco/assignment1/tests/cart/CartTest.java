package com.sysco.assignment1.tests.cart;

import com.sysco.assignment1.tests.dataProviders.CartDataProvider;
import com.sysco.assignment1.functions.ShoppingCartFunc;
import com.sysco.assignment1.functions.UserFunc;
import com.sysco.assignment1.utils.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CartTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Online Shopping - Checkout");
    }

    @Test(description = "Verify whether user able to clean cart fully")
    public void verifyWhetherUserCanCleanCartFully(){
        //Clean cart
        ShoppingCartFunc.cleanCart();

        //Validating whether all items removed
        ShoppingCartFunc.openCart();
        Assert.assertTrue(ShoppingCartFunc.isNoItemsLabelDisplayed(), "=== All items not removed from Cart ===");
        System.out.println("=== All items removed from Cart ===");
        ShoppingCartFunc.closeCart();
    }

    @Test(description = "Verify whether user able to add an item from Mens Catetory", dataProvider="SearchCategory", dataProviderClass= CartDataProvider.class)
    @Parameters("categoryName")
    public void verifyWhetherUserCanAddItemFromMensCategoryToCart(String categoryName){
        UserFunc.addRandomItemFromMensCategoryToCart(categoryName);
        ShoppingCartFunc.verifyCartItemExists(UserFunc.userSelectedCartItemDetails);
    }
}