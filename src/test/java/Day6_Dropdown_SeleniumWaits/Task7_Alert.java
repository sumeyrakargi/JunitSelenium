package Day6_Dropdown_SeleniumWaits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

/*Go to URL: http://demo.automationtesting.in/Alerts.html
    Click "Alert with OK" and click 'click the button to display an alert box:’
    Accept Alert(I am an alert box!) and print alert on console.
    Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
    Cancel Alert  (Press a Button !)
    Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
    And then sendKeys «BootcampCamp» (Please enter your name)
    Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.*/

public class Task7_Alert extends BaseTest {
    @Test
    public void test(){
        driver.get(" http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//a[@href=\"#OKTab\"]")).click();
        driver.findElement(By.xpath("//button[@class=\"btn btn-danger\"]")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//a[@href=\"#CancelTab\"]")).click();
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        driver.switchTo().alert().dismiss();
        driver.findElement(By.xpath("//a[@href=\"#Textbox\"]")).click();
        driver.findElement(By.xpath("//button[@class=\"btn btn-info\"]")).click();
        driver.switchTo().alert().sendKeys("Sumeyra Yolcu");
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.xpath("//p[@id=\"demo1\"]")).getText());//Hello Sumeyra Yolcu How are you today
    }
}
