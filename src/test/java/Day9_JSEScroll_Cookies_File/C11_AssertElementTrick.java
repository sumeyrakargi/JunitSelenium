package Day9_JSEScroll_Cookies_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class C11_AssertElementTrick extends BaseTest {
    /*Go to URL: https://the-internet.herokuapp.com/upload
Find the path of the file that you want to upload.
Click on Upload button.
Verify the upload message.*/

    @Test
    public void fileUpload(){

        driver.get("https://the-internet.herokuapp.com/upload");

        //Upload edilecek dosyamizi seciyoruz
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        dosyaSec.sendKeys("C:\\Users\\seyitbey\\Downloads\\fileExist.png");

        // Upload butonuna basiyoruz
        WebElement uploadFile = driver.findElement(By.id("file-submit"));
        uploadFile.click();

        //Yeniden implement edecegiz

        // Elementin locator unu ozellikle yanlis yazip durumu nasil handle ettigimizi kontrol ediyoruz
        List<WebElement> uploadedMessageList = driver.findElements(By.tagName("h9"));
        Assert.assertEquals("Upload mesaji goruntulenemedi",1, uploadedMessageList.size());

        WebElement uploadMessage = uploadedMessageList.get(0);

        Assert.assertTrue(uploadMessage.isDisplayed());
        Assert.assertEquals("Mesajin texti istenilen gibi goruntulenemiyor","File Uploaded!", uploadMessage.getText());

    }

    }

