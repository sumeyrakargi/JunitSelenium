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
//https://id.heroku.com/login sayfasına gidiniz.
//Bir mail adresi giriniz.
//Bir password giriniz.
//Login butonuna tıklayınız.
//"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
//Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
//Tüm sayfaları kapatınız.

public class Task {


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager .chromedriver().setup();
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

        driver.get("https://id.heroku.com/login");

        WebElement email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
        email.sendKeys("www.sumeyrayolcu@windowslive.com");

        WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        password.sendKeys("1111111");

        WebElement button = driver.findElement(By.cssSelector("button[name='commit']"));
        button.click();

        WebElement alert = driver.findElement(By.xpath("//div[@role=\"alert\"]"));

        if (alert.getText().contains("There was a problem")) {
            System.out.println("Kayıt Yapılamadı");
        }else System.out.println("Kayıt Yapıldı");
    }

}
