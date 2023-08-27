package erolhocapractise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Oc17_ExplicitWait extends TestBase {
    @Test
    public void test01() {
        //https://automationfc.github.io/dynamic-loading/ sayfasina gidelim
        //Start button una basalim
        //Hello World! yazisinin ciktigini dogrulayalim

        //https://automationfc.github.io/dynamic-loading/ sayfasina gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Start button una basalim
        driver.findElement(By.xpath("//*[.='Start']")).click();

        //Hello World! yazisinin ciktigini dogrulayalim
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Hello World!']")));

        assert driver.findElement(By.xpath("//*[text()='Hello World!']")).isDisplayed();
    }
}
