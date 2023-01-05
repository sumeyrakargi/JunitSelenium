package Day6_Dropdown_SeleniumWaits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
/*Go to URL: http://demo.guru99.com/test/guru99home/
        Find the number of iframes on the page.
        Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
        Exit the iframe and return to the main page.*/


public class Task8_Iframe extends BaseTest {
    @Test
    public void test(){
        //Go to URL: http://demo.guru99.com/test/guru99home/
        driver.get("http://demo.guru99.com/test/guru99home/");
        String homePageId = driver.getWindowHandle();
        //Find the number of iframes on the page.
        List<WebElement> iframe=driver.findElements(By.xpath("//iframe"));
        System.out.println(iframe.size());
        //Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
        driver.switchTo().frame("a077aa5e");//driver.switchTo().frame(4);-->bu şekilde denedim olmadı
        driver.findElement(By.xpath("//img[@src=\"Jmeter720.png\"]")).click();
        //Exit the iframe and return to the main page.]
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        while (iterator.hasNext()){
            driver.switchTo().window(iterator.next());
            if(driver.getWindowHandle().equals(homePageId)){
                continue;
            }driver.close();



    }}
}
