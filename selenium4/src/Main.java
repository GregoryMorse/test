import static org.junit.Assert.*;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class Main {
    static WebDriver driver;
    static Wait<WebDriver> wait;

    @Test
    public void mainTest() {
        System.setProperty("webdriver.chrome.driver", "c:/Users/morse/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);


        boolean result;
        try {
            //googleCalculatorTest("3 + 2","5");
            //googleCalculatorTest("3 * 2","6");
            //googleCalculatorTest("12 + 12","24");
            firstTest();
        } catch(Exception e) {
            fail(e.getMessage());
        } finally {
            driver.close();
        }
    }

    private static void googleCalculatorTest(String expression, String expected) {
        driver.get("http://google.com");
        WebElement searchBarElement = driver.findElement(By.id("lst-ib"));
        searchBarElement.sendKeys(expression);
        searchBarElement.sendKeys(Keys.RETURN);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cwos")));

        assertEquals(element.getText(),expected);
    }

    //Run->Edit Configurations->Add selenium1-4 with respective .gradle project files, and build command
    //in C:\Users\<userprofile>\.gradle\gradle.properties -> org.gradle.java.home=C:/Program Files (x86)/Java/jdk1.8.0_121
    private static void firstTest()
    {
        driver.get("http://selenium.thinkcode.se/helloWorld");
        WebElement el = driver.findElement(By.id("headline"));
        assertEquals(el.getText(), "Hello, world!");

        driver.get("http://selenium.thinkcode.se/requestPassword");
        el = driver.findElement(By.id("account"));
        el.sendKeys("test");
        //el.sendKeys(Keys.RETURN);
        driver.findElement(By.name("submit")).click();

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation")));

        assertEquals(element.getText(), "A new password has been sent to test");
    }

}
