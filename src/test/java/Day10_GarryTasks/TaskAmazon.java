package Day10_GarryTasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.util.List;

public class TaskAmazon extends BaseTest {
    /*https://www.amazon.com.tr/ sitesi açılır.
    - Ana sayfanın açıldığı kontrol edilir.
    - Çerez tercihlerinden Çerezleri kabul et seçilir.
    - Siteye login olunur.
    - Login işlemi kontrol edilir.
    - Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
    - Bilgisayar kategorisi seçildiği kontrol edilir.
    - Arama alanına MSI yazılır ve arama yapılır.
    - Arama yapıldığı kontrol edilir.
    - Arama sonuçları sayfasından 2. sayfa açılır.
    - 2. sayfanın açıldığı kontrol edilir.
    - Sayfadaki 2. ürün favorilere eklenir.
    - 2. Ürünün favorilere eklendiği kontrol edilir.
    - Hesabım > Favori Listem sayfasına gidilir.
    - “Favori Listem” sayfası açıldığı kontrol edilir.
    - Eklenen ürün favorilerden silinir.
    - Silme işleminin gerçekleştiği kontrol edilir.
    - Üye çıkış işlemi yapılır.
    - Çıkış işleminin yapıldığı kontrol edilir.*/
     @Test
    public void testAmazon(){
    //https://www.amazon.com.tr/ sitesi açılır.
    driver.get("https://www.amazon.com.tr/");
    Actions act=new Actions(driver);
    //Ana sayfanın açıldığı kontrol edilir.
    Assert.assertTrue(driver.getCurrentUrl().contains("amazon.com"));
    //Çerez tercihlerinden Çerezleri kabul et seçilir.
    WebElement cookie=driver.findElement(By.name("accept"));
    cookie.click();
    //Siteye login olunur.
    driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
    WebElement login=driver.findElement(By.xpath("//input[@type=\"email\"]"));
    login.sendKeys(email+ Keys.ENTER);
    WebElement password=driver.findElement(By.xpath("//input[@type=\"password\"]"));
    password.sendKeys(şifre+ Keys.ENTER);
    //Login işlemi kontrol edilir.
    Assert.assertTrue(driver.findElement(By.xpath("//span[@id=\"nav-link-accountList-nav-line-1\"]")).getText().contains("sumeyra"));
    //Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
    Select select=new Select(driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]")));
    select.selectByVisibleText("Bilgisayarlar");
    //Bilgisayar kategorisi seçildiği kontrol edilir.
    driver.findElement(By.xpath(" //option[@value=\"search-alias=computers\"]")).isSelected();
    //Arama alanına MSI yazılır ve arama yapılır.
    WebElement search= driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
    search.sendKeys("MSI"+Keys.ENTER);
    //Arama yapıldığı kontrol edilir.
    Assert.assertTrue(driver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]")).getText().contains("MSI"));
    //Arama sonuçları sayfasından 2. sayfa açılır.
    act.click(driver.findElement(By.xpath("//a[@aria-label=\"2 sayfasına git\"]"))).perform();
    //Sayfadaki 2. ürün favorilere eklenir.
     List<WebElement> searchResult = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
     searchResult.get(1).click();
     driver.findElement(By.xpath("//*[@id=\"add-to-wishlist-button-submit\"]")).click();
     //2. Ürünün favorilere eklendiği kontrol edilir.
     WebElement text=driver.findElement(By.xpath("//*[@id=\"huc-atwl-header-section\"]/div/span[1]"));
     Assert.assertTrue(text.getText().contains("1 ürün şuraya eklendi:"));
     //Hesabım > Favori Listem sayfasına gidilir.
     driver.findElement(By.xpath("//button[@aria-label=\"Close\"]")).click();
     act.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"))).perform();
     WebElement list=driver.findElement(By.linkText("Alışveriş Listesi"));
     list.click();
     //“Favori Listem” sayfası açıldığı kontrol edilir.
     Assert.assertTrue(driver.findElement(By.id("profile-list-name")).getText().contains("Alışveriş Listesi"));
     //Eklenen ürün favorilerden silinir.
     WebElement remove= driver.findElement(By.xpath("//input[@name=\"submit.deleteItem\"]"));
     remove.click();
     //Silme işleminin gerçekleştiği kontrol edilir
     WebElement removed= driver.findElement(By.xpath("//div[text()=\"Silindi\"]"));
     Assert.assertTrue(removed.getText().contains("Silindi"));
     //Üye çıkış işlemi yapılır.
     act.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"))).perform();
     WebElement signOut=driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]/span"));
     signOut.click();
     //ıkış işleminin yapıldığı kontrol edilir.
     Assert.assertTrue(driver.findElement(By.xpath("//h1")).getText().contains("Giriş yap"));






















}


}
