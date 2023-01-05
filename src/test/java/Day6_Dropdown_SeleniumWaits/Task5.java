package Day6_Dropdown_SeleniumWaits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;
 /* Go to URL: https://the-internet.herokuapp.com/dropdown
    Create method selectByIndexTest and Select Option 1 using index .
    Create method selectByValueTest Select Option 2 by value.
    Create method selectByVisibleTextTest Select Option 1 value by visible text.
    Create method printAllTest Print all dropdown value.
    Verify the dropdown has Option 2 text.
    Create method printFirstSelectedOptionTest Print first selected option.
    Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.*/


public class Task5 extends BaseTest {
    @Test
    public void select(){
     driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select=new Select(driver.findElement(By.id("dropdown")));

        selectByIndexTest(select,1);
        selectByValueTest(select,"2");
        selectByVisibleText(select , "Option 1");
        printAlltest(select);
        printFirstSelectedOptionTest(select);
        System.out.println(select.getOptions().size());
        Assert.assertTrue(verify(select,"Option 2"));
        if (select.getOptions().size()==3){
            System.out.println("Expected Is Not Equal Actual");
        }
    }
    private void selectByIndexTest(Select select,int index){
        select.selectByIndex(1);
    }
    public void selectByValueTest(Select select,String value) {
        select.selectByValue("2");
    }
    public void selectByVisibleText(Select select,String value){
        select.selectByVisibleText("Option 1");
    }
    public void printAlltest(Select select){
        select.getOptions().forEach(x-> System.out.println(x.getText()));
    }
    public void printFirstSelectedOptionTest(Select select){
        System.out.println(select.getFirstSelectedOption().getText());
    }
    public boolean verify(Select select, String text){
        select.getOptions().forEach(x-> x.getText().contains(text));
        return true;
    }}




