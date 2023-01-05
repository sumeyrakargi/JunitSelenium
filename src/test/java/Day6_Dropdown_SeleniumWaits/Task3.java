package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Task3 {
    /* https://demoqa.com/select-menu sitesine gidin
     - multiple <select> elementini locate edin
      - getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
    * Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin*/
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
        //driver.quit();
    }
    @Test
    public void getOption() {
        driver.get("https://demoqa.com/select-menu");
        Select select = new Select(driver.findElement(By.name("cars")));
        select.selectByIndex(0);
        select.selectByValue("saab");
        System.out.println(select.getAllSelectedOptions().get(1).getText());
        select.deselectByIndex(0);

        List<WebElement> options=select.getOptions();
        Assert.assertEquals(options.get(1), select.getFirstSelectedOption());

        select.selectByIndex(3);
        List <WebElement> allselected=select.getAllSelectedOptions();
        allselected.forEach(x-> System.out.println(x.getText()));
        Assert.assertTrue(allselected.get(0).getText().contains("Saab"));

        }


    }

