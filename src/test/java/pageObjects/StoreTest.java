package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class StoreTest extends BaseClass {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setup() throws MalformedURLException {

        driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void validInputs() throws MalformedURLException {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        //click the dropdown, the list gets populated
        driver.findElement(By.id("android:id/text1")).click();
        //scroll through the list and select the "Argentina" text
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Australia\"))");

        driver.findElement(By.xpath("//*[@text='Australia']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }

   @Test
    public void ValidationOnName() {
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        //click the dropdown, the list gets populated
        driver.findElement(By.id("android:id/text1")).click();
        //scroll through the list and select the "Argentina" text
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Australia\"))");
        driver.findElement(By.xpath("//*[@text='Australia']")).click();

        //validation on "Your Name"
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        //toast will always hold the value in "name" attribute
        String toastValue = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
        System.out.println(toastValue);
        Assert.assertEquals("Please enter your name", toastValue);
    }

}
