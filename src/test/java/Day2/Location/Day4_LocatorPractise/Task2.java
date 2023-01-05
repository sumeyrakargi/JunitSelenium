package Day2.Location.Day4_LocatorPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task2 {
    //Navigate to https://testpages.herokuapp.com/styled/index.html
    // Click on Calculate under Micro Apps.
    // Type any number in the first input.
    // Type any number in the second input.
    // Click on Calculate.
    // Get the result.
    // Print the result.
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test(){

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement calculator= driver.findElement(By.xpath("//a[@id=\"calculatetest\"]"));
        calculator.click();
        WebElement fisrInput= driver.findElement(By.xpath("//input[@id=\"number1\"]"));
        fisrInput.sendKeys("24");
        WebElement secondInput= driver.findElement(By.xpath("//input[@id=\"number2\"]"));
        secondInput.sendKeys("16");
        WebElement calculate= driver.findElement(By.xpath("//input[@id=\"calculate\"]"));
        calculate.click();
        WebElement result= driver.findElement(By.xpath("//span[@id=\"answer\"]"));
        System.out.println("result = " + result.getText());

    }




}
