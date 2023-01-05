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

public class Task2_MultipleSelected {

     /*- https://demoqa.com/select-menu sitesine gidin
     - Multiple select yapabileceginiz <select> elementini locate edin
     - Birden fazla secim yapip secimlerinizi DOGRULAyin*/

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
    public void multipleSelect(){
        driver.get("https://demoqa.com/select-menu");
        //Multiple select yapabileceginiz <select> elementini locate edildi
        Select mltplslct=new Select(driver.findElement(By.name("cars")));
        System.out.println(mltplslct.isMultiple());
        // Birden fazla secim yapildı
        mltplslct.selectByVisibleText("Volvo");
        mltplslct.selectByIndex(3);
        List<WebElement> selectedOptions = mltplslct.getAllSelectedOptions();
        //seçilen seçenekler yazdırılarak doğrulandı
        for(WebElement option : selectedOptions) {
            System.out.println(option.getText());
    }}

}



