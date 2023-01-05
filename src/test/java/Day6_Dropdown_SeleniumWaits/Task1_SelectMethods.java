package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Task1_SelectMethods {
    /* - https://demoqa.com/select-menu sitesine gidin
       - <select> elementini locate edin
       - <select> elementinin seceneklerini yazdirin
       - Sirasiyla selectByIndex, selectByValue, selectByVisibleText methodlarini kullanarak;
    * Yellow (index)
    * Purple (value)
    * Black  (text)
    seceneklerini secin*/

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
    public void selectMeth(){
        driver.get("https://demoqa.com/select-menu");
        //<select> elementi locate edildi
        Select selectMenu=new Select(driver.findElement(By.id("oldSelectMenu")));
        List<WebElement> options = selectMenu.getOptions();
        //seçenekler yazdırıldı
        for(WebElement option : options) {
            System.out.println(option.getText());
        }
        //Belirtilen seçenekler istenilen metodlar ile seçildi
        selectMenu.selectByIndex(3);
        selectMenu.selectByValue("4");
        selectMenu.selectByVisibleText("Black");
 }

    }
