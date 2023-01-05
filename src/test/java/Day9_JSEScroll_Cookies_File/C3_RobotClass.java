package Day9_JSEScroll_Cookies_File;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C3_RobotClass extends BaseTest {

    @Test
    public void test() throws AWTException, InterruptedException {

        driver.get("https://demo.guru99.com/test/upload/");
        WebElement input= driver.findElement(By.xpath("//*[@id=\"uploadfile_0\"]"));
        input.sendKeys("C:\\Users\\seyitbey\\IdeaProjects\\CWJunitSelenium\\src\\test\\java\\resources\\robot.txt");

        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);//keyPress tuşa basılı tutar
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(4000);
        robot.keyRelease(KeyEvent.VK_CONTROL);//keyRelease tuşu serbest bırakırr
        robot.keyRelease(KeyEvent.VK_S);
        Thread.sleep(4000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
}
