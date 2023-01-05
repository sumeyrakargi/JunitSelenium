package Day12_Screenshots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class TaskUploadFile extends BaseTest {
    //Go to URL: https://www.monsterindia.com/seeker/registration
    //Upload file.

    @Test
    public void testUploadFile() {
        driver.get("https://www.monsterindia.com/seeker/registration");
        WebElement upLoad= driver.findElement(By.id("file-upload"));
        String cvPath="C:\\Users\\seyitbey\\Desktop\\resume.docx";
        upLoad.sendKeys(cvPath);
    }
}
