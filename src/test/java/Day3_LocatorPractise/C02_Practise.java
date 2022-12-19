package Day3_LocatorPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Practise {
    //    Create the driver with BeforeClass and make it static inside the class.
    //    Go to http://www.google.com
    //    Type "Green Mile" in the search box and print the number of results.
    //    Type "Premonition" in the search box and print the number of results.
    //    Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
    //    Close with AfterClass.

     static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Before
    public void BeforeEach(){
        driver.get("http://www.google.com");
    }
    @AfterClass
    public static void closeDriver() {
        //driver.quit();

    }
    @Test
    public void test(){

        WebElement search= driver.findElement(By.name("q"));
        search.sendKeys("Green Mile"+ Keys.ENTER);
        WebElement results= driver.findElement(By.id("result-stats"));
        System.out.println(results.getText());
    }
    @Test
    public void test02() {
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Premonition" + Keys.ENTER);
        WebElement results = driver.findElement(By.id("result-stats"));
        System.out.println(results.getText());
    }

    //Yaklaşık 12.600.000 sonuç bulundu (0,42 saniye)
    @Test
    public void test03 () {
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);
        WebElement results = driver.findElement(By.id("result-stats"));
        System.out.println(results.getText());
        //Yaklaşık 5.610.000 sonuç bulundu (0,38 saniye)
        }
    }