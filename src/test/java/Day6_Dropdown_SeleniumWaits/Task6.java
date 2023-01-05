package Day6_Dropdown_SeleniumWaits;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

/*Launch the browser.
            Open "https://demoqa.com/select-menu".
    Select the Standard Multi-Select using the element id.
    Verifying that the element is multi-select.
            Select 'Opel' using the index and deselect the same using index.
            Select 'Saab' using value and deselect the same using value.
    Deselect all the options.
    Close the browser.*/

public class Task6 extends BaseTest {
    @Override
    @After
    public void tearDown() {
        //super.tearDown();
    }
    @Test
    public void test(){
        driver.get("https://demoqa.com/select-menu");
        Select mltplslct=new Select(driver.findElement(By.id("cars")));
        System.out.println(mltplslct.isMultiple());
        mltplslct.selectByIndex(2);
        mltplslct.deselectByIndex(2);
        mltplslct.selectByValue("saab");
        mltplslct.deselectByValue("saab");
        mltplslct.getAllSelectedOptions();
        driver.close();
    }}
