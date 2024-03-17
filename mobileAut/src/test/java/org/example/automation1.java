package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class automation1 {
    public AndroidDriver driver;
    @BeforeTest
    public void nopapk() throws MalformedURLException{
        File f = new File("src\\test");
        File apk = new File(f, "nopstationCart_4.40 1.apk");
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("platformName", "android");
            cap.setCapability("udid", "0139a0d51df7");
            cap.setCapability("appium:automationName", "UiAutomator2");
            cap.setCapability("deviceName", "Redmi Note 11 Pro+5G");
            cap.setCapability("appPackage", "com.nopstation.nopcommerce.nopstationcart");
            cap.setCapability("appActivity", "com.bs.ecommerce.main.MainActivity");
            driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        }
    @Test
    public void test_app() throws InterruptedException {
        WebElement el1 = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"NopStation Cart\"]"));
        el1.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement el2 = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Placeholder\"])[3]"));
        el2.click();
        WebElement el3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvProductName\" and @text=\"Mattress Bedroom\"]"));
        el3.click();
        WebElement el4 = driver.findElement(AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/btnAddToCart"));
        el4.click();
        el4.click();
    }
    @AfterTest
    public void closeApp(){
        driver.removeApp("com.nopstation.nopcommerce.nopstationcart");
    }
}