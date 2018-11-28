package com.sysco.assignment1.tests.dataProviders;

import com.sysco.assignment1.common.Categories;
import org.testng.annotations.DataProvider;

public class CartDataProvider {
        @DataProvider(name="SearchCategory")
        public static Object[][] getDataFromDataprovider() {
            return new Object[][]{
                    {Categories.SCHOOL},
                    {Categories.LIFESTYLE},
                    {Categories.OUTDOOR}
            };
        }
}
