package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser","url"})
    void setUpDriver(String browser, String link){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(link);
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void DropDown()throws InterruptedException{
        Thread.sleep(10000);
        Select sl=new Select(driver.findElement(By.xpath("//select[@id='dropdowm-menu-1']")));
        sl.selectByValue("python");

        Select sl2=new Select(driver.findElement(By.id("dropdowm-menu-2")));
        sl2.selectByValue("testng");

        Select sl3=new Select(driver.findElement(By.id("dropdowm-menu-3")));
        sl3.selectByIndex(2);

    }
    @Test(priority = 1)
    public void CheckBox() throws InterruptedException{
//Thread.sleep(10000);
        driver.findElement(By.xpath("//label[normalize-space()='Option 1']")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Option 2']")).click();
// Select sl=new Select(driver.findElement(By.xpath("//label[normalize-space()='Option 3']")));
// sl.deselectByIndex(2);
    }
    @Test(priority = 2)
    public void radioButton()throws InterruptedException{
        WebElement radio_button = driver.findElement(By.cssSelector("input[value='yellow']"));
        radio_button.click();
    }
    @AfterClass
    void close(){
//driver.close();
    }
}


