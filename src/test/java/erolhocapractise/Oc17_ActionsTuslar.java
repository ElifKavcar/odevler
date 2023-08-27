package erolhocapractise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Oc17_ActionsTuslar extends TestBase {
    @Test
    public void test01() {
        //https://jqueryui.com/slider/#colorpicker adresine gidiniz
        //Kutucuk icindeki rengi once kirmizi sonra sari yapiniz
        //Sari oldugunu test edelim

        //https://jqueryui.com/slider/#colorpicker adresine gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        WebElement iframe = driver.findElement(By.xpath("//*[@class='demo-frame']"));
        driver.switchTo().frame(iframe);

        //Kutucuk icindeki rengi once kirmizi sonra sari yapiniz
        WebElement yesilTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement maviTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(yesilTus,-170,0);
        actions.dragAndDropBy(maviTus,-80,0);
        actions.dragAndDropBy(yesilTus,301,0).release().build().perform();
        waitFor(3);


        //Sari oldugunu test edelim
        WebElement sari = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
        assert sari.isDisplayed();
    }
}
