package Day2.Location;
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

public class C01_Locators {

    WebDriver driver;

    @Before
    public void setup(){

        //Driver olusturuldu
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //sayfanin yuklenmesi beklendi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //LinkedIn sitesine gidildi
        driver.get("https://www.linkedin.com/");

        // driver imiz maximize edildi
        driver.manage().window().maximize();


    }

    @After
    public void tearDown(){

        // driver imiz kapatildi
        driver.quit();
    }

    @Test
    public void idLocator(){
        // id Locator -> "session_key"

        WebElement email = driver.findElement(By.id("session_key"));
        email.sendKeys("Clarusway selenium dersinden selamlar");

    }

    @Test
    public void nameLocator(){
        // name locator -> "session_password"

        WebElement password = driver.findElement(By.name("session_password"));

        password.sendKeys("Sifre");
    }

    @Test
    public void classLocator(){

        // class locator -> "input__input"

        WebElement email = driver.findElement(By.className("input__input"));
        email.sendKeys("Class locator test");
    }

    @Test
    public void tagLocator(){

        // tag locator -> "input"

        List<WebElement> emailList = driver.findElements(By.tagName("input"));


        // 2. elementimiz email text alanimiz. Bu yuzden bu elemani email degiskenine assign ettik.
        WebElement email = emailList.get(1);

        email.sendKeys("Tag locator test");

    }

    @Test
    public void linkTextLocator(){
        // link text -> "Forgot password?"

        WebElement forgotPwd = driver.findElement(By.linkText("Forgot password?"));
        forgotPwd.click();

    }

    @Test
    public void partialLinkTextLocator(){
        // link text -> "Forgot password?"

        WebElement forgotPwd = driver.findElement(By.partialLinkText("Forgot"));
        forgotPwd.click();

    }

    @Test
    public void absoluteXpath(){
        WebElement email = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/div[1]/input"));
        email.sendKeys("Karl absolute xpath konusunu gayet basirili tamamladi");
    }


    @Test
    public void relativeXpath(){
        // xpath locator -> //input[@name='session_key']

        WebElement email = driver.findElement(By.xpath("//input[@name='session_key']"));
        email.sendKeys("Karl relative xpath konusunu gayet basirili tamamladi");
    }
    @Test
    public void multipleAttributeXpath(){
        // xpath locator -> //input[@name='session_key'][@name='session_key]

        WebElement email = driver.findElement(By.xpath("//input[@name='session_key'][@name='session_key]\n"));
        email.sendKeys("Karl relative xpath konusunu gayet basirili tamamladi");
    }
    @Test
    public void AndOrXpath(){
        // xpath locator -> //input[@name='session_key'and @name='session_key']

        WebElement email = driver.findElement(By.xpath("//input[@name='session_key'and @name='session_key']'\n"));
        email.sendKeys("Karl AndOr xpath konusunu gayet basirili tamamladi");
    }
    @Test
    public void containsXpath(){
        // xpath locator -> //input[contains( @id,'session_key')]

        WebElement email = driver.findElement(By.xpath("//input[contains( @id,'session_key')]"));
        email.sendKeys("Karl contains xpath konusunu gayet basirili tamamladi");
    }
    @Test
    public void StartWithXpath(){
        // xpath locator -> //input[starts-with ( @class,'input__input')]

        WebElement email = driver.findElement(By.xpath("//input[starts-with ( @class,'input__input')]"));
        email.sendKeys("Karl contains xpath konusunu gayet basirili tamamladi");
    }
    @Test
    public void textXpath(){
        // xpath locator -> //button[contains(text(),'Oturum açın')]

        WebElement email = driver.findElement(By.xpath("//button[contains(text(),'Oturum açın')]"));
        email.sendKeys("Karl text xpath konusunu gayet basirili tamamladi");
    }


}