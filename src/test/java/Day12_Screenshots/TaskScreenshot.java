package Day12_Screenshots;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*Go to URL: https://opensource-demo.orangehrmlive.com/
  Getting screenshot of  Orange HRM Page Section.
  Save the screenshot with format 'screenshotname_yyyy_MM_dd_hh_mm_ss.png'*/

public class TaskScreenshot extends BaseTest {
    @Test
    public void testTaskScreenshot() throws IOException {

        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //Getting screenshot of  Orange HRM Page Section.
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Save the screenshot with format 'screenshotname_yyyy_MM_dd_hh_mm_ss.png'
        String date = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date());
        String path = "test-output\\Screenshots\\Orangehrmlivescreen" + date + ".png";
        FileUtils.copyFile(source, new File(path));

    }
}
