package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class deneme extends BaseTest {
    @Test
    public void test(){
        driver.get("http://www.tradingview.com");
        WebElement bul=driver.findElement(By.xpath("//*[@id=\"tv-content\"]/div[1]/div[1]/div[2]/div[1]/div/button"));
        bul.click();
        driver.findElement(By.xpath("//input[@name=\"query\"]")).sendKeys("KTSKR");

        driver.findElement(By.xpath("//*[@id=\"overlap-manager-root\"]/div/div/div[2]/div/div/div[1]/div/div[2]/div/div[4]/div/div")).click();

    }
    @Test
    public void test2(){
        driver.get("http://www.google.com");
        WebElement ara=driver.findElement(By.xpath("//input[@class=\"gLFyf\"]"));
        Actions action=new Actions(driver);
        action.click(ara).keyDown(Keys.SHIFT).sendKeys("n").keyUp(Keys.SHIFT).sendKeys("asılsın"+Keys.ENTER).build().perform();


    }
}
