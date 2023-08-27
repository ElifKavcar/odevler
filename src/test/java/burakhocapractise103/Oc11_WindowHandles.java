package burakhocapractise103;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.Set;

public class Oc11_WindowHandles extends TestBase {
    @Test
    public void test01() {
        // https://www.n11.com adresine gidin
        driver.get("https://www.n11.com");
        String window1Handle = driver.getWindowHandle();

        //arama motoruna "oppo" yazip aratin
        driver.findElement(By.xpath("//*[@id='searchData']")).sendKeys("oppo"+ Keys.ENTER);

        //ilk ürüne tiklayin
        driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]")).click();

        //basligin 'oppo' icerdigini test edin

        Set<String> windowHandleSeti = driver.getWindowHandles();
        String sayfa2Handle ="";
        for (String each :windowHandleSeti) {
            if(!each.equals(window1Handle)){
                sayfa2Handle = each;
            }
        }
        driver.switchTo().window(sayfa2Handle);
        String sayfa2Baslik = driver.getTitle();
        Assert.assertTrue(sayfa2Baslik.contains("Oppo"));

        // ilk sayfaya donun ve title ini yazdirin
        driver.switchTo().window(window1Handle);
        System.out.println("ilk sayfanin title i : "+driver.getTitle());
    }
}

