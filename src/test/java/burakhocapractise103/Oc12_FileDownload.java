package burakhocapractise103;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Oc12_FileDownload extends TestBase {

    @Test
    public void test01() {
        // 1. https://the-internet.herokuapp.com/download adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        // 2.some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//*[@href='download/some-file.txt']")).click();

        // 3. dosyanin basarıyla indirilip indirilmedigini test edelim (dosya downloads a indirilecektir.)
        //C:\Users\HP      \Downloads\some-file.txt
        //String dosyaYolu = "C:\\Users\\HP\\Downloads\\some-file.txt";

        String farkliKisim =System.getProperty("user.home");
        String ayniKisim = "\\Downloads\\some-file.txt";

        String dosyaYolu2 = farkliKisim+ayniKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));









    }
}
