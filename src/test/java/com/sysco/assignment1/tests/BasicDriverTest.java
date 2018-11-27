package com.sysco.assignment1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicDriverTest {

    public WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.theathletesfoot.com.au");
    }

    @Test
    public void validatePaymentTypeCCFields(){
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("williamjacob802@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).clear();
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("0okmNHY6");
        driver.findElement(By.id("send2")).click();

        String welcomeNote = driver.findElement(By.xpath("//li[@class=\"greet welcome\"]")).getText();
        Assert.assertEquals(welcomeNote, "WILLIAM JACOB");

        driver.findElement(By.className("minicart-wrapper")).click();

        Boolean flag;
        try{
            flag = driver.findElement(By.xpath("//div[@class='minicart-wrapper']//span[@class='value']")).isDisplayed();
        }catch (NoSuchElementException ex){
            flag = false;
        }

        if (flag) {
            int cartItems = driver.findElements(By.xpath("//a[@title='Remove item']")).size();
            for(int i=0; i<cartItems; i++){

                driver.findElement(By.xpath("//a[@title='Remove item']")).click();
                driver.findElement(By.xpath("//button/span[text()='OK']/..")).click();
                System.out.println(String.format("Removed Item (%s) from Cart successfully", i+1));
            }
            System.out.println("No more items in the Cart");
            driver.findElement(By.xpath("//div[@class='close']")).click();
        }

        addRandomItemFromCategory("Lifestyle");
        addRandomItemFromCategory("School");


    }

    private void addRandomItemFromCategory(String category){
        driver.findElement(By.xpath("//a[@title='Mens']/..")).click();
        String searchPattern = "//div[contains(@class,'open')]//a[@title='%s']";
        driver.findElement(By.xpath(String.format(searchPattern, category))).click();

        List<WebElement> elements = driver.findElements(By.xpath("//ul[contains(@class,'product-items')]/li//div[contains(@class,'product-item-details')]"));
        Integer selectRandomItemNumber = (int)(Math.random() * (elements.size()-1) + 1);
        elements.get(selectRandomItemNumber).click();

        List<WebElement> availableSizes = driver.findElements(By.xpath("//div[contains(@class,'active')]/div[not(contains(@class,'outofstock'))][contains(@class,'swatch-option')]"));
        Integer selectRandomSizeNumber = (int)(Math.random() * (availableSizes.size()-1) + 1);
        elements.get(selectRandomSizeNumber).click();

        driver.findElement(By.id("product-addtocart-button")).click();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
