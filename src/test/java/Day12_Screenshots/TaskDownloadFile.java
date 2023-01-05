package Day12_Screenshots;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskDownloadFile extends BaseTest {

    // Go to https://the-internet.herokuapp.com/download
    //  Download sample.png file
    //  Then verify if the file downloaded successfully
    @Test
    public void testTaskDownload() throws InterruptedException {
        // Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
        //  Download sample.png file
        WebElement sample= driver.findElement(By.linkText("sample.png"));
        sample.click();
        Thread.sleep(5000);
        //  Then verify if the file downloaded successfully
        String Path = "C:\\Users\\seyitbey\\Downloads\\sample.png";
        Assert.assertTrue(Files.exists(Paths.get(Path)));
    }
}
