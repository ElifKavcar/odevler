package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class EbaySayfa extends TestBase {
    @Test
    public void ebaySayfa() {
        // - ebay sayfasına gidiniz
        driver.get("https://ebay.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        // - electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        // - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        List<WebElement> resimler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
        for(int i=0;i<resimler.size();i++) {
            resimler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            resimler.get(i).click();

            // - Her sayfanın sayfa başlığını yazdıralım
            System.out.println(i+". Title ="+ driver.getTitle());
            driver.navigate().back();

        }

    }
}

