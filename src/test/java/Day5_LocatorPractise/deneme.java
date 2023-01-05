package Day5_LocatorPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class deneme {
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
            public  void test(){
    driver.navigate().to("https://demoqa.com/radio-button");
    List<WebElement> radioLabels = driver.findElements(By.className("custom-control-label"));
    List<WebElement> radioButtons = driver.findElements(By.xpath("//*[@type='radio']"));
        for (int i = 0; i < radioButtons.size(); i++) {
        radioLabels.get(i).click();
        System.out.println(radioButtons.get(i).isSelected()? "seçildi" : "SEÇİLMEDİ!!!");
        WebElement text = driver.findElement(By.className("text-success"));
        System.out.println("text.getText() = " + text.getText());
    }}
}
