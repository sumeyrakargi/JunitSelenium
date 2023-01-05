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

public class C07_Task {


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
    public void test(){
        //Go to URL: https://demoqa.com/radio-button
        driver.get(" https://demoqa.com/radio-button");
        //Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
        //Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.
        List<WebElement>radioButton=driver.findElements(By.xpath("//label[@class='custom-control-label']"));
        for (int i = 0; i < radioButton.size() ; i++) {
            radioButton.get(i).click();
           if (radioButton.get(i).isSelected()){
               System.out.println("seçildi");
           }else { System.out.println("seçilmedi");}
           WebElement text=driver.findElement(By.xpath("//span[@class='text-success']"));
           System.out.println(text.getText());
        }


    }

}
