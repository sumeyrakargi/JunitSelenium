package Day9_JSEScroll_Cookies_File;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Task1 extends BaseTest {
    @Test
    public void test() throws AWTException {
        /*https://api.jquery.com/ sitesine gidelim
        arama alanina json yazalim
        Enter islemini robot class kullanrak yapalim*/

        driver.get("https://api.jquery.com/");
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("json");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
