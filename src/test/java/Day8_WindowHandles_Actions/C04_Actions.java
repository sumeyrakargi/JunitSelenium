package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C04_Actions extends BaseTest {

    @Test
    public void dragAndDropOffset(){

        driver.get("https://rangeslider.js.org/");
        //Slider locate ediliyor
        WebElement slider= driver.findElement(By.xpath("(//div[@class='rangeslider__handle'])[1]"));
        Actions action=new Actions(driver);

        action.dragAndDropBy(slider,-400,0).perform();

    }
}
