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

public class C02_Dropdown {
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
    public void selectByIndex(){

        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //DropDown locate edildi
        WebElement drpDown=driver.findElement(By.name("country"));
        //locate edilen dropdown select objesine dönüştürüldü
        Select select=new Select(drpDown);
        select.selectByIndex(1);//ALGERIA

        //selctByIndex()methodu 0 ile başlar


    }
    @Test
    public void selectByValue(){

        driver.get("https://demo.guru99.com/test/newtours/register.php");

        //Dropdown locate edildi
        WebElement drpDown = driver.findElement(By.name("country"));

        //Locate edilen dropdown select objesine donusturuldu
        Select select = new Select(drpDown);

        select.selectByValue("TURKEY");}

    @Test
    public void selectByVisibleText(){

        driver.get("https://demo.guru99.com/test/newtours/register.php");

        //Dropdown locate edildi
        WebElement drpDown = driver.findElement(By.name("country"));

        //Locate edilen dropdown select objesine donusturuldu
        Select select = new Select(drpDown);
        select.selectByVisibleText("NEPAL");

    }
    @Test
    public void multipleSelect(){

        driver.get("https://output.jsbin.com/osebed/2");

        //Dropdown locate ediliyor
        Select select = new Select(driver.findElement(By.id("fruits")));

        System.out.println(select.isMultiple());

        select.selectByValue("apple");
        select.selectByIndex(3);  //Grape

    }

    @Test
    public void getOptions(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        Select select = new Select(driver.findElement(By.name("country")));

        // getOptions() metodu select elementinin tum seceneklerini (optionlarini) bir liste icerisinde bize verir
        List<WebElement> options = select.getOptions();


        for(WebElement option : options){
            System.out.println(option.getText());
        }
    }

    @Test
    public void getFirstSelectedOption() {

        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));

        select.selectByIndex(3); //Grape
        select.selectByIndex(2); //Orange

        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println(selectedOption.getText());

        //getFirstSelectedOption() metodu secili olan ilk option elementini bize verir. (Sectigimiz ilk option degil !!!)

    }
    @Test
    public void getAllSelectedOptipns()  {
        Select select = new Select(driver.findElement(By.id("fruits")));

        select.selectByValue("banana");
        select.selectByValue("apple");
        List<WebElement>selectedOptions=select.getAllSelectedOptions();
        selectedOptions.forEach(x-> System.out.println(x.getText()));
    }




    }
