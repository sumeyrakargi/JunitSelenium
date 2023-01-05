package Day6_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
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

public class Task4 {
    /*Go to URL: https://opensource-demo.orangehrmlive.com/
    Login with Username: Admin
    Login with Password: admin123
    Click login button
    Click on PIM
    Click on Employee List
    Employee Name -> Use Faker Class
    ID -> Use Faker Class
    Employment Status -> select by index: 2
    Include -> selectByVisibleText: Current and Past Employees
    Supervisor Name -> Use Faker Class
    Job Title ->selectByValue: IT Manager
    Sub Unit ->selectByValue: 3
    Click search button
    Verify text visible : "No Records Found"*/
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
    public void ckeckBox(){

        
       // driver.get("https://Admin:admin123@the-internet.orangehrmlive.com/basic_auth");
        driver.get(" https://opensource-demo.orangehrmlive.com/");
        WebElement userName= driver.findElement(By.xpath("//input[@name=\"username\"]"));
        userName.sendKeys("Admin");
        WebElement passWord= driver.findElement(By.xpath("//input[@name=\"password\"]"));
        passWord.sendKeys("admin123");
        WebElement login= driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        login.click();
        WebElement pim=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
        pim.click();
        WebElement emplylist=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]/button/i"));
        emplylist.click();
        Faker faker=new Faker();

        WebElement name=driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        name.sendKeys( faker.name().firstName());
        WebElement id=driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input"));
        id.sendKeys( faker.idNumber().valid());
        Select status=new Select(driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div")));
        status.selectByIndex(2);
        Select include=new Select(driver.findElement(By.linkText("Include")));
        include.selectByVisibleText("Current and Past Employees");
        WebElement superName=driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"][2]"));
        superName.sendKeys(faker.name().name());
        Select job = new Select(driver.findElement(By.xpath("By.linkText(\"job Title\")")));
        job.selectByValue("IT Manager");









    }


}
