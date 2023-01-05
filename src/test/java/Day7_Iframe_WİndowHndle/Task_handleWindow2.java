package Day7_Iframe_WİndowHndle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;
 /* Go to URL: https://demoqa.com/browser-windows
    Click on the windows - "WindowButton"
    Click on all the child windows.
    Print the text present on all the child windows in the console.
    Print the heading of the parent window in the console.*/

public class Task_handleWindow2 extends BaseTest {

    @Test
    public void test(){
        driver.get("https://demoqa.com/browser-windows");
        String homepage = driver.getWindowHandle();
        //Click on the windows - "WindowButton"
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();
        //Click on all the child windows.
        driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
        //Print the text present on all the child windows in the console.

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        while (iterator.hasNext()){
            driver.switchTo().window(iterator.next());
            if(driver.getWindowHandle().equals(homepage)){
                continue;
            }
            WebElement text = driver.findElement(By.xpath("//*[text()]"));
            System.out.println(text.getText());
            //Print the heading of the parent window in the console.
            driver.switchTo().window(homepage);
            System.out.println(driver.getTitle());


        }
}}
