package Day9_JSEScroll_Cookies_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.BaseTest;

import java.util.Set;

public class C4_Cookies extends BaseTest {

    /*Go to URL: https://kitchen.applitools.com/ingredients/cookie
    Get Cookie.
    Find the total number of cookies.
    Print all the cookies.
    Add Cookie.
    Edit Cookie.
    Delete Cookie.
    Delete All Cookies.*/

    @Test
    public void test(){
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        System.out.println("test get cookies");
        Cookie cookie=driver.manage().getCookieNamed("protein");//cookie yi isimle çağırdık
        Assert.assertEquals("chicken",cookie.getValue());

        //Find the total number of cookies.
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies = allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies);
        //Print all the cookies.
        for (Cookie w:allCookies){
            System.out.println("each cookies" +w);
            System.out.println("each cookie name = "+w.getName());}

        //Add cookies
        System.out.println("Add cookies");
        Cookie cookie1=new Cookie("fruit","apple");
        driver.manage().addCookie(cookie1);
        Assert.assertEquals(cookie1.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());

        allCookies=driver.manage().getCookies();// sayfada var olan cookileri döndürür
        System.out.println(allCookies.size());
        //Edit cookie
        System.out.println("edit cookie");

        Cookie cookieEdit=new Cookie(cookie1.getName(),"mango");
        driver.manage().addCookie(cookieEdit);
        Assert.assertEquals(cookieEdit.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());
        System.out.println(driver.manage().getCookieNamed(cookie1.getName()).getValue());

        allCookies=driver.manage().getCookies();// sayfada var olan cookileri döndürür
        System.out.println(allCookies.size());

    }
    @Test
    public void deleteCookies() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies = allCookies.size();

        System.out.println("numOfCookies = " + numOfCookies); //numOfCookies = 2

        Cookie addedCookie = new Cookie("drinks", "ayran"); //cookie olusturduk
        driver.manage().addCookie(addedCookie); //cookie ekledik

        allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
        System.out.println("allCookies = " + allCookies.size()); //allCookies = 3

        System.out.println("delete cookies");
        driver.manage().deleteCookie(addedCookie); // cookie sildik
        Assert.assertNull("cookie halen var", driver.manage().getCookieNamed(addedCookie.getName())); //PASSED

        allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
        System.out.println("allCookies = " + allCookies.size()); //allCookies = 2

        driver.manage().deleteAllCookies(); //browserdan hepsi sildik
        allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
        System.out.println("allCookies = " + allCookies.size()); // allCookies = 0
    }

    }

