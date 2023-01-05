package Day9_JSEScroll_Cookies_File;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.BaseTest;

import java.util.Set;

public class Task2 extends BaseTest {
    @Test
    public void test(){
        /*Go to URL: http://facebook.com
        getCookies,
                addCookie,
                deleteCookieNamed,
                deleteAllCookies*/

        driver.get("http://facebook.com");
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println(allCookies.size());//4

        Cookie cookie=new Cookie("mycookie","suarch");
        driver.manage().addCookie(cookie);
        allCookies=driver.manage().getCookies();
        System.out.println(allCookies.size());//5

        driver.manage().deleteCookieNamed("mycookie");
        allCookies=driver.manage().getCookies();
        System.out.println(allCookies.size());//4

        driver.manage().deleteAllCookies();
        allCookies=driver.manage().getCookies();
        System.out.println(allCookies.size());//0


    }
}
