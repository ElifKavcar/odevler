package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import java.util.ArrayList;
import java.util.List;

public class ElemantalSelenium extends TestBase {
    @Test
    public void elemantalSelenium() {
        // -https://the-internet.herokuapp.com/windows sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/windows");

        // -Sayfada Elemental Selenium webelementinin görünür olduğunu test ediniz
        WebElement element = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(element.isDisplayed());

        //         -Elemental Selenium linkine tıklayınız
        element.click();

        //         -Açılan pencerede sayfa başlığının Elemental Selenium içerdiğini test ediniz

        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assert.assertTrue(driver.getTitle().contains("Elemental Selenium"));

        // -Url'in https://elementalselenium.com/ olduğunu doğrulayınız
        Assert.assertTrue(driver.getCurrentUrl().contains("https://elementalselenium.com"));

        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("rtgp@gmail.com");

        WebElement ddm = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Java");

        driver.findElement(By.xpath("//*[@type='submit']")).click();

        WebElement submit = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(submit.isDisplayed());
    }
}

