package Day9_JSEScroll_Cookies_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C10_FileUpload extends BaseTest {

    /*Go to URL: https://the-internet.herokuapp.com/upload
Find the path of the file that you want to upload.
Click on Upload button.
Verify the upload message.*/

    @Test
    public void fileUpload(){
       driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dosyaseç=driver.findElement(By.id("file-upload"));
        dosyaseç.sendKeys("C:\\Users\\seyitbey\\Downloads\\fileExist.png");
        WebElement uploadFile=driver.findElement(By.id("file-submit"));
        uploadFile.click();

        WebElement uploadMessage=driver.findElement(By.tagName("h3"));

        Assert.assertTrue(uploadMessage.isDisplayed());
        Assert.assertEquals("File Uploaded!",uploadMessage.getText());

    }
}
