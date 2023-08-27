package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.time.Duration;
import java.util.List;

public class CityBike {
    public static void main(String[] args) {
        //    1.Bir class oluşturun : AmazonSearchTest
        //    2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        //            a.web sayfasına gidin. https://www.amazon.com/
        //    b.Search(ara) “city bike”
        //    c. Amazon'da görüntülenen ilgili sonuçların sayısını
        //    yazdırın
        //    d.Sonra karşınıza çıkan ilk sonucun resmine tıklayın

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //            a.web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //    b.Search(ara) “city bike”
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("city bike" + Keys.ENTER);

        //    c. Amazon'da görüntülenen ilgili sonuçların sayısını
        //    yazdırın
        WebElement aramaSonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Arama sonuc yazisi = " + aramaSonucYazisi.getText());

        String [] sonucSayisi = aramaSonucYazisi.getText().split(" ");
        System.out.println("Sonuc sayisi = "+ sonucSayisi[2]);


        //    d.Sonra karşınıza çıkan ilk sonucun resmine tıklayın
        List<WebElement> ilkWE = driver.findElements(By.xpath("//*[@class='s-image']"));
        ilkWE.get(0).click();




    }
}
