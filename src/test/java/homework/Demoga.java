package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Demoga extends TestBase {

    @Test
    public void test01() {

        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        //Alerts, Frame & Windows Butonuna click yap
        WebElement button = driver.findElement(By.xpath("(//h5)[3]"));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.moveToElement(button);
        button.click();
        waitFor(3);

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
      //  Assert.assertEquals("Please select an item from left to start practice.",driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']")).getText());
        Assert.assertTrue((driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']")).isDisplayed()));

       //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
       driver.findElement(By.xpath("(//*[@class='text'])[11]")).click();

       //New Tab butonunun görünür olduğunu doğrula
      Assert.assertTrue(driver.findElement(By.xpath("//*[@id='tabButton']")).isDisplayed());

      //New Tab butonuna click yap
      driver.findElement(By.xpath("//*[@id='tabButton']")).click();

               //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula //*[text()='This is a sample page']
       driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
      Assert.assertEquals("This is a sample page",driver.findElement(By.xpath("//*[text()='This is a sample page']")).getText());

                         //İlk Tab'a geri dön
      driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

                        //New Tab butonunun görünür olduğunu doğrula
      Assert.assertTrue(driver.findElement(By.xpath("//*[@id='tabButton']")).isDisplayed());
    }
}

