package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AmazonSamsung {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();


        // arama kutusunu locate edelim
        WebElement aramaKutusu =driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        // “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);

        // Bulunan sonuc sayisini yazdiralim
        WebElement aramasonucu = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(aramasonucu.getText());
        String [] sonucSayisi = aramasonucu.getText().split(" ");
        System.out.println("Sonuc sayisi = "+ sonucSayisi[2]);


        // Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
        driver.navigate().back();

        //Sayfadaki tum basliklari yazdiralim

        for (int i=0; i<24; i++) {
            List<WebElement> basliklar = driver.findElements(By.xpath("//h2"));

            System.out.println((i+1) +". Sayfa Basliklari = " + basliklar.get(i).getText());
            Thread.sleep(2000);

        }





    }

}
