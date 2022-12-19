package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Queue;

public class C01_WebDriverManagerTest {
    // Set Path.
    // Create chrome driver.
    // Maximize the window.
    // Open google home page https://www.google.com/
    // Verify that you are Google in the title.
    public static void main(String[] args) throws InterruptedException {

       //Webdriver Manager classını kullanarak driver binarylerimizi indirdik
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //Windowu maksimize ettik
        driver.manage().window().maximize();
        //google sayfamızı açtık
        driver.get("https://www.google.com");

        String title=driver.getTitle();

        if(driver.getTitle().equalsIgnoreCase("Google")){
            System.out.println("test passed");
        } else System.out.println("test failed");

        Thread.sleep(5000);

        driver.quit();

    }
}
