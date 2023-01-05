package Day10_GarryTasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class Task1 extends BaseTest {

    @Test
    public void test(){

        /*
   1- https://www.amazon.com/ sayfasına gidelim.
   2- Arama kutusunu locate edelim.
   3- "Samsung headphones" ile arama yapalım.
   4- Bulunan sonuç sayısını yazdıralım.
   5- İlk ürünü tıklayalım.
   6- Sayfadaki tüm ürün başlıklarını yazdıralım.
*/

        driver.get("https://www.amazon.com/ ");
        WebElement searhBox= driver.findElement(By.id("twotabsearchtextbox"));
        searhBox.sendKeys("Samsung headphones"+ Keys.ENTER);
        WebElement result= driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]"));
        System.out.println(result.getText());
        WebElement firstProduct = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        firstProduct.click();

        driver.navigate().back();

        List <WebElement> allProducts = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement each: allProducts) {
            System.out.println(each.getText());

        }
    }
}
