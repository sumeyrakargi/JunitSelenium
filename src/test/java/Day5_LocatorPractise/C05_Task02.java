package Day5_LocatorPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_Task02 {
    WebDriver driver;
    @Before
    public void setup(){
        //Driver ile ilgili her turlu initial(baslangic) islemi burada yapilir
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        // test sonrasinda driver kapatmak (varsa raporlari dosyalamak) icin kullanilir.
        driver.quit();
    }
    @Test
    public void ckeckBox(){

        //    Go to URL: https://demoqa.com/
        driver.get("https://demoqa.com/");
        //    Click on Elements.
        List<WebElement> element=driver.findElements(By.xpath("//div[@class=\"card mt-4 top-card\"]"));
        element.get(0).click();
        // Click on Checkbox.
        List<WebElement>checkbox=driver.findElements(By.xpath("//span[@class=\"text\"]"));
        checkbox.get(1).click();
        //    Verify if Home checkbox is selected.
        WebElement home=driver.findElement(By.xpath("//span[@class=\"rct-checkbox\"]"));
        if (!home.isSelected()){
            home.click();
        }
        Assert.assertTrue(home.isDisplayed());
        //    Verify that "You have selected" is visible
        WebElement result=driver.findElement(By.xpath("//*[@id=\"result\"]/span[1]"));
        Assert.assertTrue(result.isDisplayed());
        System.out.println(result.getText());
    }



    }
