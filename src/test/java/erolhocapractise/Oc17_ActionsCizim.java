package erolhocapractise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Oc17_ActionsCizim extends TestBase {

    @Test
    public void test01() {

        // http://szimek.github.io/signature_pad/ sayfasina gidiniz
        // Cikan ekrana istediginiz cizgi ya da sekli ciziniz
        // Cizimden sonra clear butonuna basalim
        // Son olarak sayfayi temizleyiniz


        // http:// szimek.github.io/signature_pad/ sayfasina gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        // Cikan ekrana istediginiz cizgi ya da sekli ciziniz
        WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver);
        actions.moveToElement(yaziTahtasi).clickAndHold();

        for (int i = 0; i <10 ; i++) {
            actions.moveByOffset(2,17);
        }
        actions.release().build().perform();

        // Cizimden sonra clear butonuna basalim
        waitFor(3);
        driver.findElement(By.xpath("//*[@data-action='clear']")).click();

        // Son olarak sayfayi temizleyiniz



    }
}

