package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03 {
    //    Go to Amazon homepage.
//    Do the following tasks by creating 3 different test methods.
//    1- Test if the URL contains Amazon.
//    2- Test if the title does not contain Facebook.
//    3- Test that the Amazon logo appears in the upper left corner.

//    assertEquals
//    assertTrue
//    assertFalse
//    assertNull
//    assertNotNull
//    assertSame
//    assertNotSame
//    assertArrayEquals

    WebDriver driver;

    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void after(){
        driver.quit();
    }

    @Test
    public void URLTest(){
        driver.get("https://www.amazon.com/");
        String currentUrl = driver.getCurrentUrl();

        // URL amazon kelimesini iceriyor mu kontrol saglaniyor
        Assert.assertTrue("URL 'amazon' icermiyor", currentUrl.contains("Amazon"));
    }

    @Test
    public void titleTest(){
        driver.get("https://www.amazon.com/");
        String title = driver.getTitle();
        Assert.assertFalse(title.contains("Facebook"));

    }

    //TO BE CONTINUED


}
