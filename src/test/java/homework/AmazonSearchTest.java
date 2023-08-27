package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AmazonSearchTest  {
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

        //web sayfasına gidin. https://www.amazon.com/
        driver.get("http://amazon.com");

        //Search(ara) “city bike”
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);

        //Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        //WebElement aramaSonucYazisi = driver.findElement(By.className("sg-col-inner"));
        //System.out.println(aramaSonucYazisi.getText());
        List<WebElement> aramaSonucYazisi = driver.findElements(By.className("sg-col-inner"));
        System.out.println("Arama sonuc yazisi : " + aramaSonucYazisi.get(0).getText());

        //Arama sonuc sayisini konsola yazdiriniz.
        String [] sonucsayisi = aramaSonucYazisi.get(0).getText().split(" ");
        System.out.println("Sonuc sayisi : " + sonucsayisi[2]);

        //Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        List<WebElement> ilkWE = driver.findElements(By.className("s-image"));
        ilkWE.get(0).click();

    }
    }

