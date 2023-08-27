package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class ZeroGrupOdev extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

            // 2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='button']")).click();
        Thread.sleep(2000);

// 3. Login alanine “username” yazdirin
// 4. Password alanine “password” yazdirin
// 5. Sign in buttonuna tiklayin

        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username"+ Keys.TAB+"password",Keys.TAB,Keys.TAB,Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();

// 6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click(); //online banking e tikladik
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click(); //paybills e tikladi




    // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        // 8. tarih kismina “2020-09-10” yazdirin
        // 9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("75"+Keys.TAB,"2020-09-10"+Keys.TAB,Keys.TAB,Keys.ENTER);
        Thread.sleep(3000);

// 10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        String payment = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']")).getText();
       /* if(payment.equals("The payment was successfully submitted.")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");*/

        Assert.assertEquals(payment,"The payment was successfully submitted.");


    }






}
