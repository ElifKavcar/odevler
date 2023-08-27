package burakhocapractise103;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class Oc11_ActionMoveToElement extends TestBase {
    @Test
    public void test01() {


        //https://amazon.com adresine gidiniz
        //sag ust bolumde bulunan dil secenek menusunun acilmasi icin mouse u bu menunun ustune getirelim
        //Change country/region butonuna basiniz
        //United States dropdown undan 'Turkey(Türkiye)' seciniz
        //Go to website butonuna tiklayiniz
        //acilan yeni sayfasinin title inin Elektronik icerdigini test ediniz


        //https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String birinciSayfaHandle = driver.getWindowHandle();

        //sag ust bolumde bulunan dil secenek menusunun acilmasi icin mouse u bu menunun ustune getirelim
        Actions actions = new Actions(driver);
        WebElement dilsecenek = driver.findElement(By.xpath("(//span[@class='nav-line-2'])[1]"));
        actions.moveToElement(dilsecenek).perform();

        //Change country/region butonuna basiniz
        driver.findElement(By.xpath("//*[text()='Change country/region.']")).click();



        //United States dropdown undan 'Turkey(Türkiye)' seciniz
        WebElement ulke = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(ulke);
        select.selectByVisibleText("Turkey (Türkiye)");

        //Dropdown opsiyon listesi 'Go to Website' butonuna basmamiza engel oldugu icin
        //herhengi bir yere click yapip dropdown opsiyon listesinin toparlanmasini sagladik
        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();

        //Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//*[@class='a-button-input']")).click();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(birinciSayfaHandle);
        System.out.println(handles);
        String ikinciSayfa = "";

        //acilan yeni sayfasinin title inin Elektronik icerdigini test ediniz

        for (String each :handles) {
           if(!each.equals(birinciSayfaHandle)) {
               ikinciSayfa=each;
           }
        }

        driver.switchTo().window(ikinciSayfa);
        String yenisayfaTitle = driver.getTitle();
        System.out.println(yenisayfaTitle);
        Assert.assertTrue(yenisayfaTitle.contains("Elektronik"));
    }
}
