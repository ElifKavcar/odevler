package burakhocapractise103;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

public class Oc11_WindowHandle extends TestBase {

    @Test
    public void test01() {

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaHandle = driver.getWindowHandle();

        // 2- url'nin 'amazon' icerdigini test edelim
        String amazonUrl = driver.getCurrentUrl();
        Assert.assertTrue(amazonUrl.contains("amazon"));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyHandle = driver.getWindowHandle();

        // 4-title in 'Best Buy' icerdigini test edelim
        String bestbuyTitle = driver.getTitle();
        Assert.assertTrue(bestbuyTitle.contains("Best Buy"));

        // 5-ilk sayfaya donup (amazon) java aratalim
        driver.switchTo().window(ilkSayfaHandle);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("java", Keys.ENTER);
waitFor(2);

        // 6- arama sonuclarinin 'Java' icerdigini test edelim
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String aramaSonucuText = aramaSonucu.getText();
        Assert.assertTrue(aramaSonucuText.contains("java"));
waitFor(2);
        // 7- ikinci sayfaya donelim
        driver.switchTo().window(bestBuyHandle);

        // 8- logonun gorundugunu test edelim
        WebElement logo =driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }
}
