package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

import java.lang.reflect.WildcardType;
import java.util.Iterator;
import java.util.Set;

public class C01_WindowHandles extends BaseTest {

    // https://testproject.io/

    // https://blog.testproject.io/
    @Test
    public void test(){
     // Ana sekmemizden testproject zaçıldı
     driver.get("https://testproject.io/");
     //Yeni sekme oluşturuldu
     driver.switchTo().newWindow(WindowType.WINDOW);
     //Yeni pencereden url mizi ziyaret ediyoruz
     driver.get("https://testproject.io");
     driver.quit();

    }
    @Test
    public void newTab(){
        // Ana sekmemizden testproject zaçıldı
        driver.get("https://testproject.io");
        //Yeni bir sekme oluşturuldu
        WebDriver newTab=driver.switchTo().newWindow(WindowType.TAB);
        //Yeni sekmeden amazona gidildi
        newTab.get("http://www.amazon.com/");
        driver.quit();
    }
    @Test
    public void handleWindows() {
        // Ana sekmemizden amazon açıldı
        driver.get("https://www.amazon.com");
        //getWindowHandle() getWindowHandles()
        String homePageHandle=driver.getWindowHandle();
        //Yeni sekme oluşturuldu
        driver.switchTo().newWindow(WindowType.TAB);
        //Yeni sekmemizde amazon tr açıldı
        driver.get("https://www.amazon.com.tr");
        //Yeni pencere oluşturduk.
        driver.switchTo().newWindow(WindowType.WINDOW);
        //Yeni pencerede Google  i açtık
        driver.get("http://www.google.com");

        Set<String> handles=driver.getWindowHandles();
        Iterator<String>i=handles.iterator();
        while(i.hasNext()){
            String currentTab=i.next();
            driver.switchTo().window(currentTab);
            driver.getTitle();
            if(!driver.getWindowHandle().equals(homePageHandle)){
                driver.close();}
        }

    }

}
