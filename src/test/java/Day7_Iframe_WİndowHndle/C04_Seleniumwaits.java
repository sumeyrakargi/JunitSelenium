package Day7_Iframe_WİndowHndle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTest;

import java.time.Duration;

public class C04_Seleniumwaits extends BaseTest {
    //Explicit wait

    @Test
    public void webDriverWait() {

        driver.get("https://demoqa.com/interaction");

        // Adim 1 -> Webdriverwait objemiz olusturuldu
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        WebElement category = driver.findElement(By.xpath("(//div[@class='icon'])[2]"));


        //elementToBeClickable(Webelement)
        wait.until(ExpectedConditions.elementToBeClickable(category)).click();


        //elementToBeClickable(By)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'Practice Form')]"))).click();
    }

}
