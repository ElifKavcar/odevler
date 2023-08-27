package burakhocapractise103;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Oc12_Faker extends TestBase {
    @Test
    public void test01() {

        //https://www.facebook.com sayfasina gidiniz
        //yeni hesap olustur butonuna basiniz
        //isim kutusunu locate ediniz
        //geriye kalan alanlari TAB ile dolasarak faker bilgilerle doldurunuz

        //https://www.facebook.com sayfasina gidiniz
        driver.get("https://www.facebook.com");


                 //yeni hesap olustur butonuna basiniz
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

                //isim kutusunu locate ediniz
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));
        Faker faker= new Faker();
        String email = faker.internet().emailAddress();
        Actions actions = new Actions(driver);
        actions.click(isimKutusu).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("16").
                sendKeys(Keys.TAB).
                sendKeys("Nis").sendKeys(Keys.TAB).
                sendKeys("1980").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_LEFT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();




        //geriye kalan alanlari TAB ile dolasarak faker bilgilerle doldurunuz






    }
}
